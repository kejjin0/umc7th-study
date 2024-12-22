package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEventAlarm is a Querydsl query type for EventAlarm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEventAlarm extends EntityPathBase<EventAlarm> {

    private static final long serialVersionUID = -3047037L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEventAlarm eventAlarm = new QEventAlarm("eventAlarm");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final EnumPath<umc.spring.domain.enums.ConfirmStatus> confirm = createEnum("confirm", umc.spring.domain.enums.ConfirmStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QEventAlarm(String variable) {
        this(EventAlarm.class, forVariable(variable), INITS);
    }

    public QEventAlarm(Path<? extends EventAlarm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEventAlarm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEventAlarm(PathMetadata metadata, PathInits inits) {
        this(EventAlarm.class, metadata, inits);
    }

    public QEventAlarm(Class<? extends EventAlarm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

