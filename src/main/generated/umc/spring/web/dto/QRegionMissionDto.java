package umc.spring.web.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * umc.spring.web.dto.QRegionMissionDto is a Querydsl Projection type for RegionMissionDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QRegionMissionDto extends ConstructorExpression<RegionMissionDto> {

    private static final long serialVersionUID = -486359794L;

    public QRegionMissionDto(com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<Integer> price, com.querydsl.core.types.Expression<Integer> reward, com.querydsl.core.types.Expression<Long> missionId, com.querydsl.core.types.Expression<Integer> dday) {
        super(RegionMissionDto.class, new Class<?>[]{String.class, int.class, int.class, long.class, int.class}, name, price, reward, missionId, dday);
    }

}

