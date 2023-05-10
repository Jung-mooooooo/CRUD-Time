package com.crud.btt.admin.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogEntity, Long> {

    //접속자 수
//    long countAllByLogNo();

    //월 접속자
//    long countAllByLogNoBetweenAndVisitTime();

    //월 평균 접속자 수

}
