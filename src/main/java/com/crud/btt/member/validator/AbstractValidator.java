package com.crud.btt.member.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


//중복 검사를 위한 Validator 구현 추상 클래스
@Slf4j
public abstract class AbstractValidator<T> implements Validator {

//    @Validated는 검증기를 실행하라는 어노테이션.
//    이 어노테이셔이 붙이면 WebDataBinder에 등록한 검증기를 찾아 실행함.
//    그러나, 어려 검증기(Validator)를 등록하면 검증기 중 구분해야함.
//    이때, supports()가 사용됨.
//    *검증 로직이 들어갈 부분은 doValidate 메서드를 따로 작성함.
    @Override
    public boolean supports(Class<?> clazz) {
        //sopports() : 어떤 타입의 객체를 검증할 때 이 객체의 클래스가 검증가능한 클래스인지 판단하는 메서드

        return true;
    }

    @SuppressWarnings("unchecked")  //무점검 경고 제거?
    @Override
    public void validate(Object target, Errors errors) {    //실제로 검증 로직이 이뤄지는 메소드.
        try {
            doValidate((T) target, errors); // 유효성 검증 로직
        } catch (IllegalStateException e) {
            log.error("중복 검증 에러", e);
            throw e;
        }
    }

    /* 유효성 검증 로직 */
    protected abstract void doValidate(final T dto, final Errors errors);

}
