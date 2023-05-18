//package com.crud.btt.member.validator;
//
//import com.crud.btt.member.entity.MemberEntity;
//import com.crud.btt.member.entity.MemberRepository;
//import com.crud.btt.member.model.dto.MemberDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//
//@RequiredArgsConstructor
//@Component
//public class CheckUserIdValidator extends AbstractValidator<MemberDto> {
//    private final MemberRepository memberRepository;
//    private MemberEntity memberEntity;
//
//    @Override
//    protected void doValidate(MemberDto dto, Errors errors) {
//        if(memberRepository.existsByUserId(dto.getUserId())){
//            //중복인 경우
//            errors.rejectValue("userId", "아이디 중복 오류", "이미 사용 중인 아이디입니다.");
//        }
//    }
//}
