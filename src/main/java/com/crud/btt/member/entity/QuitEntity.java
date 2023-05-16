package com.crud.btt.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "Quit")
@Entity
public class QuitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="quit_user_code")
    private Long userCode;     //탈퇴회원코드
    @Column(name="quit_user_id")
    private String userId;     //탈퇴유저아이디
    @Column(name="quit_user_pw")
    private String userPw;     //탈퇴유저패스워드
    @Column(name="quit_user_name")
    private String userName;   //탈퇴유저이름
    @Column(name="quit_phone")
    private String phone;       //탈퇴전화번호
    @Column(name="quit_email")
    private String email;       //탈퇴이메일
    @Column(name="quit_kakao_id")
    private String kakaoId;    //탈퇴카카오로그인
    @Column(name="quit_naver_id")
    private String naverId;    //탈퇴네이버로그인
    @Column(name="quit_google_id")
    private String googleId;   //탈퇴구글로그인
    @Column(name="quit_permit")
    private String permit;      //탈퇴회원체크
    @Column(name="quit_date")
    private Date quitDate;          //탈퇴일
}
