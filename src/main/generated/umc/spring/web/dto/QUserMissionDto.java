package umc.spring.web.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * umc.spring.web.dto.QUserMissionDto is a Querydsl Projection type for UserMissionDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserMissionDto extends ConstructorExpression<UserMissionDto> {

    private static final long serialVersionUID = -999651611L;

    public QUserMissionDto(com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> missionSpec, com.querydsl.core.types.Expression<Integer> reward, com.querydsl.core.types.Expression<Integer> price, com.querydsl.core.types.Expression<Long> missionId) {
        super(UserMissionDto.class, new Class<?>[]{String.class, String.class, int.class, int.class, long.class}, name, missionSpec, reward, price, missionId);
    }

}

