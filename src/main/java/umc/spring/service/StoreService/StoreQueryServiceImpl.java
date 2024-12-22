package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("store : " + store));

        return filteredStores;
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page){
        Store store = storeRepository.findById(storeId).get();
        Page<Review> storePage = reviewRepository.findAllByStore(store, PageRequest.of(page,10));
        return storePage;
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();
        Page<Mission> missionPage = missionRepository.findAllByStore(store, PageRequest.of(page,10));
        return missionPage;
    }
}
