package com.crud.btt.member.model.service;

import com.crud.btt.member.entity.MemberEntity;
import com.crud.btt.member.entity.MemberRepository;
import com.crud.btt.member.entity.QuitEntity;
import com.crud.btt.member.entity.QuitRepository;
import com.crud.btt.member.model.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final QuitRepository quitRepository;
    private static final String FROM_ADDRESS = "본인의 이메일 주소를 입력하세요!";

    //user info 가져오기. 존재여부 확인
    public MemberDto getMember(Long user_code) {
        MemberEntity entity = memberRepository.findById(user_code).orElseThrow(()
                -> new RuntimeException("해당 회원을 찾을 수 없습니다."));
        return MemberDto.builder()
                .user_code(entity.getUser_code())
                .user_id(entity.getUser_id())
                .user_pw(entity.getUser_pw())
                .user_name(entity.getUser_name())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .kakao_id(entity.getKakao_id())
                .naver_id(entity.getNaver_id())
                .google_id(entity.getGoogle_id())
                .permit(entity.getPermit())
                .enroll_date(entity.getEnroll_date())
                .build();
    }

    //회원 탈퇴
    public void delete(Long user_code) {
        MemberEntity entity = memberRepository.findById(user_code).orElseThrow(()
                -> new RuntimeException("해당 회원을 찾을 수 없습니다."));
        memberRepository.delete(entity);
    }


    public MemberDto create(MemberDto memberDto) {
        QuitEntity entity = QuitEntity.builder()
                .quit_user_code(memberDto.getUser_code())
                .quit_user_id(memberDto.getUser_id())
                .quit_user_pw(memberDto.getUser_pw())
                .quit_user_name(memberDto.getUser_name())
                .quit_phone(memberDto.getPhone())
                .quit_email(memberDto.getEmail())
                .quit_kakao_id(memberDto.getKakao_id())
                .quit_naver_id(memberDto.getNaver_id())
                .quit_google_id(memberDto.getGoogle_id())
                .build();
        return quitRepository.save(entity); //quit 쿼리문 생성
    }

    //회원가입
    @Transactional
    public void saveMember(MemberDto memberDto) throws Exception{
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
    public void updatePassword(String str,String userEmail){
//        String pw = EncryptionUtils.encryptMD5(str);
//        int id = userRepository.findUserByUserId(userEmail).getId();
//        userRepository.updateUserPassword(id,pw);
    }

    //난수생성
    public String getTempPassword(){
//        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
//                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
//
//        String str = "";
//
//        int idx = 0;
//        for (int i = 0; i < 10; i++) {
//            idx = (int) (charSet.length * Math.random());
//            str += charSet[idx];
//        }
//        return str;
        return null;
    }

}
