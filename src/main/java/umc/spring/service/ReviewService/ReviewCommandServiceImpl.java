package umc.spring.service.ReviewService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.apiPayload.exception.handler.TempHandler;
import umc.spring.aws.s3.AmazonS3Manager;
import umc.spring.converter.ReviewConvert;
import umc.spring.domain.*;
import umc.spring.repository.ReviewRepository.ReviewImageRepository;
import umc.spring.repository.UuidRepository.UuidRepository;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final AmazonS3Manager amazonS3Manager;
    private final UuidRepository uuidRepository;
    private final ReviewImageRepository reviewImageRepository;

    @Override
    @Transactional
    public Review addReview(@RequestBody @Valid ReviewRequestDTO.AddReviewDto request, MultipartFile reviewPicture) {
        Review newReview = ReviewConvert.toReview(request);

        String uuid = UUID.randomUUID().toString();
        Uuid savedUuid = uuidRepository.save(Uuid.builder()
                .uuid(uuid).build());

        String pictureUrl = amazonS3Manager.uploadFile(amazonS3Manager.generateReviewKeyName(savedUuid), reviewPicture);

        Member member = memberRepository.findById(request.getMember())
                .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(request.getStore())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        newReview.setMember(member);
        newReview.setStore(store);

        reviewImageRepository.save(ReviewConvert.toReviewImage(pictureUrl, newReview));
        return reviewRepository.save(newReview);
    }

    @Override
    @Transactional
    public void deleteReview(Long reviewId) {
        List<ReviewImage> reviewImages = reviewImageRepository.findByReviewId(reviewId);
        for(ReviewImage reviewImage : reviewImages) {
            amazonS3Manager.deleteFile(reviewImage.getImageUrl());
            System.out.println(reviewImage.getImageUrl());
        }
        reviewRepository.deleteById(reviewId);
    }

}