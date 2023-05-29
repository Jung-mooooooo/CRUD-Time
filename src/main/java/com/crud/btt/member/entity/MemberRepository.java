package com.crud.btt.member.entity;


import com.crud.btt.common.SearchCondition;
import com.crud.btt.map.entity.HobbyEntity;
import com.crud.btt.member.model.dto.MemberDto;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static com.crud.btt.map.entity.QHobbyEntity.hobbyEntity;


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

//    String findByUserNameeAndPhone(String userNamee, String phone);
//
//    String findByUserNameeAndEmail(String userNamee, String email);


    //id찾기 - phone
    @Query(value = "select * from Member where user_name= :userName and phone= :phone", nativeQuery = true)
    MemberEntity findByUserNameAndPhone(@Param("userName") String userName, @Param("phone") String phone);

   //id찾기 - email
    @Query(value = "select * from Member where user_name= :userName and email= :email", nativeQuery = true)
    MemberEntity findByUserNameAndEmail(@Param("userName") String userName, @Param("email") String email);




    //패스워드 찾기 - phone
    @Query(value = "select * from Member where user_id= :userId and phone= :phone", nativeQuery = true)
    MemberEntity findByUserIdAndPhone(@Param("userId") String userId, @Param("phone") String phone);

    //패스워드 찾기 - email
    @Query(value = "select * from Member where user_id= :userId and email= :email", nativeQuery = true)
    MemberEntity findByUserIdAndEmail(@Param("userId") String userId, @Param("email") String email);


    //패스워드 수정
    @Modifying
    @Query(value = "update Member set user_pw = :userPw where user_id = :userId", nativeQuery = true)
    void saveByPw(@Param("userPw") String userPw, @Param("userId") String userId);




//    @EntityGraph(attributePaths = "auth")
//    Optional<MemberEntity> findOneWithAuthoritiesByUsername(String username);
//    Optional<MemberAuth> findByUserAuth(String username);


}
