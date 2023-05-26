package com.crud.btt.member.controller;

import com.crud.btt.config.ForbiddenException;
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

import java.lang.reflect.Member;
import java.util.*;


@Slf4j
@AllArgsConstructor
//@CrossOrigin
//@RequestMapping("/member")
@RestController
public class MemberController {

    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;
    private final RegisterMail registerMail;
    private final BCryptPasswordEncoder passwordEncoder;



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

//    //아이디찾기
//    @PostMapping("/member/findid")
//    public ResponseEntity<?> selectId(@RequestBody MemberDto memberDto){
//        MemberEntity memberEntity = memberService.searchUserName(memberDto.getUserName());
//        return new ResponseEntity<>(true, HttpStatus.valueOf(memberEntity.getUserId()));
//    }
//
//
//    //비밀번호찾기
//    public ResponseEntity<?> findPw(@RequestBody MemberDto memberDto){
//        MemberEntity memberEntity = memberService.sea
//    }

//    @PostMapping("/member/login")
//    public ResponseEntity<String> loginSuccess(@RequestBody Map<String, String> loginForm){
//        log.info("여기는왔니?");
//        String token = memberService.login(loginForm.get("username"), loginForm.get("password"));
//
////        return ResponseEntity.ok(token);
//        return ResponseEntity.ok(token);
//    }

//      @PostMapping("/member/login")
//      public ResponseEntity<JwtToken> loginSuccess(@Valid @RequestBody MemberDto memberDto){
//
//          UsernamePasswordAuthenticationToken authenticationToken =
//                  new UsernamePasswordAuthenticationToken(memberDto.getUserId(), memberDto.getUserPw());
//
//          Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//          SecurityContextHolder.getContext().setAuthentication(authentication);
//
//          String jwt = jwtTokenProvider.createToken(authentication);
//
//          HttpHeaders httpHeaders = new HttpHeaders();
//          httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
//
//          return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
//    }


//    @PostMapping("/member/login")
//    public ResponseEntity<JwtToken> authorize(@Valid @RequestBody MemberDto memberDto) {
//
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(memberDto.getUserId(), memberDto.getUserPw());
//
//        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String jwt = tokenProvider.createToken(authentication);
//
//        return new ResponseEntity<>(new JwtToken(jwt), HttpStatus.OK);
//    }



//    //해당 회원 존재 여부 확인 및 정보 출력용
////    @GetMapping("/member/{userCode}") //mapping은 임의로 작성한것.
////    public MemberDto getMember(@PathVariable Long userCode) {
////        return memberService.getMember(userCode);
////    }
//
//    //탈퇴회원 quit table로 이동
////    @PostMapping
////    public QuitEntity create(@RequestBody MemberDto memberDto) {
////        return create(memberService.create(memberDto));
////    }
//
//    //탈퇴하기
////    @DeleteMapping
////    public void delete(@PathVariable Long userCode) {
////
////        if(getMember(userCode) != null) {
////            //if(만약 quit create가 성공이라면){
////
////            //member table의 user를 삭제한다.
////            memberService.delete(userCode);
////            //}

//    //로그인 처리용
////    @GetMapping("/member/login")
////    public void login(){
////        System.out.println("123");
//////        LOG.info("GET successfully called on /login resource");
////    }

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
////    @GetMapping("/member/find/id")
////    public ResponseEntity<String> findId(String email){
////        return null;
////    }
//
////    //비밀번호찾기
////    @GetMapping("/member/find/id")
////    public String resetPassword(String user_name, String email, RedirectAttributes ra){
////        // 비밀번호를 찾으면 로그인 창으로 이동해 "임시 비밀번호를 이메일로 전송했습니다."라고 출력하려고 한다.
////        // 비밀번호를 못 찾으면 GET /member/reset_password로 이동해서 "비밀번호를 찾지 못했습니다"라고 출력하려고 한다.
//////        Boolean result = service.resetPassword(username, email);
//////        if(result==true) {
//////            ra.addFlashAttribute("msg", "임시비밀번호를 이메일로 전송했습니다");
//////            return "redirect:/member/login";
//////        } else {
//////            ra.addFlashAttribute("msg", "비밀번호를 찾지 못했습니다");
//////            return "redirect:/member/reset_password";
//////        }
////
////        //임시로 넣은것
////        return null;
////    }
////
////    //이메일인증
////    @PostMapping("/check/findPw/sendEmail")
////    public @ResponseBody void sendEmail(String userEmail, String userName){
//////        MailDto dto = sendEmailService.createMailAndChangePassword(userEmail, userName);
//////        sendEmailService.mailSend(dto);
////
////    }

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

    @GetMapping("/member/info/{userId}")
    public MemberDto getMemberInfo(@PathVariable("userId") String userId) {
        return memberService.getMemberInfo(userId);
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


















