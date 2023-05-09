package com.crud.btt.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "MEMBER")
@Entity
public class MemberEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "memberSequence",
//            sequenceName = "member_seq",
//            allocationSize = 1)
    @Column(name="user_code")
    private Long userCode;     //회원코드
    @Column(name="user_id")
    private String userId;     //유저아이디
    @Column(name="user_pw")
    private String userPw;     //유저패스워드
    @Column(name="user_name")
    private String userName;   //유저이름
    @Column(name="phone")
    private String phone;       //전화번호
    @Column(name="email")
    private String email;       //이메일
    @Column(name="kakao_id")
    private String kakaoId;    //카카오로그인
    @Column(name="naver_id")
    private String naverId;    //네이버로그인
    @Column(name="google_id")
    private String googleId;   //구글로그인
    @Column(name="permit")
    private String permit;      //회원체크
    @Column(name="enroll_date")
    private Date enrollDate;   //가입일

    //사용자의 권한을 콜렉션 형태로 반환
    //클래스 자료형은 GrantedAuthority 구현
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for(String role : permit.split(",")){
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }


    @Override
    public String getPassword() {
        return userPw;
    }

    //user id 반환
    @Override
    public String getUsername() {
        return userId;
    }

    //계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        //만료 여부 체크 로직
        return true;    // => 만료 안됨.
    }

    //계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        //계정 잠금 여부 체크 로직
        return true;    //=> 잠금 안됨.
    }

    //패스워드 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        return true;    //만료 안됨.
    }

    //셔계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        return true;    //=> 사용가능
    }
}

