package com.crud.btt.admin.entity;

import com.crud.btt.sp.entity.SpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SpLogRepository extends JpaRepository<SpLogEntity, Long> {

    //대화도우미 사용자수
    Long countAllByLogNo();

    //월 대화도우미 사용자수
    Long countAllByLogNoBetweenAndLoginDate();

    //평균 대화도우미 사용자수

    //일주일간 사용없는 사용자 리스트
    Page<SpLogEntity> findAllByOrOrderByLogNoDesc();

}
