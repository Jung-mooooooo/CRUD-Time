package com.crud.btt.member.model.service;

import com.crud.btt.admin.entity.AdminEntity;
import com.crud.btt.admin.entity.AdminRepository;
import com.crud.btt.member.entity.MemberEntity;
import com.crud.btt.member.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    private final MemberRepository memberRepository;
    private final AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity member = null;
        AdminEntity admin = null;
        if( username.contains("admin") ){
            admin = adminRepository.findByAdminId(username).get();
            if( admin == null) throw new UsernameNotFoundException(username);
            return new User(admin.getAdminId(), admin.getAdminPwd(), Collections.emptyList());
        } else {
            member = memberRepository.findByUserId(username).get();
            if (member == null) throw new UsernameNotFoundException(username);
            return new User(member.getUserId(), member.getUserPw(), Collections.emptyList());
        }

    }

}
