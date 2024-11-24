package umc.spring.web.controller.MemberController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.MemberRequestDto;
import umc.spring.dto.MemberResponseDto;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistMembers;
import umc.spring.validation.annotation.NotExistMemberMission;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDto.JoinResultDTO> join(@RequestBody @Valid MemberRequestDto.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary="특정 멤버가 작성한 리뷰 목록 조회 API", description = "특정 멤버가 작성한 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요.", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name="memberId", description = "멤버의 아이디, path variable입니다1")
    })
    public ApiResponse<MemberResponseDto.MemberReviewPreviewListDTO> getMemberReviewList(@ExistMembers @PathVariable(name="memberId") Long memberId, @CheckPage Integer page){
        // argument resolver와 @RequestParam은 함꼐 작동되지 않아 argument resolver가 실행되도록 @CheckPage 어노테이션만 작성함.
        Page<Review> reviewList = memberCommandService.getMemberReviewList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.memberReviewPreviewListDTO(reviewList));
    }

    @GetMapping("/{memberId}/missions/chanllenging")
    @Operation(summary="특정 멤버가 진행 중인 미션 목록 조회 API", description = "특정 멤버가 진행 중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요.", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name="memberId", description = "멤버의 아이디, path variable입니다1")
    })
    public ApiResponse<MemberResponseDto.ChanllengingMissionPreViewListDTO> getChanllengeMissionList(@ExistMembers @PathVariable(name="memberId") Long memberId, @CheckPage Integer page){
        // argument resolver와 @RequestParam은 함꼐 작동되지 않아 argument resolver가 실행되도록 @CheckPage 어노테이션만 작성함.
        Page<MemberMission> memberMissionList = memberCommandService.getChallengeMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.chanllengingMissionPreViewListDTO(memberMissionList));
    }

    @GetMapping("/member/missions/{memberMissionId}")
    @Operation(summary = "특정 멤버가 진행 중인 미션 진행 완료로 수정 API", description = "특정 멤버가 진행 중인 미션을 진행 완료로 수정하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요.", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name="memberMissionId", description = "멤버의 미션 아이디, path variable입니다1")
    })
    public ApiResponse<MemberResponseDto.modifyMemberMissionStatusDTO> modifyMemberMissionStatus(@NotExistMemberMission @PathVariable(name="memberMissionId") Long memberMissoinId){
        MemberMission memberMission = memberCommandService.modifyMemberMissionStatus(memberMissoinId);
        return ApiResponse.onSuccess(MemberConverter.modifyMemberMissionStatusDTO(memberMission));
    }
}
