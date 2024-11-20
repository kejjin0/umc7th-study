package umc.spring.service.MemberMissionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.MemberMissionDTO.MemberMissionRequestDTO;
import umc.spring.dto.MemberMissionDTO.MemberMissionResponseDTO;

public interface MemberMissionCommandService {
    MemberMission addMemberMission(MemberMissionRequestDTO.AddMemberMissionDto request);
}
