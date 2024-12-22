package umc.spring.service.MissionService;

import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.RegionMissionDto;
import umc.spring.web.dto.UserMissionDto;

import java.util.List;

public interface MissionQueryService {
    List<UserMissionDto> findMissionsByUserIdAndStatus(Long userId, MissionStatus status, Long currentMissionId);

    List<RegionMissionDto> findRegionMissionsByRegionIdAndMemberId(Long regionId, Long memberId, Long currentMissionId);
}
