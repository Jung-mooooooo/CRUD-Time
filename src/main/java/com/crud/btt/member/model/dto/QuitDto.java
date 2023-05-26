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

    private Long quitUserCode;     //탈퇴회원코드
    private String quitUserId;     //탈퇴유저아이디
    private String quitUserPw;     //탈퇴유저패스워드
    private String quitUserName;   //탈퇴유저이름
    private String quitPhone;       //탈퇴전화번호
    private String quitEmail;       //탈퇴이메일
    private String quitKakaoId;    //탈퇴카카오로그인
    private String quitNaverId;    //탈퇴네이버로그인
    private String quitGoogleId;   //탈퇴구글로그인
    private String quitPermit;      //탈퇴회원체크
    private String quitDate;          //탈퇴일
    private String quitauth;
}
