package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionResponseDTO;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/mission")
public class MemberMissionController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.AddMemberMissionResultDTO> addMemberMission(@RequestBody @Valid MemberMissionRequestDTO.AddMemberMissionDto request){
        MemberMission memberMission = memberMissionCommandService.addMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toAddMemberMissionResultDTO(memberMission));
    }
}
