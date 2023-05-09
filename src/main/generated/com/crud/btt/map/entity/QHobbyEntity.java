package com.crud.btt.map.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHobbyEntity is a Querydsl query type for HobbyEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHobbyEntity extends EntityPathBase<HobbyEntity> {

    private static final long serialVersionUID = -47683125L;

    public static final QHobbyEntity hobbyEntity = new QHobbyEntity("hobbyEntity");

    public final StringPath address = createString("address");

    public final StringPath address2 = createString("address2");

    public final StringPath hobby_cat = createString("hobby_cat");

    public final StringPath hobby_name = createString("hobby_name");

    public final NumberPath<Long> hobby_no = createNumber("hobby_no", Long.class);

    public final StringPath latitude = createString("latitude");

    public final StringPath logitude = createString("logitude");

    public final StringPath phone = createString("phone");

    public QHobbyEntity(String variable) {
        super(HobbyEntity.class, forVariable(variable));
    }

    public QHobbyEntity(Path<? extends HobbyEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHobbyEntity(PathMetadata metadata) {
        super(HobbyEntity.class, metadata);
    }

}

