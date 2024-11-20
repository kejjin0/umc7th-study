package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.dto.MissionDTO.MissionRequestDTO;
import umc.spring.dto.MissionDTO.MissionResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.AddMissionResultDTO toAddMissionResultDTO(Mission mission) {
        return MissionResponseDTO.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.AddMissionDto request){

        return Mission.builder()
                .reward(request.getReward())
                .price(request.getPrice())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }
}
