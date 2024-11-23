package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.MemberMissionNotExistValidation;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberMissionNotExistValidation.class)
@Target( {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER} )
@Retention(RetentionPolicy.RUNTIME)
public @interface NotExistMemberMission {
    String message() default "진행 중이지 않은 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
