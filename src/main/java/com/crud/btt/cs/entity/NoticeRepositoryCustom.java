package com.crud.btt.cs.entity;

import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.model.dto.NoticeDto;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.JpaCountQueryCreator;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.util.StringUtils;

import static com.crud.btt.cs.entity.QNoticeEntity.noticeEntity;

import java.util.List;

public class NoticeRepositoryCustom {
    @Autowired JPAQueryFactory queryFactory;
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
                .orderBy(noticeEntity.notice_no.desc())
                .fetch();
        return new PageImpl<>(results, pageable, total);
    }

    private Predicate searchKeywords(String sk, String sv) {
        /*
        if("author".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return boardEntity.author.contains(sv);
            }
        } else if ("title".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return boardEntity.title.contains(sv);
            }
        } else if ("contents".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return boardEntity.contents.contains(sv);
            }
        }
        */

        if("notice_title".equals(sk)){
            if(StringUtils.hasLength(sv)){
                return noticeEntity.notice_title.contains(sv);
            }
        } else if ("notice_content".equals(sk)) {
            if(StringUtils.hasLength(sv)){
                return noticeEntity.notice_content.contains(sv);
            }
        }
        return null;

    }
}
