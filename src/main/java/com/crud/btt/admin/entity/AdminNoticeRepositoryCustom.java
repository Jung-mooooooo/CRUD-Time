package com.crud.btt.admin.entity;

import com.crud.btt.common.SearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.crud.btt.admin.entity.QAdminNoticeEntity.adminNoticeEntity;
@RequiredArgsConstructor
@Repository
//@ComponentScan(basePackages = "com.crud.btt.cs.entity")
public class AdminNoticeRepositoryCustom {


    private final JPAQueryFactory queryFactory;

    public Page<AdminNoticeEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition){

        JPAQuery<AdminNoticeEntity> query = queryFactory.selectFrom(adminNoticeEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();


        // int customOffset = pageable.getPageNumber() == 0 ? 0 : (pageable.getPageNumber()-1) * pageable.getPageSize();
        // System.out.println("customOffset : "+customOffset);

        List<AdminNoticeEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(adminNoticeEntity.noticeNo.desc())
                .fetch();
        System.out.println("offset : " + pageable.getOffset());
        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv) {
        if ("noticeTitle".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return adminNoticeEntity.noticeTitle.contains(sv);
            }
        } else if ("noticeContent".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return adminNoticeEntity.noticeContent.contains(sv);
            }
        }
            return null;
    }
}

