package com.crud.btt.member.validator;

import com.crud.btt.member.entity.MemberRepository;
import com.crud.btt.member.model.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component
public class CheckPhoneValidator extends AbstractValidator<MemberDto> {
    private final MemberRepository memberRepository;

    @Override
    protected void doValidate(MemberDto dto, Errors errors) {
        if(memberRepository.existsByPhone(dto.getPhone())){
            //중복인 경우
            errors.rejectValue("phone", "핸드폰 번호 중복 오류", "이미 존재하는 핸드폰 번호입니다.");
        }
    }
}
