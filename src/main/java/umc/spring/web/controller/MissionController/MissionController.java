package umc.spring.web.controller.MissionController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.dto.MissionDTO.MissionRequestDTO;
import umc.spring.dto.MissionDTO.MissionResponseDTO;
import umc.spring.service.MissionService.MissionCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addMission(@RequestBody @Valid MissionRequestDTO.AddMissionDto request){
        Mission mission = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }
}
