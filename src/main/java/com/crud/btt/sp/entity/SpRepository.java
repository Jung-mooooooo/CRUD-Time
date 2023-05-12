package com.crud.btt.sp.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface SpRepository extends JpaRepository<SpEntity, Long> {


//    SpEntity findByUser_code(Long user_code);
SpEntity findByUserCodeAndUserAuthIs(Long user_code, String user_auth);



}
