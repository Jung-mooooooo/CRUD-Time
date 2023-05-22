package com.crud.btt.admin.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogEntity, Long> {

    //접속자 수
    //Long countByLogNo();
//    @Query("select count(*) from LogEntity where substr(visitTime, 1, 8) = substr(current_timestamp, 1, 8)")
//    Long countByLogNo();

    //월 접속자
    //Long countAllByLogNoBetweenAndVisitTime();
//    @Query("select count(*) from LogEntity where substr(visitTime, 1, 6) = substr(current_timestamp, 1, 6)")
//    Long countByMonthLogNo();



}
