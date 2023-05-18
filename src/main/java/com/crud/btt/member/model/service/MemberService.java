//package com.crud.btt.member.model.service;
//
//import com.crud.btt.member.entity.MemberEntity;
//import com.crud.btt.member.entity.MemberRepository;
//import com.crud.btt.member.entity.QuitEntity;
//import com.crud.btt.member.entity.QuitRepository;
//import com.crud.btt.member.model.dto.MemberDto;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.sql.Date;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@Slf4j
//@AllArgsConstructor
//@Transactional
//@Service
//public class MemberService implements UserDetailsService {
//
//    private final MemberRepository memberRepository;
//    private final QuitRepository quitRepository;
//    private static final String FROM_ADDRESS = "본인의 이메일 주소를 입력하세요!";
//
//    //user info 가져오기. 존재여부 확인
////    public MemberDto getMember(Long userCode) {
////        MemberEntity entity = memberRepository.findById(userCode).orElseThrow(()
////                -> new RuntimeException("해당 회원을 찾을 수 없습니다."));
////        return MemberDto.builder()
////                .userCode(entity.getUserCode())
////                .userId(entity.getUserId())
////                .userPw(entity.getUserPw())
////                .userName(entity.getUsername())
////                .phone(entity.getPhone())
////                .email(entity.getEmail())
////                .kakaoId(entity.getKakaoId())
////                .naverId(entity.getNaverId())
////                .googleId(entity.getGoogleId())
////                .permit(entity.getPermit())
////                .enrollDate(entity.getEnrollDate()
////                .build();
////    }
//
//    //회원 탈퇴
//    public void delete(Long userCode) {
//        MemberEntity entity = memberRepository.findById(userCode).orElseThrow(()
//                -> new RuntimeException("해당 회원을 찾을 수 없습니다."));
//        memberRepository.delete(entity);
//    }
//
//
//    public QuitEntity create(MemberDto memberDto) {
//        QuitEntity entity = QuitEntity.builder()
//                .quitUserCode(memberDto.getUserCode())
//                .quitUserId(memberDto.getUserId())
//                .quitUserPw(memberDto.getUserPw())
//                .quitUserName(memberDto.getUserName())
//                .quitPhone(memberDto.getPhone())
//                .quitEmail(memberDto.getEmail())
//                .quitKakaoId(memberDto.getKakaoId())
//                .quitNaverId(memberDto.getNaverId())
//                .quitGoogleId(memberDto.getGoogleId())
//                .build();
//        return quitRepository.save(entity); //quit 쿼리문 생성
//    }
//
//    //id, phone, email 중복체크
//    @Transactional(readOnly = true)
//    public boolean checkUserIdDuplication(String userId) {
//        boolean userIdDuplicate = memberRepository.existsByUserId(userId);
//        return userIdDuplicate;
//    }
//
//    @Transactional(readOnly = true)
//    public boolean checkPhoneDuplication(String phone) {
//        boolean userPhoneDuplicate = memberRepository.existsByPhone(phone);
//        return userPhoneDuplicate;
//    }
//
//    @Transactional(readOnly = true)
//    public boolean checkEmailDuplication(String email) {
//        boolean emailDuplicate = memberRepository.existsByEmail(email);
//        return emailDuplicate;
//    }
//
//
//
//    //회원가입
//    public Long save(MemberDto memberDto){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        memberDto.setUserPw(passwordEncoder.encode(memberDto.getUserPw()));
//
//        return memberRepository.save(MemberEntity.builder()
//                .userId(memberDto.getUserId())
//                .userPw(memberDto.getUserPw())
//                .userName(memberDto.getUserName())
//                .phone(memberDto.getPhone())
//                .email(memberDto.getEmail())
//                .enrollDate(LocalDateTime.now())
//                .build()
//        ).getUserCode();
//    }
//
//
//    //아이디찾기
////    public Optional<Member> findById(Long id) {
////        List<Member> result = jdbcTemplate.query("select*from member where id = ?", memberRowMapper(),id);
////        return result.stream().findAny();
////    }
//
//
//    //임시비밀번호 메일 보내기
////    public MailDto createMailAndChangePassword(String userEmail, String userName){
////        String str = getTempPassword();
////        MailDto dto = new MailDto();
////        dto.setAddress(userEmail);
////        dto.setTitle(userName+"님의 HOTTHINK 임시비밀번호 안내 이메일 입니다.");
////        dto.setMessage("안녕하세요. HOTTHINK 임시비밀번호 안내 관련 이메일 입니다." + "[" + userName + "]" +"님의 임시 비밀번호는 "
////                + str + " 입니다.");
////        updatePassword(str,userEmail);
////        return dto;
////    }
//
//    //임시비밀번호로 변경
//    public void updatePassword(String str,String userEmail){
////        String pw = EncryptionUtils.encryptMD5(str);
////        int id = userRepository.findUserByUserId(userEmail).getId();
////        userRepository.updateUserPassword(id,pw);
//    }
//
//    //난수생성
//    public String getTempPassword(){
////        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
////                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
////
////        String str = "";
////
////        int idx = 0;
////        for (int i = 0; i < 10; i++) {
////            idx = (int) (charSet.length * Math.random());
////            str += charSet[idx];
////        }
////        return str;
//        return null;
//    }
//
//    /**
//     * Spring Security 필수 메소드 구현
//     *
//     * @param //email 이메일
//     * @return UserDetails
//     * @throws //UsernameNotFoundException 유저가 없을 때 예외 발생
//     */
//    @Override   //기본 반환 타입 : Member
//    public MemberEntity loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
//
//
//}
