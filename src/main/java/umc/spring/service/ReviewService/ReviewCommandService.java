package umc.spring.service.ReviewService;

import org.springframework.web.multipart.MultipartFile;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(ReviewRequestDTO.AddReviewDto request, MultipartFile reviewPicture);
    void deleteReview(Long reviewId);
}
