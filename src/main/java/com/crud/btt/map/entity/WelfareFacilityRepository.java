package com.crud.btt.map.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WelfareFacilityRepository extends JpaRepository<WelfareFacilityEntity, Long> {

//    Page<WelfareFacilityEntity> findAllByOrderByIdxDesc(Pageable pageable);
//
//    Page<WelfareFacilityEntity> findWelfareFacilityEntitiesBy(Pageable pageable, SearchCondition searchCondition);
//
//    Long deleteByWfNo(Long wfNo);
}
