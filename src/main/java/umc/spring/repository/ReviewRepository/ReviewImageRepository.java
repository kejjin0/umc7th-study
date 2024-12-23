package umc.spring.repository.ReviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.ReviewImage;

import java.util.List;

public interface ReviewImageRepository extends JpaRepository<ReviewImage, Long> {
    public List<ReviewImage> findByReviewId(Long id);
}
