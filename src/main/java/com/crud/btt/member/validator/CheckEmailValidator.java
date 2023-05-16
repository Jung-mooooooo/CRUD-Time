package com.crud.btt.member.validator;

import com.crud.btt.member.entity.MemberRepository;
import com.crud.btt.member.model.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component
public class CheckEmailValidator extends AbstractValidator<MemberDto> {
    private final MemberRepository memberRepository;

    @Override
    protected void doValidate(MemberDto dto, Errors errors) {
        if(memberRepository.existsByEmail(dto.getEmail())){
            //중복인 경우
            errors.rejectValue("email", "이메일 중복 오류", "이미 존재하는 이메일입니다.");
        }
    }
}
