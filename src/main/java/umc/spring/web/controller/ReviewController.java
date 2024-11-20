package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConvert;
import umc.spring.domain.Review;
import umc.spring.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.dto.ReviewDTO.ReviewResponseDTO;
import umc.spring.service.ReviewService.ReviewCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.AddReviewDTO> addReview(@RequestBody @Valid ReviewRequestDTO.AddReviewDto request){
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConvert.toAddReviewResultDTO(review));
    }
}
