package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewAnswerAlarm is a Querydsl query type for ReviewAnswerAlarm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewAnswerAlarm extends EntityPathBase<ReviewAnswerAlarm> {

    private static final long serialVersionUID = 1650706319L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewAnswerAlarm reviewAnswerAlarm = new QReviewAnswerAlarm("reviewAnswerAlarm");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final EnumPath<umc.spring.domain.enums.ConfirmStatus> confirm = createEnum("confirm", umc.spring.domain.enums.ConfirmStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final QReviewAnswer reviewAnswer;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReviewAnswerAlarm(String variable) {
        this(ReviewAnswerAlarm.class, forVariable(variable), INITS);
    }

    public QReviewAnswerAlarm(Path<? extends ReviewAnswerAlarm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewAnswerAlarm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewAnswerAlarm(PathMetadata metadata, PathInits inits) {
        this(ReviewAnswerAlarm.class, metadata, inits);
    }

    public QReviewAnswerAlarm(Class<? extends ReviewAnswerAlarm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
        this.reviewAnswer = inits.isInitialized("reviewAnswer") ? new QReviewAnswer(forProperty("reviewAnswer")) : null;
    }

}

