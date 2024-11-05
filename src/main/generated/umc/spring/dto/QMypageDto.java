package umc.spring.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * umc.spring.dto.QMypageDto is a Querydsl Projection type for MypageDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMypageDto extends ConstructorExpression<MypageDto> {

    private static final long serialVersionUID = -69252265L;

    public QMypageDto(com.querydsl.core.types.Expression<String> nickname, com.querydsl.core.types.Expression<String> email, com.querydsl.core.types.Expression<Integer> point) {
        super(MypageDto.class, new Class<?>[]{String.class, String.class, int.class}, nickname, email, point);
    }

}

