//package com.crud.btt.map.entity;
//
//
//import com.crud.btt.common.SearchCondition;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQuery;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//import org.springframework.util.StringUtils;
//
//import java.util.List;
//
//import static com.crud.btt.map.entity.QHobbyEntity.hobbyEntity;
//
//@RequiredArgsConstructor
//@Repository
//public class HobbyRepositoryCustom {
//    private final JPAQueryFactory queryFactory;
//
//    private BooleanExpression searchKeywords(String sk, String sv){
//        if("hobbyName".equals(sk)){
//            if(StringUtils.hasLength(sv)){
//                return hobbyEntity.hobbyName.contains(sv);
//            }
//        } else if ("address".equals((sk))) {
//            if(StringUtils.hasLength(sv)){
//                return hobbyEntity.address.contains(sv);
//            }
//        } else if ("address2".equals((sk))) {
//            if(StringUtils.hasLength(sv)){
//                return hobbyEntity.address2.contains(sv);
//            }
//        }
//        return null;
//    }
//
//    //지도 목록 조회(페이징 처리)
//    public Page<HobbyEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition){
//        JPAQuery<HobbyEntity> query = queryFactory.selectFrom(hobbyEntity)
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));
//
//        Long total = query.stream().count();
//
//        List<HobbyEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .orderBy(hobbyEntity.hobbyNo.asc())
//                .fetch();
//
//        return new PageImpl<>(results, pageable, total);
//    }
//
//
//    //카테고리(음악)별 리스트 조회
//    public Page<HobbyEntity> findAllByCategoryIsAndNameLikeSea(Pageable pageable, SearchCondition searchCondition){
//        JPAQuery<HobbyEntity> query = queryFactory.selectFrom(hobbyEntity)
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .where(hobbyEntity.hobbyCat.eq("바다"));
//
//        Long total = query.stream().count();
//
//        List<HobbyEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .orderBy(hobbyEntity.hobbyNo.asc())
//                .fetch();
//
//        return new PageImpl<>(results, pageable, total);
//    }
//
//
//    //카테고리(미)별 리스트 조회
//    public Page<TouristSpotEntity> findAllByCategoryIsAndNameLikePark(Pageable pageable, SearchCondition searchCondition){
//        JPAQuery<TouristSpotEntity> query = queryFactory.selectFrom(touristSpotEntity)
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .where(touristSpotEntity.tsCat.eq("공원"));
//
//        Long total = query.stream().count();
//
//        List<TouristSpotEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .orderBy(touristSpotEntity.tsNo.asc())
//                .fetch();
//
//        return new PageImpl<>(results, pageable, total);
//    }
//
//
//    //카테고리(무용)별 리스트 조회
//    public Page<TouristSpotEntity> findAllByCategoryIsAndNameLikeForest(Pageable pageable, SearchCondition searchCondition){
//        JPAQuery<TouristSpotEntity> query = queryFactory.selectFrom(touristSpotEntity)
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .where(touristSpotEntity.tsCat.eq("휴양림"));
//
//        Long total = query.stream().count();
//
//        List<TouristSpotEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .orderBy(touristSpotEntity.tsNo.asc())
//                .fetch();
//
//        return new PageImpl<>(results, pageable, total);
//    }
//
//
//    //카테고리(언어)별 리스트 조회
//    public Page<TouristSpotEntity> findAllByCategoryIsAndNameLikeActivity(Pageable pageable, SearchCondition searchCondition){
//        JPAQuery<TouristSpotEntity> query = queryFactory.selectFrom(touristSpotEntity)
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .where(touristSpotEntity.tsCat.eq("액티비티"));
//
//        Long total = query.stream().count();
//
//        List<TouristSpotEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .orderBy(touristSpotEntity.tsNo.asc())
//                .fetch();
//
//        return new PageImpl<>(results, pageable, total);
//    }
//
//
//
//}
