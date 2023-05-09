package com.crud.btt.map.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWelfareFacilityEntity is a Querydsl query type for WelfareFacilityEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWelfareFacilityEntity extends EntityPathBase<WelfareFacilityEntity> {

    private static final long serialVersionUID = -699954680L;

    public static final QWelfareFacilityEntity welfareFacilityEntity = new QWelfareFacilityEntity("welfareFacilityEntity");

    public final StringPath address = createString("address");

    public final StringPath address2 = createString("address2");

    public final StringPath latitude = createString("latitude");

    public final StringPath logitude = createString("logitude");

    public final StringPath phone = createString("phone");

    public final StringPath wf_cat = createString("wf_cat");

    public final StringPath wf_name = createString("wf_name");

    public final NumberPath<Long> wf_no = createNumber("wf_no", Long.class);

    public QWelfareFacilityEntity(String variable) {
        super(WelfareFacilityEntity.class, forVariable(variable));
    }

    public QWelfareFacilityEntity(Path<? extends WelfareFacilityEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWelfareFacilityEntity(PathMetadata metadata) {
        super(WelfareFacilityEntity.class, metadata);
    }

}

