package com.crud.btt.member.controller;

import com.crud.btt.admin.model.service.AdminService;
import com.crud.btt.common.Header;
import com.crud.btt.config.ForbiddenException;
import com.crud.btt.admin.controller.AdminController;
import com.crud.btt.admin.entity.EmotionEntity;
import com.crud.btt.admin.model.dto.EmotionDto;
import com.crud.btt.jwt.JwtToken;
import com.crud.btt.jwt.JwtTokenProvider;
import com.crud.btt.member.entity.MemberEntity;
import com.crud.btt.member.entity.MemberRepository;
import com.crud.btt.member.model.dto.MemberDto;
import com.crud.btt.member.model.service.MemberService;
import com.crud.btt.member.validator.CheckEmailValidator;
import com.crud.btt.member.validator.CheckPhoneValidator;
import com.crud.btt.member.validator.CheckUserIdValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Member;
import java.util.*;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@AllArgsConstructor
//@CrossOrigin
//@RequestMapping("/member")
@RestController
public class MemberController {

    private final AdminService adminService;
    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;
    private final RegisterMail registerMail;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RegisterMailForPw registerMailForPw;

    //emotion을 위한 컨트롤러
    private final AdminController adminController;


    private final AuthenticationManagerBuilder authenticationManagerBuilder;


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

    // 비밀번호 확인
    @PostMapping("/mypage/popupD")
    public void popupD(@RequestBody MemberDto memberDto){

        log.info("----------------------------------");
        log.info("여기왔냐?");
        log.info(memberDto.getUserPw());
        log.info(memberDto.getUserId());
        MemberEntity member = memberRepository.findByUserId(memberDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));

        if(!passwordEncoder.matches(memberDto.getUserPw(), member.getUserPw())){
            throw new ForbiddenException("패스원드가 일치하지 않습니다.");
        }
        System.out.println("비밀번호 확인 성공");
    }

    // 비밀번호 확인
    @PostMapping("/mypage/popupU")
    public void popupU(@RequestBody MemberDto memberDto){

        log.info("----------------------------------");
        log.info("여기왔냐?");
        log.info(memberDto.getUserPw());
        log.info(memberDto.getUserId());
        MemberEntity member = memberRepository.findByUserId(memberDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));

        if(!passwordEncoder.matches(memberDto.getUserPw(), member.getUserPw())){
            throw new ForbiddenException("패스원드가 일치하지 않습니다.");
        }
        System.out.println("비밀번호 확인 성공");
    }

    // QUIT 테이블 유저정보 옮기기
    @PostMapping("/member/quit")
    public void createQuit(@RequestBody MemberDto memberDto){
        log.info("----------------------------------");
        log.info("여기왔냐?");
        log.info(String.valueOf(memberDto.getUserCode()));
        MemberEntity member = memberRepository.findByUserId(memberDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));
        if(!Objects.equals(memberDto.getUserCode(), member.getUserCode())){
            throw new ForbiddenException("유저 정보가 없습니다.");
        }
        memberService.createQuit(memberDto);

        memberRepository.delete(member);
    }

    //회원 정보 수정
    @PatchMapping("/member/update")
    public void memberupdate(@RequestBody MemberDto memberDto){

        MemberEntity member = memberRepository.findByUserId(memberDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));
        if(!Objects.equals(memberDto.getUserCode(), member.getUserCode())){
            throw new ForbiddenException("유저 정보가 없습니다.");
        }

         memberService.memberupdate(memberDto);
    }



    @PostMapping("/member/login")
    public String login(@RequestBody MemberDto memberDto, String userId, String userPw) {
//        log.info("user email = {}", user.get("email"));

        MemberEntity member = memberRepository.findByUserId(memberDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));

        if(!passwordEncoder.matches(memberDto.getUserPw(), member.getUserPw())){
            throw new ForbiddenException("패스원드가 일치하지 않습니다.");
        }

        return jwtTokenProvider.createToken(member.getUserId(), member.getAuth());
    }


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
    @GetMapping("/find/id/{val1}/{val2}/{val3}")
    public String findId(@PathVariable(value = "val1") String userName,
                                         @PathVariable(value = "val2") String key,
                                         @PathVariable(value = "val3") String item) {
       String userId = null;

        log.info(userName);
        log.info(key);
        log.info(item);


        //핸드폰
        if(userName != null && item != null && key.equals("phone")) {
            userId = memberService.findIdP(userName, item).getUserId();
            log.info("아이디 핸드폰으로 찾기" + userId);

            System.out.println(userId);
        }

        //이메일
        if(userName != null && item != null && key.equals("email")) {
            userId = memberService.findIdE(userName, item).getUserId();
            log.info("아이디 이메일 찾기" + userId);
        }

        return userId;
    }

    //비밀번호 찾기
    @GetMapping("/find/pw/{val1}/{val2}/{val3}")
    public ResponseEntity<String> findPw(@PathVariable(value = "val1") String userId,
                         @PathVariable(value = "val2") String key,
                         @PathVariable(value = "val3") String item) {
        //check
        log.info(userId);
        log.info(key);
        log.info(item);

        MemberDto member = null;
        RegisterMailForPw mailSend = new RegisterMailForPw();


        //핸드폰
        if (userId != null && item != null && key.equals("phone")) {
            member = memberService.findPwP(userId, item);

            if (member != null) {
                System.out.println(member.getUserId());

                try {
                    log.info(member.getEmail());
                    String message = pwSendMail(member.getEmail());
                    member = memberService.updatePassword(member, message);
                    return new ResponseEntity<>("ok", HttpStatus.OK);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }

        //이메일
        if (userId != null && item != null && key.equals("email")) {
            member = memberService.findPwE(userId, item);

            if (member != null) {
                System.out.println(member.getUserId());

                try {
                    String message = pwSendMail(member.getEmail());
                    member = memberService.updatePassword(member, message);
                    return new ResponseEntity<>("ok", HttpStatus.OK);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return new ResponseEntity<>("no", HttpStatus.OK);


    }


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

    //세션 값 전화
    @GetMapping("/member/info/{userId}")
    public MemberDto getMemberInfo(@PathVariable("userId") String userId, HttpServletRequest request) throws Exception {
        Optional<MemberEntity> user = memberRepository.findByUserId(userId);
        Long userCode = user.get().getUserCode();
        adminService.getClientIP(userCode, request);
        MemberDto memberDto = memberService.getMemberInfo(userId);
        EmotionDto emotionDto = new EmotionDto();
        emotionDto.setUserCode(memberDto.getUserCode());

            adminController.userEmotion(emotionDto);


        return memberDto;
    }

    //이메일 인증
    public String pwSendMail(String email) throws Exception {
        System.out.println("이메일 인증을 위한 컨트롤러 도착!");
        System.out.println(email);
        String code = registerMailForPw.sendSimpleMessage(email);
        System.out.println("인증코드 : " + code);
        return code;
    }



//    @PreAuthorize("hasAnyRole('ADMIN','MEMBER')")
//    @GetMapping("/myinfo")
//    public ResponseEntity<MemberEntity> getMyInfo(@AuthenticationPrincipal MemberEntity Memberentity) throws Exception {
//        Long userCode = Memberentity.getUserCode();
//        log.info("register userNo = " + userCode);
//
//        MemberEntity member = memberService.read(userCode);
//
//        member.setUserPw("");
//
//        return new ResponseEntity<>(member, HttpStatus.OK);
//    }


    //내정보보기

    //admin top5리스트
    @GetMapping("admin/userlist")
    public Header<List<MemberDto>> getTop5UserList(){

        List<MemberDto> list = new ArrayList<>();
        log.info("list" + list);

        return memberService.top5UserList();
    }
    @GetMapping("/member/myinfo/{userCode}")
    public MemberDto read(@PathVariable("userCode") Long userCode) throws Exception {
;
//        MemberEntity member = memberService.read(userCode);
        log.info("------------------------------");
        return memberService.read(userCode);
    }

    @GetMapping("/member/update/{userCode}")
    public MemberDto updateread(@PathVariable("userCode") Long userCode) throws Exception {
        ;
//        MemberEntity member = memberService.read(userCode);
        log.info("------------------------------");
        return memberService.updateread(userCode);
    }

    @GetMapping("/member/list")
    public List<MemberDto> getDeptList() {
        List<MemberEntity> deptlist = memberRepository.findAll();
        List<MemberDto> list = new ArrayList<>();

        for(MemberEntity entity : deptlist){
            MemberDto memberDto = MemberDto.builder()
                    .userId(entity.getUserId())
                    .userName(entity.getUserNamee())
                    .phone(entity.getPhone())
                    .email(entity.getEmail())
                    .build();
            list.add(memberDto);
        }

        log.info(list.toString());

        return list;
    }
}



















