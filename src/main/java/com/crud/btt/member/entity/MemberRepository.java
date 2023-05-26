package com.crud.btt.member.entity;

import com.crud.btt.member.model.dto.MemberDto;
import org.springframework.data.jpa.repository.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


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

    @Modifying
    @Query(value = " update member set user_pw = :userPw, phone = :phone, email = :email where user_id = :userId", nativeQuery = true )
    void saveByPwPhEm(@Param("userPw") String userPw, @Param("phone") String phone,
                      @Param("email") String email, @Param("userId") String userId);

    Optional<MemberEntity> findByUserCode(Long userCode);

    Optional<MemberEntity> findByUserId(String username);
    Optional<MemberEntity> findByUserPw(String username);

    //회원아이디 찾기
//    @Query(value = " select * from member where username = ?1 ", nativeQuery = true)
//    Optional<MemberEntity> findByUserneme(String userName);

    List<MemberEntity> findTop5ByOrderByEnrollDateDesc();

//    @EntityGraph(attributePaths = "auth")
//    Optional<MemberEntity> findOneWithAuthoritiesByUsername(String username);
//    Optional<MemberAuth> findByUserAuth(String username);
}
