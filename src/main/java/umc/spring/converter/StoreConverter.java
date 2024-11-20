package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.dto.StoreDTO.StoreRequestDTO;
import umc.spring.dto.StoreDTO.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StoreConverter {

    public static StoreResponseDTO.AddStoreResultDTO toAddStoreResultDTO(Store store) {
        return StoreResponseDTO.AddStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store ToStore(StoreRequestDTO.AddStoreDTO request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

}
