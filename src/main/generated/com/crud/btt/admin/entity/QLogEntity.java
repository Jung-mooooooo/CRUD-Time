package com.crud.btt.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLogEntity is a Querydsl query type for LogEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLogEntity extends EntityPathBase<LogEntity> {

    private static final long serialVersionUID = 1213527530L;

    public static final QLogEntity logEntity = new QLogEntity("logEntity");

    public final NumberPath<Long> log_no = createNumber("log_no", Long.class);

    public final NumberPath<Long> user_code = createNumber("user_code", Long.class);

    public final NumberPath<Long> visit_ip = createNumber("visit_ip", Long.class);

    public final NumberPath<Long> visit_time = createNumber("visit_time", Long.class);

    public QLogEntity(String variable) {
        super(LogEntity.class, forVariable(variable));
    }

    public QLogEntity(Path<? extends LogEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLogEntity(PathMetadata metadata) {
        super(LogEntity.class, metadata);
    }

}

