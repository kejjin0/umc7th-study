package umc.spring.web.dto.MemberDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class MemberResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        Long memberId;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberReviewPreviewListDTO{
        List<MemberReviewPreviewDTO> reviewList;
        Integer listSize;
        Integer totalPages;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberReviewPreviewDTO{
        String ownerNickname;
        Float score;
        String description;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChanllengingMissionPreViewListDTO{
        List<ChanllengingMissionPreviewDTO> missionList;
        Integer listSize;
        Integer totalPages;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChanllengingMissionPreviewDTO{
        String storeName;
        Integer price;
        Integer rewards;
        Integer percentage;
        Long memberMissionId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class modifyMemberMissionStatusDTO{
        Long missionId;
        String status;
        LocalDateTime updatedAt;
    }
}
