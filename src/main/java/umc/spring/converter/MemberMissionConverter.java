package umc.spring.converter;

import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.AddMemberMissionResultDTO toAddMemberMissionResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.AddMemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.AddMemberMissionDto request) {
        MissionStatus missionStatus = null;
        switch (request.getStatus()){
            case 1:
                missionStatus=MissionStatus.CHALLENGING;
                break;
                case 2:
                    missionStatus=MissionStatus.COMPLETED;
                    break;
        }

        return MemberMission.builder()
                .status(missionStatus)
                .build();

    }
}
