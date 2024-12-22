package umc.spring.service.MemberMissionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission addMemberMission(MemberMissionRequestDTO.AddMemberMissionDto request);
}
