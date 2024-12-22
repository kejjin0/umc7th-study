package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAskAnswerAlarm is a Querydsl query type for AskAnswerAlarm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAskAnswerAlarm extends EntityPathBase<AskAnswerAlarm> {

    private static final long serialVersionUID = 50769062L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAskAnswerAlarm askAnswerAlarm = new QAskAnswerAlarm("askAnswerAlarm");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final QAskAnswer askAnswer;

    public final EnumPath<umc.spring.domain.enums.ConfirmStatus> confirm = createEnum("confirm", umc.spring.domain.enums.ConfirmStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAskAnswerAlarm(String variable) {
        this(AskAnswerAlarm.class, forVariable(variable), INITS);
    }

    public QAskAnswerAlarm(Path<? extends AskAnswerAlarm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAskAnswerAlarm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAskAnswerAlarm(PathMetadata metadata, PathInits inits) {
        this(AskAnswerAlarm.class, metadata, inits);
    }

    public QAskAnswerAlarm(Class<? extends AskAnswerAlarm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.askAnswer = inits.isInitialized("askAnswer") ? new QAskAnswer(forProperty("askAnswer")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

