package umc.spring.repository.MissionRepository;

import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.RegionMissionDto;
import umc.spring.web.dto.UserMissionDto;

import java.util.List;

public interface MissionRepositoryCustom {
    List<UserMissionDto> findMissionsByUserIdAndStatus(Long userId, MissionStatus status, Long currentMissionId);
    List<RegionMissionDto> findRegionMissionsByRegionIdAndMemberId(Long regionId, Long memberId, Long currentMissionId);
}
