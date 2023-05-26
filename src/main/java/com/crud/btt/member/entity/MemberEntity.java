package com.crud.btt.member.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


//@JsonIgnoreProperties(value="hibernateLazyInitializer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "MEMBER")
@Entity
//@DynamicInsert
public class MemberEntity implements UserDetails {

    @Id
    @SequenceGenerator(name = "SEQ_MEMBER",
            sequenceName = "SEQ_MEMBER",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEMBER")
    @Column(name="USER_CODE")
    private Long userCode;     //회원코드
    @Column(unique = true, name="USER_ID")
    private String userId;     //유저아이디
    @Column(name="USER_PW")
    private String userPw;     //유저패스워드
    @Column(name="USER_NAME")
    private String userNamee;   //유저이름
    @Column(name="PHONE")
    private String phone;       //전화번호
    @Column(name="EMAIL")
    private String email;       //이메일
    @Column(name="KAKAO_ID")
    private String kakaoId;    //카카오로그인
    @Column(name="NAVER_ID")
    private String naverId;    //네이버로그인
    @Column(name="GOOGLE_ID")
    private String googleId;   //구글로그인
    @Column(name="PERMIT")
    private String permit;      //회원체크
    @Column(name="ENROLL_DATE")
    private LocalDateTime enrollDate;   //가입일
//    @Enumerated(EnumType.STRING)
    @Column(name="AUTH")
    private String auth;

//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//    @ManyToMany
//    @JoinTable(
//            name = "member_auth",
//            joinColumns = {@JoinColumn(name = "user_code", referencedColumnName = "user_code")},
//            inverseJoinColumns = {@JoinColumn(name = "auth", referencedColumnName = "auth")})
//    @JoinColumn(name = "user_code")
//    @ElementCollection(fetch = FetchType.EAGER)
//    @Builder.Default
//    private List<MemberAuth> authList = new ArrayList<MemberAuth>();
//    private List<String> roles = new ArrayList<>();



    //update를 위한
    public MemberEntity update(String userPw, String phone, String email){
        this.userPw = userPw;
        this.phone = phone;
        this.email = email;
        return  this;
    }

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

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.roles.stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return getAuth().stream().map(o -> new SimpleGrantedAuthority(
//                o.getAuth()
//        )).collect(Collectors.toList());
//    }
//
//    public void addAuth(MemberAuth auth) {
//        authList.add(auth);
//    }


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }

    @Override
    public String getPassword() {
        return userPw;
    }

    //user id 반환
    @Override
    public String getUsername() {
        return userId;
    }

    public long getUserNo() {
       return userCode;
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



    @PrePersist
    public void perPersist(){

    }

    public boolean isActivated() {
        return true;
    }
}

