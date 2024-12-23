package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAskAnswer is a Querydsl query type for AskAnswer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAskAnswer extends EntityPathBase<AskAnswer> {

    private static final long serialVersionUID = -1447597973L;

    public static final QAskAnswer askAnswer = new QAskAnswer("askAnswer");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAskAnswer(String variable) {
        super(AskAnswer.class, forVariable(variable));
    }

    public QAskAnswer(Path<? extends AskAnswer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAskAnswer(PathMetadata metadata) {
        super(AskAnswer.class, metadata);
    }

}

