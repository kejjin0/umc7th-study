package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.el.parser.BooleanNode;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMission;
import umc.spring.domain.QStore;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.dto.QRegionMissionDto;
import umc.spring.dto.QUserMissionDto;
import umc.spring.dto.RegionMissionDto;
import umc.spring.dto.UserMissionDto;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<UserMissionDto> findMissionsByUserIdAndStatus(Long userId, MissionStatus status, Long currentMissionId) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(userId != null){
            predicate.and(memberMission.member.id.eq(userId));
        }

        if(status != null){
            predicate.and(memberMission.status.eq(status));
        }

        if(currentMissionId != null){
            predicate.and(memberMission.mission.id.gt(currentMissionId));
        }

        return jpaQueryFactory
                .select(new QUserMissionDto(store.name, mission.missionSpec, mission.reward, mission.price, mission.id))
                .from(memberMission)
                .innerJoin(mission).on(memberMission.mission.id.eq(mission.id))
                .innerJoin(store).on(mission.store.id.eq(store.id))
                .where(predicate)
                .orderBy(memberMission.id.desc())
                .limit(15).fetch();

    }

    @Override
    public List<RegionMissionDto> findRegionMissionsByRegionIdAndMemberId(Long regionId, Long memberId, Long currentMissionId) {
        return jpaQueryFactory
                .select(new QRegionMissionDto(store.name, mission.price, mission.reward, mission.id, Expressions.numberTemplate(Integer.class, "DATEDIFF({0}, NOW())", mission.deadline)))
                .from(mission)
                .innerJoin(store).on(mission.store.id.eq(store.id))
                .where(
                        mission.id.notIn(
                                JPAExpressions
                                .select(memberMission.mission.id)
                                .from(memberMission)
                                .where(memberMission.member.id.eq(memberId)))
                        .and(store.region.id.eq(regionId))
                        .and(mission.id.gt(currentMissionId)))
                .orderBy(mission.id.desc())
                .limit(15)
                .fetch();
    }
}