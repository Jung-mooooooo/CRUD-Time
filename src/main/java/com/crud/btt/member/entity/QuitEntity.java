package com.crud.btt.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "MEMBER")
@Entity
public class QuitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="quit_user_code")
    private Long quit_user_code;     //탈퇴회원코드
    @Column(name="quit_user_id")
    private String quit_user_id;     //탈퇴유저아이디
    @Column(name="quit_user_pw")
    private String quit_user_pw;     //탈퇴유저패스워드
    @Column(name="quit_user_name")
    private String quit_user_name;   //탈퇴유저이름
    @Column(name="quit_phone")
    private String quit_phone;       //탈퇴전화번호
    @Column(name="quit_email")
    private String quit_email;       //탈퇴이메일
    @Column(name="quit_kakao_id")
    private String quit_kakao_id;    //탈퇴카카오로그인
    @Column(name="quit_naver_id")
    private String quit_naver_id;    //탈퇴네이버로그인
    @Column(name="quit_google_id")
    private String quit_google_id;   //탈퇴구글로그인
    @Column(name="quit_permit")
    private String quit_permit;      //탈퇴회원체크
    @Column(name="quit_date")
    private Date quit_date;          //탈퇴일
}
