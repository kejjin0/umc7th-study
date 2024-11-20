package umc.spring.dto.MemberMissionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import umc.spring.validation.annotation.ExistMemberMission;
import umc.spring.validation.annotation.ExistMembers;
import umc.spring.validation.annotation.ExistMission;

@Data
@ExistMemberMission
public class MemberMissionRequestDTO {
    @Getter
//    @ExistMemberMission 여기에 두면 잘못된 요청이라고 에러뜸
    public static class AddMemberMissionDto{
        @NotNull
        Integer status;
        @ExistMembers
        Long member;
        @ExistMission
        Long mission;
    }
}
