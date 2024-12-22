package umc.spring.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMember;
import umc.spring.web.dto.MypageDto;
import umc.spring.web.dto.QMypageDto;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public List<MypageDto> findMyPageInfoByMemberId(Long memberId) {

        return jpaQueryFactory
                .select(new QMypageDto(member.nickname, member.email, member.point))
                .from(member)
                .where(member.id.eq(memberId))
                .fetch();
    }
}
