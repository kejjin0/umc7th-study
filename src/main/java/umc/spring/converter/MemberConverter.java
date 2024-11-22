package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.dto.MemberRequestDto;
import umc.spring.dto.MemberResponseDto;

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
}
