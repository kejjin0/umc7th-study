package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConvert;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;
import umc.spring.service.ReviewService.ReviewCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping(value="/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ApiResponse<ReviewResponseDTO.AddReviewDTO> addReview(@Parameter(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
                                                                     @RequestPart("request") @Valid ReviewRequestDTO.AddReviewDto request,
                                                                 @RequestPart("reviewPicture") MultipartFile reviewPicture){
        Review review = reviewCommandService.addReview(request, reviewPicture);
        return ApiResponse.onSuccess(ReviewConvert.toAddReviewResultDTO(review));
    }

    @DeleteMapping("/{reviewId}")
    public ApiResponse<ReviewResponseDTO.DeleteReviewDTO> deleteReview(@PathVariable(name="reviewId") Long reviewId){
        reviewCommandService.deleteReview(reviewId);
        return ApiResponse.onSuccess(ReviewConvert.toDeleteReviewResultDTO(reviewId));
    }
}
