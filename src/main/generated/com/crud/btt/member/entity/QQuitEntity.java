package com.crud.btt.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QQuitEntity is a Querydsl query type for QuitEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuitEntity extends EntityPathBase<QuitEntity> {

    private static final long serialVersionUID = -1128997544L;

    public static final QQuitEntity quitEntity = new QQuitEntity("quitEntity");

    public final DatePath<java.sql.Date> quit_date = createDate("quit_date", java.sql.Date.class);

    public final StringPath quit_email = createString("quit_email");

    public final StringPath quit_google_id = createString("quit_google_id");

    public final StringPath quit_kakao_id = createString("quit_kakao_id");

    public final StringPath quit_naver_id = createString("quit_naver_id");

    public final StringPath quit_permit = createString("quit_permit");

    public final StringPath quit_phone = createString("quit_phone");

    public final NumberPath<Long> quit_user_code = createNumber("quit_user_code", Long.class);

    public final StringPath quit_user_id = createString("quit_user_id");

    public final StringPath quit_user_name = createString("quit_user_name");

    public final StringPath quit_user_pw = createString("quit_user_pw");

    public QQuitEntity(String variable) {
        super(QuitEntity.class, forVariable(variable));
    }

    public QQuitEntity(Path<? extends QuitEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuitEntity(PathMetadata metadata) {
        super(QuitEntity.class, metadata);
    }

}

