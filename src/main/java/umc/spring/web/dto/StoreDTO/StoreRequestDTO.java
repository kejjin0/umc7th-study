package umc.spring.web.dto.StoreDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.domain.Region;

import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class AddStoreDTO{
        @NotBlank
        String name;
        @Size(min = 5, max = 50)
        String address;
        @NotNull
        Long region;
//        List<Long> missionList;
//        List<Long> reivewList;
    }
}
