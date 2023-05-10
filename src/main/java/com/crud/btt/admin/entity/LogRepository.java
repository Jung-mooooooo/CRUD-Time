package com.crud.btt.admin.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogEntity, Long> {

    //접속자 수

//    Long countAllByLogNo();
//
//    //월 접속자
//    Long countAllByLogNoBetweenAndVisitTime();


    //월 평균 접속자 수

}
