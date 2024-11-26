package umc.spring.web.dto.ReviewDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistMembers;
import umc.spring.validation.annotation.ExistStores;

public class ReviewRequestDTO {
    @Getter
    public static class AddReviewDto{
        @NotNull
        String title;
        @NotNull
        String description;
        @Min(1) @Max(5)
        @NotNull
        Float stars;
        @ExistMembers
        Long member;
        @ExistStores
        Long store;
    }


}
