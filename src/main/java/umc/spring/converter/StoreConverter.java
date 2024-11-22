package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Region;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.dto.MissionDTO.MissionResponseDTO;
import umc.spring.dto.StoreDTO.StoreRequestDTO;
import umc.spring.dto.StoreDTO.StoreResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getNickname())
                .score(review.getStars())
                .createdAt(review.getCreatedAt())
                .body(review.getDescription())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList) {
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.StoreMissionDTO missionDTO(Mission mission) {
        LocalDate now = LocalDate.now();
        long dDay = ChronoUnit.DAYS.between(now, mission.getDeadline());

        return StoreResponseDTO.StoreMissionDTO.builder()
                .id(mission.getId())
                .reward(mission.getReward())
                .price(mission.getPrice())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .dDay(dDay)
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static StoreResponseDTO.StoreMissionListDTO missionListDTO(Page<Mission> missionList) {
        List<StoreResponseDTO.StoreMissionDTO> missionDtoList = missionList.stream()
                .map(StoreConverter::missionDTO).collect(Collectors.toList());

        return StoreResponseDTO.StoreMissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionDtoList.size())
                .missionList(missionDtoList)
                .build();
    }

}
