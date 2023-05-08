package com.crud.btt.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminEntity is a Querydsl query type for AdminEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminEntity extends EntityPathBase<AdminEntity> {

    private static final long serialVersionUID = 1732969717L;

    public static final QAdminEntity adminEntity = new QAdminEntity("adminEntity");

    public final NumberPath<Long> admin_code = createNumber("admin_code", Long.class);

    public final StringPath admin_id = createString("admin_id");

    public final StringPath admin_name = createString("admin_name");

    public final StringPath admin_pwd = createString("admin_pwd");

    public final StringPath email = createString("email");

    public final DateTimePath<java.util.Date> enroll_date = createDateTime("enroll_date", java.util.Date.class);

    public final StringPath phone = createString("phone");

    public QAdminEntity(String variable) {
        super(AdminEntity.class, forVariable(variable));
    }

    public QAdminEntity(Path<? extends AdminEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminEntity(PathMetadata metadata) {
        super(AdminEntity.class, metadata);
    }

}

