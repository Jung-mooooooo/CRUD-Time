package com.crud.btt.member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "MEMBER")
@Entity
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "memberSequence",
//            sequenceName = "member_seq",
//            allocationSize = 1)
    @Column(name="user_code")
    private Long user_code;     //회원코드
    @Column(name="user_id")
    private String user_id;     //유저아이디
    @Column(name="user_pw")
    private String user_pw;     //유저패스워드
    @Column(name="user_name")
    private String user_name;   //유저이름
    @Column(name="phone")
    private String phone;       //전화번호
    @Column(name="email")
    private String email;       //이메일
    @Column(name="kakao_id")
    private String kakao_id;    //카카오로그인
    @Column(name="naver_id")
    private String naver_id;    //네이버로그인
    @Column(name="google_id")
    private String google_id;   //구글로그인
    @Column(name="permit")
    private String permit;      //회원체크
    @Column(name="enroll_date")
    private Date enroll_date;   //가입일
}
