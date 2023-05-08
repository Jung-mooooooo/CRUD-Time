package com.crud.btt.admin.entity;

import com.crud.btt.map.entity.TouristSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogEntity, Long> {
    int selectLogCount();

    int insertLog(LogEntity logEntity);

    int selectMonthCount();

    int selectAvgCount();
}