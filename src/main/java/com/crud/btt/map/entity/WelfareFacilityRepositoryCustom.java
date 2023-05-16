package com.crud.btt.map.entity;

//import com.crud.btt.common.SearchCondition;
//import com.google.api.gax.paging.Page;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQuery;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.mockito.internal.util.StringUtil;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//import org.springframework.util.StringUtils;

import java.util.List;

//import static com.crud.btt.map.entity.QWelfareFacilityEntity.welfareFacilityEntity;

//@RequiredArgsConstructor
//@Repository
public class WelfareFacilityRepositoryCustom {
//    private final JPAQueryFactory queryFactory;

//    public Page<WelfareFacilityEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition){
//        JPAQuery<WelfareFacilityEntity> query = queryFactory.selectFrom(welfareF()actilityEntity)
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));
//
//        long total = query.stream().count();
//
//        List<WelfareFacilityEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .orderBy(WelfareFacilityEntity.wfNo.desc())
//                .fetch();
//
//        return new PageImpl<>(results, pageable, total);
//    }
//
//    private BooleanExpression searchKeywords(String sk, String sv){
//        if("wfName".equals(sk)){
//            if(StringUtils.hasLength(sv)){
//                return welfareFacilityEntity.wfName.contains(sv);
//            }
//        } else if ("address".equals((sk))) {
//            if(StringUtils.hasLength(sv)){
//                return welfareFacilityEntity.address.contains(sv);
//            }
//        } else if ("address2".equals((sk))) {
//            if(StringUtils.hasLength(sv)){
//                return welfareFacilityEntity.address2.contains(sv);
//            }
//        }
//        return null;
//    }
}
