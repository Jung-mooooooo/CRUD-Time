package com.crud.btt.cs.entity;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQnAEntity extends EntityPathBase<QnAEntity> {

    public static final QQnAEntity qnaEntity = new QQnAEntity("qnaEntity");

    public final NumberPath<Long> qna_no = createNumber("qna_no", Long.class);
    public final NumberPath<Long> ref_no = createNumber("ref_no", Long.class);
    public final StringPath qna_title = createString("qna_title");
    public final StringPath qna_content = createString("qna_content");

    public QQnAEntity(String variable) {
        super(QnAEntity.class, forVariable(variable));
    }

}
