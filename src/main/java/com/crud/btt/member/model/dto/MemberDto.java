package com.crud.btt.member.model.dto;

import com.crud.btt.member.entity.MemberEntity;
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

    private Long userCode;     //회원코드
    private String userId;     //유저아이디
    private String userPw;     //유저패스워드
    private String userName;   //유저이름
    private String phone;       //전화번호
    private String email;       //이메일
    private String kakaoId;    //카카오로그인
    private String naverId;    //네이버로그인
    private String googleId;   //구글로그인
    private String permit;      //회원체크
    private Date enrollDate;   //가입일

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .phone(phone)
                .email(email)
                .build();
    }
}
