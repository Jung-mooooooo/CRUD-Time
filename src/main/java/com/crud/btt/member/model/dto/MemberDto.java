//package com.crud.btt.member.model.dto;
//
//import com.crud.btt.member.entity.MemberEntity;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//import java.util.Date;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class MemberDto {
//
//    private Long userCode;     //회원코드
//    @NotBlank(message = "아이디를 입력해주세요.")
//    @Pattern(regexp = "^[a-z0-9]{2,10}$", message = "아이디는 영어 소문자와 숫자만 사용하여 2~10자리여야 합니다.")
//    private String userId;     //유저아이디
//    @NotBlank(message = "비밀번호를 입력해주세요.")
//    //@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?])[A-Za-z\\d$@$!%*#?]{4,8}$", message = "비밀번호는 4~8자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
//    private String userPw;     //유저패스워드
//    @NotBlank(message = "이름을 입력해주세요.")
////    @Pattern(regexp = "^[가-힣a-zA-Z0-9]{2,10}$", message = "이름은 특수문자를 포함하지 않은 2-8자리여야 합니다.")
//    private String userName;   //유저이름
//    @NotBlank(message = "전화번호를 입력해주세요.([-] 없이)")
//    @Pattern(regexp = "^[0-9]{10,11}$", message = "전화번호는 숫자만 사용하여 10-11자리여야 합니다.")
//    private String phone;       //전화번호
//    @NotBlank(message = "이메일을 입력해주세요.")
//    @Email
//    private String email;       //이메일
//    private String kakaoId;    //카카오로그인
//    private String naverId;    //네이버로그인
//    private String googleId;   //구글로그인
//    private String permit;      //회원체크
//    private String enrollDate;   //가입일
//
//    public MemberEntity toEntity() {
//        return MemberEntity.builder()
//                .userId(userId)
//                .userPw(userPw)
//                .userName(userName)
//                .phone(phone)
//                .email(email)
//                .build();
//    }
//}
