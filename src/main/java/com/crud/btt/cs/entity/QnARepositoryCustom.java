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

import static com.crud.btt.cs.entity.QQnAEntity.qnAEntity;


@RequiredArgsConstructor
@Repository
public class QnARepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public Page<QnAEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition){

        JPAQuery<QnAEntity> query = queryFactory.selectFrom(qnAEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();

        List<QnAEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(qnAEntity.qnaNo.desc())
                .fetch();
        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv) {


        if("qnaTitle".equals(sk)){
            if(StringUtils.hasLength(sv)){
                return qnAEntity.qnaTitle.contains(sv);
            }
        } else if ("qnaContent".equals(sk)) {


            if(StringUtils.hasLength(sv)){
                return qnAEntity.qnaContent.contains(sv);
            }
        }
        return null;

    }

}