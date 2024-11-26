package umc.spring.web.dto.MissionDTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class AddMissionDto {
        @NotNull
        Integer reward;
        @NotNull
        Integer price;
        @NotNull
        LocalDate deadline;
        @NotNull
        String missionSpec;
        @NotNull
        Long store;
    }
}
