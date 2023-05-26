package com.crud.btt.admin.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LogRepository extends JpaRepository<LogEntity, Long> {

    //접속자 로그테이블에 저장
//    @Query(value = "insert into LogEntity l (l.userCode, l.visitIp, l.visitTime) values (user_code, #{visitIp}, #{visitTime})")
//    LogEntity createLog(@Param(userCode) Long userCode);

    //접속자 수
    //Long countByLogNo();
    @Query(value = "select count(l) from LogEntity l where substr(l.visitTime, 1, 8) = substr(current_timestamp, 1, 8)")
    Long countByLogNo();

    //월 접속자
    //Long countAllByLogNoBetweenAndVisitTime();
    @Query(value = "select count(l) from LogEntity l where substr(l.visitTime, 1, 6) = substr(current_timestamp, 1, 6)")
    Long countByMonthLogNo();



}
