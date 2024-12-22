package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;
import umc.spring.repository.RegionRepository.RegionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.AddStoreDTO request){
        Store newStore = StoreConverter.ToStore(request);
        Region region = regionRepository.findById(request.getRegion())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        newStore.setRegion(region);
        return storeRepository.save(newStore);
    }
}
