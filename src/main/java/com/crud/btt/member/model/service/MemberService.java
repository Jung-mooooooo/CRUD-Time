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
//    private final MemberEntity memberE;


    //    private final PasswordEncoder passwordEncoder;
    private static final String FROM_ADDRESS = "본인의 이메일 주소를 입력하세요!";

    //user info 가져오기. 존재여부 확인
//    public MemberDto getMember(Long userCode) {
//        MemberEntity entity = memberRepository.findById(userCode).orElseThrow(()
//                -> new RuntimeException("해당 회원을 찾을 수 없습니다."));
//        return MemberDto.builder()
//                .userCode(entity.getUserCode())
//                .userId(entity.getUserId())
//                .userPw(entity.getUserPw())
//                .userName(entity.getUsername())
//                .phone(entity.getPhone())
//                .email(entity.getEmail())
//                .kakaoId(entity.getKakaoId())
//                .naverId(entity.getNaverId())
//                .googleId(entity.getGoogleId())
//                .permit(entity.getPermit())
//                .enrollDate(entity.getEnrollDate()
//                .build();
//    }

    //회원 탈퇴
    public void delete(Long userCode) {
        MemberEntity entity = memberRepository.findById(userCode).orElseThrow(()
                -> new RuntimeException("해당 회원을 찾을 수 없습니다."));
        memberRepository.delete(entity);
    }

    //로그인
//    public String login(String userId, String userPw) {
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, userPw);
//        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//
//        String token = jwtTokenProvider.generateToken(authentication);
//
//        return token;
//    }


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

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setUserPw(passwordEncoder.encode(memberDto.getUserPw()));
        //MemberAuth memberAuth = new MemberAuth();

        return memberRepository.save(MemberEntity.builder()
                .userId(memberDto.getUserId())
                .userPw(memberDto.getUserPw())
                .userNamee(memberDto.getUserName())
                .phone(memberDto.getPhone())
                .email(memberDto.getEmail())
                .enrollDate(LocalDateTime.now())
                .auth("ROLE_MEMBER")
                .build()
        ).getUserCode();


//
//        MemberEntity memberEntity = MemberEntity.builder()
//                .userId(memberDto.getUserId())
//                .userPw(memberDto.getUserPw())
//                .userName(memberDto.getUserName())
//                .phone(memberDto.getPhone())
//                .email(memberDto.getEmail())
//                .enrollDate(LocalDateTime.now())
//                .auth(memberDto.getAuth())
//                .build();
//


//        return memberRepository.save(memberEntity);



//         MemberEntity memberEntity = MemberEntity.builder()
//                 .userId(memberDto.getUserId())
//                 .userPw(memberDto.getUserPw())
//                 .userName(memberDto.getUserName())
//                 .phone(memberDto.getPhone())
//                 .email(memberDto.getEmail())
//                 .enrollDate(LocalDateTime.now())
//                 .build();
//         System.out.println("member 유저코드 : " + memberEntity.getUserCode());

//         MemberAuth memberAuth = new MemberAuth();
//         memberAuth.setAuth("ROLE_MEMBER");
//         memberEntity.addAuth(memberAuth);
//         System.out.println("권한 유저코드 에러임?");


// //        memberRepository.save(memberE);



//         return memberRepository.save(memberEntity);

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


    //아이디찾기
//    public Optional<Member> findById(Long id) {
//        List<Member> result = jdbcTemplate.query("select*from member where id = ?", memberRowMapper(),id);
//        return result.stream().findAny();
//    }


    //임시비밀번호 메일 보내기
//    public MailDto createMailAndChangePassword(String userEmail, String userName){
//        String str = getTempPassword();
//        MailDto dto = new MailDto();
//        dto.setAddress(userEmail);
//        dto.setTitle(userName+"님의 HOTTHINK 임시비밀번호 안내 이메일 입니다.");
//        dto.setMessage("안녕하세요. HOTTHINK 임시비밀번호 안내 관련 이메일 입니다." + "[" + userName + "]" +"님의 임시 비밀번호는 "
//                + str + " 입니다.");
//        updatePassword(str,userEmail);
//        return dto;
//    }

    //임시비밀번호로 변경
    public void updatePassword(String str, String userEmail) {
//        String pw = EncryptionUtils.encryptMD5(str);
//        int id = userRepository.findUserByUserId(userEmail).getId();
//        userRepository.updateUserPassword(id,pw);
    }

    //난수생성
    public String getTempPassword() {
//        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
//                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
//         String str = "";
//        int idx = 0;
//        for (int i = 0; i < 10; i++) {
//            idx = (int) (charSet.length * Math.random());
//            str += charSet[idx];
//        }
//        return str;
        return null;
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
                "회원 가입 인증번호입니다.\n" +
                "[ " + code + " ]");

        coolsms.send(params);
        return code;
    }

    public MemberEntity read(Long userCode) throws Exception{
        return memberRepository.getOne(userCode);
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
                    .enrollDate(String.valueOf(entity.getEnrollDate()))
                    .build();

            list.add(dto);
        }

        log.info("list" + list);

        return Header.OK(list);
    }

}


