package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberDTO.MemberRequestDto;
import umc.spring.web.dto.MemberDTO.MemberResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {
    public static MemberResponseDto.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDto.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDto.JoinDto request){
        Gender gender = null;
        switch(request.getGender()){
            case 1:
                gender=Gender.MALE;
                break;
                case 2:
                    gender = Gender.FEMALE;
                    break;
                    case 3:
                        gender = Gender.NONE;
        }
        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .birthyYear(request.getBirthYear())
                .birthyMonth(request.getBirthMonth())
                .birthyDay(request.getBirthDay())
                .build();
    }

    public static MemberResponseDto.MemberReviewPreviewDTO memberReviewPreViewDTO(Review review){
        return MemberResponseDto.MemberReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getNickname())
                .score(review.getStars())
                .createdAt(review.getCreatedAt())
                .description(review.getDescription())
                .build();
    }

    public static MemberResponseDto.MemberReviewPreviewListDTO memberReviewPreviewListDTO(Page<Review> reviewList){
        List<MemberResponseDto.MemberReviewPreviewDTO> memberReviewPreViewDTOList = reviewList.stream()
                .map(MemberConverter::memberReviewPreViewDTO).collect(Collectors.toList());

        return MemberResponseDto.MemberReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPages(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(memberReviewPreViewDTOList.size())
                .reviewList(memberReviewPreViewDTOList)
                .build();
    }

    public static MemberResponseDto.ChanllengingMissionPreviewDTO chanllengingMissionPreviewDTO(MemberMission memberMission){
        Mission mission = memberMission.getMission();
        Integer price = mission.getPrice();
        Integer reward = mission.getReward();
        float percentage = (float) reward /price * 100;

        return MemberResponseDto.ChanllengingMissionPreviewDTO.builder()
                .storeName(mission.getStore().getName())
                .price(price)
                .rewards(reward)
                .percentage((int)percentage)
                .memberMissionId(memberMission.getId())
                .build();
    }

    public static MemberResponseDto.ChanllengingMissionPreViewListDTO chanllengingMissionPreViewListDTO(Page<MemberMission> missionList){
        List<MemberResponseDto.ChanllengingMissionPreviewDTO> chanllengingMissionPreviewDTOList = missionList.stream()
                .map(MemberConverter::chanllengingMissionPreviewDTO).collect(Collectors.toList());

        return MemberResponseDto.ChanllengingMissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPages(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(chanllengingMissionPreviewDTOList.size())
                .missionList(chanllengingMissionPreviewDTOList)
                .build();
    }

    public static MemberResponseDto.modifyMemberMissionStatusDTO modifyMemberMissionStatusDTO(MemberMission memberMission){
        return MemberResponseDto.modifyMemberMissionStatusDTO.builder()
                .missionId(memberMission.getMission().getId())
                .updatedAt(memberMission.getUpdatedAt())
                .status(memberMission.getStatus().toString())
                .build();
    }
}
