package com.crud.btt.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QChatLogEntity is a Querydsl query type for ChatLogEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChatLogEntity extends EntityPathBase<ChatLogEntity> {

    private static final long serialVersionUID = -663012366L;

    public static final QChatLogEntity chatLogEntity = new QChatLogEntity("chatLogEntity");

    public final DateTimePath<java.util.Date> access_time = createDateTime("access_time", java.util.Date.class);

    public final StringPath entrance = createString("entrance");

    public final StringPath link = createString("link");

    public final NumberPath<Long> log_no = createNumber("log_no", Long.class);

    public final NumberPath<Long> user_code1 = createNumber("user_code1", Long.class);

    public final NumberPath<Long> user_code2 = createNumber("user_code2", Long.class);

    public QChatLogEntity(String variable) {
        super(ChatLogEntity.class, forVariable(variable));
    }

    public QChatLogEntity(Path<? extends ChatLogEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChatLogEntity(PathMetadata metadata) {
        super(ChatLogEntity.class, metadata);
    }

}

