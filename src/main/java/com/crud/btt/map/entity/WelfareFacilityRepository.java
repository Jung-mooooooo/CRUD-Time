package com.crud.btt.map.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WelfareFacilityRepository extends JpaRepository<WelfareFacilityEntity, Long> {
    WelfareFacilityEntity findBywfNo(Long wfNo);



//    Page<WelfareFacilityEntity> findAllByOrderByIdxDesc(Pageable pageable);
//
//    Page<WelfareFacilityEntity> findWelfareFacilityEntitiesBy(Pageable pageable, SearchCondition searchCondition);

}
