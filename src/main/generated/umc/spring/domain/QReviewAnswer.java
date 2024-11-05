package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReviewAnswer is a Querydsl query type for ReviewAnswer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewAnswer extends EntityPathBase<ReviewAnswer> {

    private static final long serialVersionUID = -275947550L;

    public static final QReviewAnswer reviewAnswer = new QReviewAnswer("reviewAnswer");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReviewAnswer(String variable) {
        super(ReviewAnswer.class, forVariable(variable));
    }

    public QReviewAnswer(Path<? extends ReviewAnswer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReviewAnswer(PathMetadata metadata) {
        super(ReviewAnswer.class, metadata);
    }

}

