package umc.spring.service.StoreService;

import umc.spring.domain.Store;
import umc.spring.dto.StoreDTO.StoreRequestDTO;

public interface StoreCommandService {
    public Store addStore(StoreRequestDTO.AddStoreDTO request);
}