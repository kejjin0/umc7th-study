package umc.spring.dto;

import com.querydsl.core.annotations.QueryProjection;

public class MypageDto {
    private String nickname;
    private String email;
    private Integer point;

    @QueryProjection
    public MypageDto(String nickname, String email, Integer point) {
        this.nickname = nickname;
        this.email = email;
        this.point = point;
    }

    @Override
    public String toString() {
        return "Mypage { " +
                "nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", point=" + point +
                "}";
    }
}
