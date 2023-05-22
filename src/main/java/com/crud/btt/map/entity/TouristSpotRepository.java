package com.crud.btt.map.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristSpotRepository extends JpaRepository<TouristSpotEntity, Long> {
    TouristSpotEntity findBytsNo(Long tsNo);

//    Page<TouristSpotEntity> findAllByOrderByIdxDesc(Pageable pageable);
//
//    Page<TouristSpotEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition);
//
//    Page<TouristSpotEntity> findAllByCategoryIsAndNameLike(String category, String name);

}
