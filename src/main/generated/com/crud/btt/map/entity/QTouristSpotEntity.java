package com.crud.btt.map.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTouristSpotEntity is a Querydsl query type for TouristSpotEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTouristSpotEntity extends EntityPathBase<TouristSpotEntity> {

    private static final long serialVersionUID = 1690256717L;

    public static final QTouristSpotEntity touristSpotEntity = new QTouristSpotEntity("touristSpotEntity");

    public final StringPath address = createString("address");

    public final StringPath address2 = createString("address2");

    public final StringPath latitude = createString("latitude");

    public final StringPath logitude = createString("logitude");

    public final StringPath phone = createString("phone");

    public final StringPath ts_cat = createString("ts_cat");

    public final StringPath ts_name = createString("ts_name");

    public final NumberPath<Long> ts_no = createNumber("ts_no", Long.class);

    public QTouristSpotEntity(String variable) {
        super(TouristSpotEntity.class, forVariable(variable));
    }

    public QTouristSpotEntity(Path<? extends TouristSpotEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTouristSpotEntity(PathMetadata metadata) {
        super(TouristSpotEntity.class, metadata);
    }

}

