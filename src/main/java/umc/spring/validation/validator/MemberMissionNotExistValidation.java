package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.validation.annotation.NotExistMemberMission;

@Component
@RequiredArgsConstructor
public class MemberMissionNotExistValidation implements ConstraintValidator<NotExistMemberMission, Long> {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(NotExistMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = memberMissionRepository.existsById(value);

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
