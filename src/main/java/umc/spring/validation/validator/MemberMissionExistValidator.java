package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionRequestDTO;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.validation.annotation.ExistMemberMission;

@Component
@RequiredArgsConstructor
public class MemberMissionExistValidator implements ConstraintValidator<ExistMemberMission, MemberMissionRequestDTO.AddMemberMissionDto> {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(ExistMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO.AddMemberMissionDto value, ConstraintValidatorContext context) {
        boolean exist = memberMissionRepository.existsByMemberIdAndMissionId(value.getMember(), value.getMission());
        boolean isValid = !exist;
        System.out.println("isValid =" + isValid);
        System.out.println("Member = " + value.getMember());
        System.out.println("Mission = " + value.getMission());
        if (!isValid) {
            System.out.println("존재해서 문제 발생 ㄱ");
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(String.valueOf(ErrorStatus.MEMBER_MISSION_EXIST)).addConstraintViolation();
        }

        return isValid;
    }
}
