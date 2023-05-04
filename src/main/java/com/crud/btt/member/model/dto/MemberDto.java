package com.crud.btt.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {

    private Long user_code;     //회원코드
    private String user_id;     //유저아이디
    private String user_pw;     //유저패스워드
    private String user_name;   //유저이름
    private String phone;       //전화번호
    private String email;       //이메일
    private String kakao_id;    //카카오로그인
    private String naver_id;    //네이버로그인
    private String google_id;   //구글로그인
    private String permit;      //회원체크
    private Date enroll_date;   //가입일

}
