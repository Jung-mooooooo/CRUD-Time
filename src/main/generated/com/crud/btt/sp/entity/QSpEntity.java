package com.crud.btt.sp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSpEntity is a Querydsl query type for SpEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSpEntity extends EntityPathBase<SpEntity> {

    private static final long serialVersionUID = 1177451945L;

    public static final QSpEntity spEntity = new QSpEntity("spEntity");

    public final StringPath device_id = createString("device_id");

    public final DateTimePath<java.time.LocalDateTime> enroll_date = createDateTime("enroll_date", java.time.LocalDateTime.class);

    public final StringPath phone = createString("phone");

    public final StringPath user_auth = createString("user_auth");

    public final NumberPath<Long> user_code = createNumber("user_code", Long.class);

    public final StringPath user_name = createString("user_name");

    public QSpEntity(String variable) {
        super(SpEntity.class, forVariable(variable));
    }

    public QSpEntity(Path<? extends SpEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSpEntity(PathMetadata metadata) {
        super(SpEntity.class, metadata);
    }

}

