package com.crud.btt.common.security;//package com.crud.btt.config;
//
//import com.crud.btt.jwt.JwtAuthenticationFilter;
//import com.crud.btt.jwt.JwtTokenProvider;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .httpBasic().disable()
//                .csrf().disable()
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
////                .authorizeRequests()
////                .antMatchers("/**").permitAll() //모든 메소드 -> 모두 허용
////                .antMatchers("/members/test").hasRole("MEMBER") // 해당 메소드는 MEMBER 권한을 가진 회원만 허용
////                .anyRequest().authenticated()
////                .and()
////                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
//
//        ;
//
////        http.formLogin()
////                .loginPage("/member/login")
////                .defaultSuccessUrl("/loginhome");
//        return http.build();
//    }
//
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
////    }
//}
