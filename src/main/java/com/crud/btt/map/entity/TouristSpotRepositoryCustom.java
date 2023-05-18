package com.crud.btt.map.entity;


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

import static com.crud.btt.map.entity.QTouristSpotEntity.touristSpotEntity;

@RequiredArgsConstructor
@Repository
public class TouristSpotRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    private BooleanExpression searchKeywords(String sk, String sv){
        if("tsName".equals(sk)){
            if(StringUtils.hasLength(sv)){
                return touristSpotEntity.tsName.contains(sv);
            }
        } else if ("address".equals((sk))) {
            if(StringUtils.hasLength(sv)){
                return touristSpotEntity.address.contains(sv);
            }
        } else if ("address2".equals((sk))) {
            if(StringUtils.hasLength(sv)){
                return touristSpotEntity.address2.contains(sv);
            }
        }
        return null;
    }

    //지도 목록 조회(페이징 처리)
    public Page<TouristSpotEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition){
        JPAQuery<TouristSpotEntity> query = queryFactory.selectFrom(touristSpotEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        Long total = query.stream().count();

        List<TouristSpotEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(touristSpotEntity.tsNo.asc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }


    //카테고리(바다)별 리스트 조회
    public Page<TouristSpotEntity> findAllByCategoryIsAndNameLikeSea(Pageable pageable, SearchCondition searchCondition){
        JPAQuery<TouristSpotEntity> query = queryFactory.selectFrom(touristSpotEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(touristSpotEntity.tsCat.eq("바다"));

        Long total = query.stream().count();

        List<TouristSpotEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(touristSpotEntity.tsNo.asc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }


    //카테고리(공원)별 리스트 조회
    public Page<TouristSpotEntity> findAllByCategoryIsAndNameLikePark(Pageable pageable, SearchCondition searchCondition){
        JPAQuery<TouristSpotEntity> query = queryFactory.selectFrom(touristSpotEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(touristSpotEntity.tsCat.eq("공원"));

        Long total = query.stream().count();

        List<TouristSpotEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(touristSpotEntity.tsNo.asc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }


    //카테고리(휴양)별 리스트 조회
    public Page<TouristSpotEntity> findAllByCategoryIsAndNameLikeForest(Pageable pageable, SearchCondition searchCondition){
        JPAQuery<TouristSpotEntity> query = queryFactory.selectFrom(touristSpotEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(touristSpotEntity.tsCat.eq("휴양림"));

        Long total = query.stream().count();

        List<TouristSpotEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(touristSpotEntity.tsNo.asc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }


    //카테고리(액티비티)별 리스트 조회
    public Page<TouristSpotEntity> findAllByCategoryIsAndNameLikeActivity(Pageable pageable, SearchCondition searchCondition){
        JPAQuery<TouristSpotEntity> query = queryFactory.selectFrom(touristSpotEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(touristSpotEntity.tsCat.eq("액티비티"));

        Long total = query.stream().count();

        List<TouristSpotEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(touristSpotEntity.tsNo.asc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }


    //카테고리(캠핑)별 리스트 조회
    public Page<TouristSpotEntity> findAllByCategoryIsAndNameLikeCamping(Pageable pageable, SearchCondition searchCondition){
        JPAQuery<TouristSpotEntity> query = queryFactory.selectFrom(touristSpotEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(touristSpotEntity.tsCat.eq("캠핑"));

        Long total = query.stream().count();

        List<TouristSpotEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(touristSpotEntity.tsNo.asc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }


    //카테고리(박물관)별 리스트 조회
    public Page<TouristSpotEntity> findAllByCategoryIsAndNameLikeMuseum(Pageable pageable, SearchCondition searchCondition){
        JPAQuery<TouristSpotEntity> query = queryFactory.selectFrom(touristSpotEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(touristSpotEntity.tsCat.eq("박물관"));

        Long total = query.stream().count();

        List<TouristSpotEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(touristSpotEntity.tsNo.asc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }


    //카테고리(미술관)별 리스트 조회
    public Page<TouristSpotEntity> findAllByCategoryIsAndNameLikeGallery(Pageable pageable, SearchCondition searchCondition){
        JPAQuery<TouristSpotEntity> query = queryFactory.selectFrom(touristSpotEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(touristSpotEntity.tsCat.eq("미술관"));

        Long total = query.stream().count();

        List<TouristSpotEntity> results = query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(touristSpotEntity.tsNo.asc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }


}
