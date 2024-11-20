package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.dto.ReviewDTO.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(ReviewRequestDTO.AddReviewDto request);
}
