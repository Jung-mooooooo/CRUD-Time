package com.crud.btt.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSpLogEntity is a Querydsl query type for SpLogEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSpLogEntity extends EntityPathBase<SpLogEntity> {

    private static final long serialVersionUID = 855245645L;

    public static final QSpLogEntity spLogEntity = new QSpLogEntity("spLogEntity");

    public final NumberPath<Long> log_no = createNumber("log_no", Long.class);

    public final DateTimePath<java.time.LocalDateTime> login_date = createDateTime("login_date", java.time.LocalDateTime.class);

    public final NumberPath<Long> user_code = createNumber("user_code", Long.class);

    public QSpLogEntity(String variable) {
        super(SpLogEntity.class, forVariable(variable));
    }

    public QSpLogEntity(Path<? extends SpLogEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSpLogEntity(PathMetadata metadata) {
        super(SpLogEntity.class, metadata);
    }

}

