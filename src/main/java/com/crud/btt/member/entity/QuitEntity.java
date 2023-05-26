package com.crud.btt.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "Quit")
@Entity
public class QuitEntity {
    @Id
    @Column(name="quit_user_code")
    private Long quitUserCode;     //탈퇴회원코드
    @Column(name="quit_user_id")
    private String quitUserId;     //탈퇴유저아이디
    @Column(name="quit_user_pw")
    private String quitUserPw;     //탈퇴유저패스워드
    @Column(name="quit_user_name")
    private String quitUserName;   //탈퇴유저이름
    @Column(name="quit_phone")
    private String quitPhone;       //탈퇴전화번호
    @Column(name="quit_email")
    private String quitEmail;       //탈퇴이메일
    @Column(name="quit_kakao_id")
    private String quitKakaoId;    //탈퇴카카오로그인
    @Column(name="quit_naver_id")
    private String quitNaverId;    //탈퇴네이버로그인
    @Column(name="quit_google_id")
    private String quitGoogleId;   //탈퇴구글로그인
    @Column(name="quit_permit")
    private String quitPermit;      //탈퇴회원체크
    @Column(name="quit_date")
    private LocalDateTime quitDate; //탈퇴일
    @Column(name="quit_auth")
    private String quitAuth;
}
