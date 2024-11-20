package umc.spring.service.MissionService;

import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.dto.MissionDTO.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMission(MissionRequestDTO.AddMissionDto request);
}
