//package com.crud.btt.cs.entity;
//
//import com.crud.btt.common.SearchCondition;
////import com.querydsl.core.types.Predicate;
////import com.querydsl.jpa.impl.JPAQuery;
////import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.util.StringUtils;
//
//import java.util.List;
//
//import static com.crud.btt.cs.entity.QQnAEntity.qnaEntity;
//
//
//public class QnARepositoryCustom {
//    @Autowired JPAQueryFactory queryFactory;
//    public Page<QnAEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition){
//
//        JPAQuery<QnAEntity> query = queryFactory.selectFrom(qnaEntity)
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));
//
//        long total = query.stream().count();
//
//        List<QnAEntity> results = query
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .orderBy(qnaEntity.qna_no.desc())
//                .fetch();
//        return new PageImpl<>(results, pageable, total);
//    }
//
//    private Predicate searchKeywords(String sk, String sv) {
//
//        if("qna_title".equals(sk)){
//            if(StringUtils.hasLength(sv)){
//                return qnaEntity.qna_title.contains(sv);
//            }
//        } else if ("qna_content".equals(sk)) {
//            if(StringUtils.hasLength(sv)){
//                return qnaEntity.qna_content.contains(sv);
//            }
//        }
//        return null;
//
//    }
//    /*
//    public Page<QnAEntity> findForQnaList(Pageable pageable, SearchCondition searchCondition) {
//
//        JPAQuery<QnAEntity> query = queryFactory.selectFrom(qnaEntity)
//                .where();
//
//
//        return null;
//    }
//
//    private Predicate searchSameBtwTwoColumn(String sk, String sv) {
//
//        if(qnaEntity.qna_no == qnaEntity.ref_no ){
//            qnaEntity.qna_no.
//        }
//
//        return null;
//    }
//    */
//}