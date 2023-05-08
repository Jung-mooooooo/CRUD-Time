package com.crud.btt.map.entity;

import com.crud.btt.common.SearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<HobbyEntity, Long> {
    Page<HobbyEntity> findAllByOrderByIdxDesc(Pageable pageable);

    Page<HobbyEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition);
}
