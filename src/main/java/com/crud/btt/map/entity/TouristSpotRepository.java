package com.crud.btt.map.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristSpotRepository extends JpaRepository<TouristSpotEntity, Long> {

//    Page<TouristSpotEntity> findAllByOrderByIdxDesc(Pageable pageable);
}
