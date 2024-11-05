package umc.spring.dto;

import com.querydsl.core.annotations.QueryProjection;

public class RegionMissionDto {
    private String name;
    private Integer price;
    private Integer reward;
    private Long missionId;
    private Integer dday;

    @QueryProjection
    public RegionMissionDto(String name, Integer price, Integer reward, Long missionId, Integer dday){
        this.name = name;
        this.price = price;
        this.reward = reward;
        this.missionId = missionId;
        this.dday = dday;
    }

    @Override
    public String toString() {
        return "mission{ " +
                "name='" + name + '\'' +
                ", price=" + price +
                ", reward=" + reward +
                ", missionId=" + missionId +
                ", dday=" + dday +
                "}";
    }
}
