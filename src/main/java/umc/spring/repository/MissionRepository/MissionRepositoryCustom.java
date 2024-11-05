package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.dto.RegionMissionDto;
import umc.spring.dto.UserMissionDto;

import java.util.List;

public interface MissionRepositoryCustom {
    List<UserMissionDto> findMissionsByUserIdAndStatus(Long userId, MissionStatus status, Long currentMissionId);
    List<RegionMissionDto> findRegionMissionsByRegionIdAndMemberId(Long regionId, Long memberId, Long currentMissionId);
}
