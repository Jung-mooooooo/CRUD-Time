//package com.crud.btt.cs.entity;
//
//import com.crud.btt.common.SearchCondition;
//import com.querydsl.core.types.Predicate;
//import com.querydsl.jpa.impl.JPAQuery;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.util.StringUtils;
//
//import java.util.List;
//
//import static com.crud.btt.cs.entity.QFAQEntity.faqEntity;
//
//public class FAQRepositoryCustom {
//    @Autowired JPAQueryFactory queryFactory;
//    public Page<FAQEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition){
//
//        JPAQuery<FAQEntity> query = queryFactory.selectFrom(faqEntity)
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));
//
//        long total = query.stream().count();
//
//        List<FAQEntity> results = query
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .orderBy(faqEntity.faq_no.desc())
//                .fetch();
//        return new PageImpl<>(results, pageable, total);
//    }
//
//    private Predicate searchKeywords(String sk, String sv) {
//
//        if("faq_title".equals(sk)){
//            if(StringUtils.hasLength(sv)){
//                return faqEntity.faq_title.contains(sv);
//            }
//        } else if ("faq_content".equals(sk)) {
//            if(StringUtils.hasLength(sv)){
//                return faqEntity.faq_content.contains(sv);
//            }
//        }
//        return null;
//
//    }
//}
