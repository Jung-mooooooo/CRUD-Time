package com.crud.btt.cs.entity;

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

import static com.crud.btt.cs.entity.QNoticeEntity.noticeEntity;
@RequiredArgsConstructor
@Repository
//@ComponentScan(basePackages = "com.crud.btt.cs.entity")
public class NoticeRepositoryCustom {


    private final JPAQueryFactory queryFactory;

    public Page<NoticeEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition){
/*
        JPAQuery<BoardEntity> query = queryFactory.selectFrom(boardEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<BoardEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPa   geSize())
                .orderBy(boardEntity.idx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
*/
        JPAQuery<NoticeEntity> query = queryFactory.selectFrom(noticeEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();

        List<NoticeEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(noticeEntity.noticeNo.desc())
                .fetch();
        return new PageImpl<>(results, pageable, total);
    }

//    private Predicate searchKeywords(String sk, String sv) {
//
//        if("noticeTitle".equals(sk)){
//            if(StringUtils.hasLength(sv)){
//                return noticeEntity.noticeTitle.contains(sv);
//            }
//        } else if ("noticeContent".equals(sk)) {
//            if(StringUtils.hasLength(sv)){
//                return noticeEntity.noticeContent.contains(sv);
//            }
//        }
//        return null;
//
//    }

    private BooleanExpression searchKeywords(String sk, String sv) {
        if ("noticeTitle".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return noticeEntity.noticeTitle.contains(sv);
            }
        } else if ("noticeContent".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return noticeEntity.noticeContent.contains(sv);
            }
        }
        //return Expressions.asBoolean(true).isTrue(); // 빈 조건식 반환
            return null;
    }
}
