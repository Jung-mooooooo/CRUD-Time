package com.crud.btt.map.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WelfareFacilityRepository extends JpaRepository<WelfareFacilityEntity, Long> {

//    Page<WelfareFacilityEntity> findAllByOrderByIdxDesc(Pageable pageable);
}
