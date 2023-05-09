package com.crud.btt.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmotionEntity is a Querydsl query type for EmotionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmotionEntity extends EntityPathBase<EmotionEntity> {

    private static final long serialVersionUID = 1049066561L;

    public static final QEmotionEntity emotionEntity = new QEmotionEntity("emotionEntity");

    public final NumberPath<Long> emotion_cat = createNumber("emotion_cat", Long.class);

    public final NumberPath<Long> emotion_date = createNumber("emotion_date", Long.class);

    public final NumberPath<Long> emotion_no = createNumber("emotion_no", Long.class);

    public final NumberPath<Long> user_code = createNumber("user_code", Long.class);

    public QEmotionEntity(String variable) {
        super(EmotionEntity.class, forVariable(variable));
    }

    public QEmotionEntity(Path<? extends EmotionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmotionEntity(PathMetadata metadata) {
        super(EmotionEntity.class, metadata);
    }

}

