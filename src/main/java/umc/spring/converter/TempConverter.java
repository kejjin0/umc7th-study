package umc.spring.converter;

import umc.spring.web.dto.TempResponse;

public class TempConverter {
    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test")
                .build();
    }

    public static TempResponse.TempExcpetionDTO toTempExcpetionDTO(Integer flag){
        return TempResponse.TempExcpetionDTO.builder()
                .flag(flag)
                .build();
    }
}
