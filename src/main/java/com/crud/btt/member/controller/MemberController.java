package com.crud.btt.member.controller;

import com.crud.btt.member.entity.QuitEntity;
import com.crud.btt.member.model.dto.MemberDto;
import com.crud.btt.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class MemberController {

    private final MemberService memberService;

    //해당 회원 존재 여부 확인 및 정보 출력용
    @GetMapping("/member/{user_code}") //mapping은 임의로 작성한것.
    public MemberDto getMember(@PathVariable Long user_code) {
        return memberService.getMember(user_code);
    }

    //탈퇴회원 quit table로 이동
    @PostMapping
    public QuitEntity create(@RequestBody MemberDto memberDto) {
        return create(memberService.create(memberDto));
    }

    //탈퇴하기
    @DeleteMapping
    public void delete(@PathVariable Long user_code) {

        if(getMember(user_code) != null) {
            //if(만약 quit create가 성공이라면){

            //member table의 user를 삭제한다.
            memberService.delete(user_code);
        //}
        }

    }

}
