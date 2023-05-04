package com.crud.btt.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuitDto {

    private Long quit_user_code;     //탈퇴회원코드
    private String quit_user_id;     //탈퇴유저아이디
    private String quit_user_pw;     //탈퇴유저패스워드
    private String quit_user_name;   //탈퇴유저이름
    private String quit_phone;       //탈퇴전화번호
    private String quit_email;       //탈퇴이메일
    private String quit_kakao_id;    //탈퇴카카오로그인
    private String quit_naver_id;    //탈퇴네이버로그인
    private String quit_google_id;   //탈퇴구글로그인
    private String quit_permit;      //탈퇴회원체크
    private Date quit_date;          //탈퇴일
}
