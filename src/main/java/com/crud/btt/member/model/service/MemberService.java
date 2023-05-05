package com.crud.btt.member.model.service;

import com.crud.btt.member.entity.MemberEntity;
import com.crud.btt.member.entity.MemberRepository;
import com.crud.btt.member.entity.QuitEntity;
import com.crud.btt.member.entity.QuitRepository;
import com.crud.btt.member.model.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final QuitRepository quitRepository;

    //user info 가져오기. 존재여부 확인
    public MemberDto getMember(Long user_code) {
        MemberEntity entity = memberRepository.findById(user_code).orElseThrow(()
                -> new RuntimeException("해당 회원을 찾을 수 없습니다."));
        return MemberDto.builder()
                .user_code(entity.getUser_code())
                .user_id(entity.getUser_id())
                .user_pw(entity.getUser_pw())
                .user_name(entity.getUser_name())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .kakao_id(entity.getKakao_id())
                .naver_id(entity.getNaver_id())
                .google_id(entity.getGoogle_id())
                .permit(entity.getPermit())
                .enroll_date(entity.getEnroll_date())
                .build();
    }

    //회원 탈퇴
    public void delete(Long user_code) {
        MemberEntity entity = memberRepository.findById(user_code).orElseThrow(()
        -> new RuntimeException("해당 회원을 찾을 수 없습니다."));
        memberRepository.delete(entity);
    }


    public QuitEntity create(MemberDto memberDto) {
        QuitEntity entity = QuitEntity.builder()
                .quit_user_code(memberDto.getUser_code())
                .quit_user_id(memberDto.getUser_id())
                .quit_user_pw(memberDto.getUser_pw())
                .quit_user_name(memberDto.getUser_name())
                .quit_phone(memberDto.getPhone())
                .quit_email(memberDto.getEmail())
                .quit_kakao_id(memberDto.getKakao_id())
                .quit_naver_id(memberDto.getNaver_id())
                .quit_google_id(memberDto.getGoogle_id())
                .build();
        return quitRepository.save(entity); //quit 쿼리문 생성
    }
}
