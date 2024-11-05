package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAskImage is a Querydsl query type for AskImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAskImage extends EntityPathBase<AskImage> {

    private static final long serialVersionUID = -593545458L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAskImage askImage = new QAskImage("askImage");

    public final QAsk ask;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QAskImage(String variable) {
        this(AskImage.class, forVariable(variable), INITS);
    }

    public QAskImage(Path<? extends AskImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAskImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAskImage(PathMetadata metadata, PathInits inits) {
        this(AskImage.class, metadata, inits);
    }

    public QAskImage(Class<? extends AskImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ask = inits.isInitialized("ask") ? new QAsk(forProperty("ask"), inits.get("ask")) : null;
    }

}

