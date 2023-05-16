package com.crud.btt.member.entity;

import com.crud.btt.member.model.dto.MemberDto;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
//    MemberEntity save(MemberDto memberDto);

    /* 유효성 검사 - 중복체크
    * 중복 : true
    * not 중복 : false
    * */
    boolean existsByUserId(String userId);  //existsBy~: select count(*)이 아닌, select ~ limit 1;
                                            //중복이 하나라도 발생시, 즉시 쿼리 종료.
    boolean existsByPhone(String phone);
    boolean existsByEmail(String email);
}
