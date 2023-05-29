package com.crud.btt.member.model.service;

import com.crud.btt.common.Header;
import com.crud.btt.jwt.JwtTokenProvider;
import com.crud.btt.member.entity.MemberEntity;
import com.crud.btt.member.entity.MemberRepository;
import com.crud.btt.member.entity.QuitEntity;
import com.crud.btt.member.entity.QuitRepository;
import com.crud.btt.member.model.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Slf4j
@AllArgsConstructor
@Transactional
@Service
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final QuitRepository quitRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;



    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //회원 탈퇴
    public void delete(Long userCode) {
        MemberEntity entity = memberRepository.findById(userCode).orElseThrow(()
                -> new RuntimeException("해당 회원을 찾을 수 없습니다."));
        memberRepository.delete(entity);
    }

    public QuitEntity create(MemberDto memberDto) {
        QuitEntity entity = QuitEntity.builder()
                .quitUserCode(memberDto.getUserCode())
                .quitUserId(memberDto.getUserId())
                .quitUserPw(memberDto.getUserPw())
                .quitUserName(memberDto.getUserName())
                .quitPhone(memberDto.getPhone())
                .quitEmail(memberDto.getEmail())
                .quitKakaoId(memberDto.getKakaoId())
                .quitNaverId(memberDto.getNaverId())
                .quitGoogleId(memberDto.getGoogleId())
                .build();
        return quitRepository.save(entity); //quit 쿼리문 생성
    }

    //id, phone, email 중복체크
    @Transactional(readOnly = true)
    public boolean checkUserIdDuplication(String userId) {
        boolean userIdDuplicate = memberRepository.existsByUserId(userId);
        return userIdDuplicate;
    }

    @Transactional(readOnly = true)
    public boolean checkPhoneDuplication(String phone) {
        boolean userPhoneDuplicate = memberRepository.existsByPhone(phone);
        return userPhoneDuplicate;
    }

    @Transactional(readOnly = true)
    public boolean checkEmailDuplication(String email) {
        boolean emailDuplicate = memberRepository.existsByEmail(email);
        return emailDuplicate;
    }


    //회원가입
    public Long save(MemberDto memberDto) {


        memberDto.setUserPw(passwordEncoder.encode(memberDto.getUserPw()));
        //MemberAuth memberAuth = new MemberAuth();

        return memberRepository.save(MemberEntity.builder()
                .userId(memberDto.getUserId())
                .userPw(memberDto.getUserPw())
                .userNamee(memberDto.getUserName())
                .phone(memberDto.getPhone())
                .email(memberDto.getEmail())
                .enrollDate(LocalDateTime.now())
                .permit("Y")
                .auth("ROLE_MEMBER")
                .build()
        ).getUserCode();

    }

    public MemberDto getMemberInfo(String userId) {
        MemberEntity memberEntity = memberRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("회원 정보를 찾을 수 없습니다."));
        return MemberDto.builder()
                .userCode(memberEntity.getUserCode())
                .userId(memberEntity.getUserId())
                .userPw(memberEntity.getUserPw())
                .userName(memberEntity.getUserNamee())
                .phone(memberEntity.getPhone())
                .email(memberEntity.getEmail())
                .auth(memberEntity.getAuth())
                .build();
    }

    /**
     * Spring Security 필수 메소드 구현
     *
     * @param //email 이메일
     * @return UserDetails
     * @throws //UsernameNotFoundException 유저가 없을 때 예외 발생
     */
//    @Override   //기본 반환 타입 : Member
//    public MemberEntity loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findByUserId(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
    }

//         해당하는 User 의 데이터가 존재한다면 UserDetails 객체로 만들어서 리턴
    private UserDetails createUserDetails(MemberEntity member) {
        return User.builder()
                .username(member.getUsername())
                .password(member.getUserPw())
//                .roles(member.getAuth())
                .build();
    }

    //회원가입 핸드폰 인증
    public String autoPhoneNumber(String phone) throws CoolsmsException {
        String api_key = "NCSAXYKAJ1BPSNRP";
        String api_secret = "ZNSC1NPSRO0FCUH9RN5XWG7MAJPXU81Z";
        Message coolsms = new Message(api_key, api_secret);

        //인증번호 생성
        Random random = new Random();
        String code = "";   //인증번호

        for (int i = 0; i < 4; i++) {
            String no = Integer.toString(random.nextInt(10));
            code += no;
        }

        //체크
        System.out.println("수신자 번호 :" + phone);
        System.out.println("인증번호 : " + code);

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phone);    //수신번호
        params.put("from", "01042357723"); //발신번호
        params.put("type", "sms");
        params.put("text", "안녕하세요.\n" +
                "Batter then Talk 입니다.\n" +
                "인증번호입니다.\n" +
                "[ " + code + " ]");

        coolsms.send(params);
        return code;
    }

    public MemberDto read(Long userCode) throws Exception{
        MemberEntity memberEntity = memberRepository.findByUserCode(userCode).orElseThrow(() -> new RuntimeException());
        memberRepository.getOne(userCode);

        return MemberDto.builder()
                .userId(memberEntity.getUserId())
                .userName(memberEntity.getUserNamee())
                .phone(memberEntity.getPhone())
                .email(memberEntity.getEmail())
                .build();
    }

    //admin top5리스트
    public Header<List<MemberDto>> top5UserList(){

        List<MemberDto> list = new ArrayList<>();

        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

        List<MemberEntity> entities = memberRepository.findTop5ByOrderByEnrollDateDesc();
        for (MemberEntity entity : entities) {
            MemberDto dto = MemberDto.builder()
                    .userCode(entity.getUserCode())
                    .userId(entity.getUserId())
                    .userPw(entity.getUserPw())
                    .userName(entity.getUserNamee())
                    .phone(entity.getPhone())
                    .email(entity.getEmail())
                    .kakaoId(entity.getKakaoId())
                    .naverId(entity.getNaverId())
                    .googleId(entity.getGoogleId())
                    .permit(entity.getPermit())
                    .enrollDate(entity.getEnrollDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .build();

            list.add(dto);
        }

        log.info("list" + list);

        return Header.OK(list);
    }

    //회원정보수정
    public MemberDto memberupdate(MemberDto memberDto){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setUserPw(passwordEncoder.encode(memberDto.getUserPw()));

        MemberEntity memberEntity = MemberEntity.builder()
                .userId(memberDto.getUserId())
                .userPw(memberDto.getUserPw())
                .phone(memberDto.getPhone())
                .email(memberDto.getEmail())
                .build();

        memberRepository.saveByPwPhEm(memberEntity.getUserPw(), memberEntity.getPhone(),
                memberEntity.getEmail(), memberDto.getUserId());

        return memberDto;

    }


    //회원수정시 기본정보 불러오기
    public MemberDto updateread(Long userCode) throws Exception{
        MemberEntity memberEntity = memberRepository.findByUserCode(userCode).orElseThrow(() -> new RuntimeException("회원을 찾을수 없습니다."));
        memberRepository.getOne(userCode);

        return MemberDto.builder()
                .userId(memberEntity.getUserId())
                .userName(memberEntity.getUserNamee())
                .build();
    }

    //Quit 테이블 유저정보 옮기기
    public QuitEntity createQuit(MemberDto memberDto) {
        log.info("-------------------------------------");
        log.info(memberDto.getUserName());
        return quitRepository.save(QuitEntity.builder()
                .quitUserCode(memberDto.getUserCode())
                .quitUserId(memberDto.getUserId())
                .quitUserPw(memberDto.getUserPw())
                .quitUserName(memberDto.getUserName())
                .quitPhone(memberDto.getPhone())
                .quitEmail(memberDto.getEmail())
                .quitKakaoId(memberDto.getKakaoId())
                .quitNaverId(memberDto.getNaverId())
                .quitGoogleId(memberDto.getGoogleId())
                .quitPermit("Q")
                .quitDate(LocalDateTime.now())
                .quitAuth(memberDto.getAuth())
                .build());
    }
    //id find - phone
    public MemberEntity findIdP(String userName, String phone) {
        System.out.println("여기 서비스단 아이디");
        MemberEntity memberEntity = memberRepository.findByUserNameAndPhone(userName, phone);

        return MemberDto.builder()
                .userId(memberEntity.getUserId())
                .build().toEntity();

    }

    //id find - email
    public MemberEntity findIdE(String userName, String email) {

        MemberEntity memberEntity = memberRepository.findByUserNameAndEmail(userName, email);

        return MemberDto.builder()
                .userId(memberEntity.getUserId())
                .build().toEntity();
    }


    //임시비밀번호로 변경
    public MemberDto updatePassword(MemberDto memberDto, String message) {
        String newPw = message;

        if( memberDto != null){
            log.info(newPw);

            memberDto.setUserPw(passwordEncoder.encode(message));

          MemberEntity memberEntity = MemberEntity.builder()
                  .userPw(memberDto.getUserPw())
                  .build();

            log.info(memberEntity.getUserPw());

          memberRepository.saveByPw(memberEntity.getUserPw(), memberDto.getUserId());
            log.info("서비스 (비밀번호 변경) : " + memberDto.toString());
            return memberDto;
        }

            return memberDto;
    }


    //pw find - phone
    public MemberDto findPwP(String userId, String phone) {
        System.out.println("여기 서비스단- 패스워드 찾기를 위해 유저 확인_phone");
        MemberEntity memberEntity = memberRepository.findByUserIdAndPhone(userId, phone);
        return MemberDto.builder()
                .userCode(memberEntity.getUserCode())
                .userId(memberEntity.getUserId())
                .userPw(memberEntity.getUserPw())
                .userName(memberEntity.getUserNamee())
                .phone(memberEntity.getPhone())
                .email(memberEntity.getEmail())
                .auth(memberEntity.getAuth())
                .build();
    }

    //pw find - email
    public MemberDto findPwE(String userId, String email) {
        System.out.println("여기 서비스단- 패스워드 찾기를 위해 유저 확인_email");
        MemberEntity memberEntity = memberRepository.findByUserIdAndEmail(userId, email);
        return MemberDto.builder()
                .userCode(memberEntity.getUserCode())
                .userId(memberEntity.getUserId())
                .userPw(memberEntity.getUserPw())
                .userName(memberEntity.getUserNamee())
                .phone(memberEntity.getPhone())
                .email(memberEntity.getEmail())
                .auth(memberEntity.getAuth())
                .build();
    }

}


