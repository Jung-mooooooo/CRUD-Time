package com.crud.btt.common.security;

import com.crud.btt.member.model.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@AllArgsConstructor
@EnableWebSecurity //security 활성화 어노테이션
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private MemberService memberService;

    @Override
    public void  configure(WebSecurity web) {   //유저 정보 가져오는 클래스
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }

    //http 관련 인증 설정하기.
    @Override
    protected void  configure(HttpSecurity http) throws  Exception {
        http.authorizeRequests()    //접근에 대한 인증 설정
                .antMatchers("/member/login", "/member/enroll", "/").permitAll()    //누구나 접근 가능
                .antMatchers("/login").hasRole("MEMBER")    //member, admin만 접근가능
                .antMatchers("/admin").hasRole("ADMIN") //amdin만 접근가능
                .anyRequest().authenticated()   //권한의종류 관계없이 권한 있어야 접근가능

                .and()
                .formLogin()    //로그인 관한 설정
                .loginPage("/member/login")    //로그인 페이지 링크
                .defaultSuccessUrl("/login")     //로그인 성공 후 리다이렉트 주소

                .and()
                .logout()   //logout 관련 설정
                .logoutSuccessUrl("/")  //로그아웃 성공시 리다이렉트주소
                .invalidateHttpSession(true)    //로그 아웃 후 세션 전체 삭제 여부
        ;
    }

    //로그인할 때 필요한 정보 가져오는 곳
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }


}
