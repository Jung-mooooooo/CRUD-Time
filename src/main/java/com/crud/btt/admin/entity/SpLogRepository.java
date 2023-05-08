package com.crud.btt.admin.entity;

import com.crud.btt.sp.entity.SpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface SpLogRepository extends JpaRepository<SpEntity, Long> {
    int selectSpLogCount();

    int selectSpMonthCount();

    int selectSpAvgCount();

    ArrayList<SpEntity> selectNotForWeek();
}
