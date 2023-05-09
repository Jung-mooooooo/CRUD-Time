package com.crud.btt.sp.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SpRepository extends JpaRepository<SpEntity, Long> {

//    SpEntity findByUser_code(Long user_code);
//    SpEntity findByUser_codeAndUser_authIs(Long user_code, String user_auth);


}
