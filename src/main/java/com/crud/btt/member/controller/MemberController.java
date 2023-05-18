package com.crud.btt.member.controller;

import com.crud.btt.member.model.dto.MemberDto;
import com.crud.btt.member.model.service.MemberService;
import com.crud.btt.member.validator.CheckEmailValidator;
import com.crud.btt.member.validator.CheckPhoneValidator;
import com.crud.btt.member.validator.CheckUserIdValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Slf4j
@AllArgsConstructor
@CrossOrigin
@RestController
public class MemberController {

    private final MemberService memberService;
    private final RegisterMail registerMail;

    //중복 체크 유효성 검사를 위한 멤버
    private final CheckUserIdValidator checkUserIdValidator;
    private final CheckPhoneValidator checkPhoneValidator;
    private final CheckEmailValidator checkEmailValidator;

    //커스텀 유효성 검증 => vue로 error message 전달
    @InitBinder
    public void validatorBinder(WebDataBinder binder){
        binder.addValidators(checkUserIdValidator);
        binder.addValidators(checkPhoneValidator);
        binder.addValidators(checkEmailValidator);

    }


    //해당 회원 존재 여부 확인 및 정보 출력용
//    @GetMapping("/member/{userCode}") //mapping은 임의로 작성한것.
//    public MemberDto getMember(@PathVariable Long userCode) {
//        return memberService.getMember(userCode);
//    }

    //탈퇴회원 quit table로 이동
//    @PostMapping
//    public QuitEntity create(@RequestBody MemberDto memberDto) {
//        return create(memberService.create(memberDto));
//    }

    //탈퇴하기
//    @DeleteMapping
//    public void delete(@PathVariable Long userCode) {
//
//        if(getMember(userCode) != null) {
//            //if(만약 quit create가 성공이라면){
//
//            //member table의 user를 삭제한다.
//            memberService.delete(userCode);
//            //}
//        }
//
//    }

    //로그인 처리용
//    @GetMapping("/member/login")
//    public void login(){
//        System.out.println("123");
////        LOG.info("GET successfully called on /login resource");
//    }


    //id 중복체크
    @GetMapping("/member/enroll/userId/{userId}")
    public ResponseEntity<Boolean> checkUserIdDuplicate(@RequestBody @Validated MemberDto memberDto, BindingResult bindingResult) {
      return ResponseEntity.ok(memberService.checkUserIdDuplication(memberDto.getUserId()));
//        if(bindingResult.hasErrors()){
//
//        }
    }
    //phone 중복체크
    @PostMapping("/member/enroll/phone/{phone}")
    public ResponseEntity<Boolean> checkPhoneDuplicate(@RequestBody @Validated MemberDto memberDto, BindingResult bindingResult) {
        return ResponseEntity.ok(memberService.checkPhoneDuplication(memberDto.getPhone()));
    }

    //email 중복체크
    @PostMapping("/member/enroll/email/{email}")
    public ResponseEntity<Boolean> checkEmailDuplicate(@RequestBody @Validated MemberDto memberDto, BindingResult bindingResult) {
        return ResponseEntity.ok(memberService.checkEmailDuplication(memberDto.getEmail()));
    }


    //회원가입
    @PostMapping("/enroll")
    public String execSignup(@RequestBody @Validated MemberDto memberDto, BindingResult bindingResult, Model model) {
        //검증
        if (bindingResult.hasErrors()){
            //회원가입 실패시 입력 데이터 값 유지
            model.addAttribute("memberDto", memberDto);

            //유효성 검사 불통 필드와 메세지 핸들링
            Map<String,String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put("valid_" + error.getField(), error.getDefaultMessage());
                log.info("error message : " + error.getDefaultMessage());
            }

            //회원가입 페이지로 리턴
            return new JSONObject(errorMap).toString();
        }

        memberService.save(memberDto);
        System.out.println(memberDto.toString());
        System.out.println(String.valueOf(new ResponseEntity<>(memberDto, HttpStatus.OK)));
        return "saveOk";
    }

    //아이디찾기
//    @GetMapping("/member/find/id")
//    public ResponseEntity<String> findId(String email){
//        return null;
//    }

//    //비밀번호찾기
//    @GetMapping("/member/find/id")
//    public String resetPassword(String user_name, String email, RedirectAttributes ra){
//        // 비밀번호를 찾으면 로그인 창으로 이동해 "임시 비밀번호를 이메일로 전송했습니다."라고 출력하려고 한다.
//        // 비밀번호를 못 찾으면 GET /member/reset_password로 이동해서 "비밀번호를 찾지 못했습니다"라고 출력하려고 한다.
////        Boolean result = service.resetPassword(username, email);
////        if(result==true) {
////            ra.addFlashAttribute("msg", "임시비밀번호를 이메일로 전송했습니다");
////            return "redirect:/member/login";
////        } else {
////            ra.addFlashAttribute("msg", "비밀번호를 찾지 못했습니다");
////            return "redirect:/member/reset_password";
////        }
//
//        //임시로 넣은것
//        return null;
//    }
//
//    //이메일인증
//    @PostMapping("/check/findPw/sendEmail")
//    public @ResponseBody void sendEmail(String userEmail, String userName){
////        MailDto dto = sendEmailService.createMailAndChangePassword(userEmail, userName);
////        sendEmailService.mailSend(dto);
//
//    }

    //회원가입 이메일 인증
    @GetMapping("/enroll/email")
    public String mailConfirm(@RequestParam("email") String email) throws Exception {
        System.out.println("이메일 인증을 위한 컨트롤러 도착!");
        System.out.println(email);
        String code = registerMail.sendSimpleMessage(email);
        System.out.println("인증코드 : " + code);
        return code;
    }

    //회원가입 핸드폰 인증
    @GetMapping("/enroll/phone")
    public String sendSMS(@RequestParam("phone") String phone) throws CoolsmsException {
        String code = memberService.autoPhoneNumber(phone);
        return code;
    }

}














