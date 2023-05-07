package com.crud.btt.cs.entity;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNoticeEntity extends EntityPathBase<NoticeEntity> {

    public static final QNoticeEntity noticeEntity = new QNoticeEntity("noticeEntity");

    public final NumberPath<Long> notice_no = createNumber("notice_no", Long.class);
    public final StringPath notice_title = createString("notice_title");
    public final StringPath notice_content = createString("notice_content");

    public QNoticeEntity(String variable) {
        super(NoticeEntity.class, forVariable(variable));
    }

}
