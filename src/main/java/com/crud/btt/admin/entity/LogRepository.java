package com.crud.btt.admin.entity;

import com.crud.btt.map.entity.TouristSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogEntity, Long> {
    int logCount();

    int findLog(LogEntity logEntity);

    int logMonthCount();

    int logAvgCount();
}
