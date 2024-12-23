package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConvert {
    public static ReviewResponseDTO.AddReviewDTO toAddReviewResultDTO(Review review) {
        return ReviewResponseDTO.AddReviewDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static ReviewResponseDTO.DeleteReviewDTO toDeleteReviewResultDTO(Long reviewId) {
        return ReviewResponseDTO.DeleteReviewDTO.builder()
                .reviewId(reviewId)
                .build();
    }

    public static Review toReview(ReviewRequestDTO.AddReviewDto request){
        return Review.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .stars(request.getStars())
                .build();
    }

    public static ReviewImage toReviewImage(String imageUrl, Review review) {
        return ReviewImage.builder()
                .imageUrl(imageUrl)
                .review(review)
                .build();
    }
}
