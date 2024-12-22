package umc.spring.service.ReviewService;

import umc.spring.domain.Review;

import java.util.Optional;

public interface ReviewQueryService {
    Optional<Review> getReviewById(Long id);
    void saveReview(Review review);
}
