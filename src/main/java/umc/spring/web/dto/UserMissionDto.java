package umc.spring.web.dto;

import com.querydsl.core.annotations.QueryProjection;

public class UserMissionDto {
    private String name;

    private String missionSpec;

    private Integer reward;

    private Integer price;

    private Long missionId;

    @QueryProjection
    public UserMissionDto(String name, String missionSpec, Integer reward, Integer price, Long missionId) {
        this.name = name;
        this.missionSpec = missionSpec;
        this.reward = reward;
        this.price = price;
        this.missionId = missionId;
    }

    @Override
    public String toString(){
        return "mission{ " +
                "name='" + name + '\'' +
                ", missionSpec='" + missionSpec + '\'' +
                ", reward=" + reward +
                ", price=" + price +
                ", missionId=" + missionId +
                "}";
    }
}
