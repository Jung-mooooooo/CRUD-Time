package com.crud.btt.map.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<HobbyEntity, Long> {
    HobbyEntity findByhobbyNo(Long hobbyNo);

//    Page<HobbyEntity> findAllByOrderByIdxDesc(Pageable pageable);
//
//    Page<HobbyEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition);
//
//    Page<HobbyEntity> findAllByCategoryIsAndNameLike(String category, String name);

}
