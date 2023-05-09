package com.crud.btt.sp.entity;

import org.springframework.data.jpa.repository.JpaRepository;



public interface SpRepository extends JpaRepository<SpEntity, Long> {

    SpEntity findByUserCode(Long user_code);
    SpEntity findByUserCodeIsAndUserAuthIs(Long user_code, String user_auth);


}
