package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.dto.RegionMissionDto;
import umc.spring.dto.UserMissionDto;
import umc.spring.repository.MissionRepository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;

    @Override
    public List<UserMissionDto> findMissionsByUserIdAndStatus(Long userId, MissionStatus status, Long currentMissionId) {
        List<UserMissionDto> filteredMissions = missionRepository.findMissionsByUserIdAndStatus(userId, status, currentMissionId);
        filteredMissions.forEach(UserMissionDto -> System.out.println("user mission : " + UserMissionDto));
        return filteredMissions;
    }

    @Override
    public List<RegionMissionDto> findRegionMissionsByRegionIdAndMemberId(Long regionId, Long memberId, Long currentMissionId) {
        List<RegionMissionDto> filteredMissions = missionRepository.findRegionMissionsByRegionIdAndMemberId(regionId, memberId, currentMissionId);
        filteredMissions.forEach(RegionMissionDto -> System.out.println("region mission : " + RegionMissionDto));
        return filteredMissions;
    }
}
