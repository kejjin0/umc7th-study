package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAsk is a Querydsl query type for Ask
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAsk extends EntityPathBase<Ask> {

    private static final long serialVersionUID = -597693875L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAsk ask = new QAsk("ask");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final QAskAnswer askAnswer;

    public final ListPath<AskImage, QAskImage> askImageList = this.<AskImage, QAskImage>createList("askImageList", AskImage.class, QAskImage.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.AskStatus> askStatus = createEnum("askStatus", umc.spring.domain.enums.AskStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAsk(String variable) {
        this(Ask.class, forVariable(variable), INITS);
    }

    public QAsk(Path<? extends Ask> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAsk(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAsk(PathMetadata metadata, PathInits inits) {
        this(Ask.class, metadata, inits);
    }

    public QAsk(Class<? extends Ask> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.askAnswer = inits.isInitialized("askAnswer") ? new QAskAnswer(forProperty("askAnswer")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

