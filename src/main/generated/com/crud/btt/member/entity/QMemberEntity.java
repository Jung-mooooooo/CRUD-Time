package com.crud.btt.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberEntity is a Querydsl query type for MemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEntity extends EntityPathBase<MemberEntity> {

    private static final long serialVersionUID = -636999709L;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final StringPath email = createString("email");

    public final DatePath<java.sql.Date> enroll_date = createDate("enroll_date", java.sql.Date.class);

    public final StringPath google_id = createString("google_id");

    public final StringPath kakao_id = createString("kakao_id");

    public final StringPath naver_id = createString("naver_id");

    public final StringPath permit = createString("permit");

    public final StringPath phone = createString("phone");

    public final NumberPath<Long> user_code = createNumber("user_code", Long.class);

    public final StringPath user_id = createString("user_id");

    public final StringPath user_name = createString("user_name");

    public final StringPath user_pw = createString("user_pw");

    public QMemberEntity(String variable) {
        super(MemberEntity.class, forVariable(variable));
    }

    public QMemberEntity(Path<? extends MemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberEntity(PathMetadata metadata) {
        super(MemberEntity.class, metadata);
    }

}

