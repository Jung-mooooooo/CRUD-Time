package com.crud.btt.admin.model.service;

import com.crud.btt.admin.entity.*;
import com.crud.btt.common.CustomPageable;
import com.crud.btt.common.Header;
import com.crud.btt.common.Pagination;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.member.entity.MemberEntity;
import com.crud.btt.member.entity.MemberRepository;
import com.crud.btt.member.model.dto.MemberDto;
import com.crud.btt.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {
//    private final SpLogRepository spLogRepository;
    private final LogRepository logRepository;
    private final EmotionRepository emotionRepository;
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final AdminRepositoryCustom adminRepositoryCustom;

//    private final ChatLogRepository chatLogRepository;
//    private final ChatLogRepositoryCustom chatLogRepositoryCustom;
//
//    //리스트 출력
//    public Header<List<ChatLogDto>> getChatLogList(Pageable pageable, SearchCondition searchCondition) {
//        return null;
//    }
//
//    //등록
//    public ChatLogEntity create(ChatLogDto chatLogDto) {
//        ChatLogEntity entity = ChatLogEntity.builder()
//                .userCode1(chatLogDto.getUserCode1())
//                .userCode2(chatLogDto.getUserCode2())
//                .accessTime(chatLogDto.getAccessTime())
//                .entrance(chatLogDto.getEntrance())
//                .link(chatLogDto.getLink())
//                .build();
//        return chatLogRepository.save(entity);
//    }




    //감정현황 조회
    public List<EmotionEntity> emotionCount(){

        return emotionRepository.countEmotionCat();
    }


    //접속자 수 조회
    public Long visitCount() {
        return logRepository.countByLogNo();
    }

    //월 접속자 수 조회
    public Long visitCountMonth() {
        return logRepository.countByMonthLogNo();
    }


    //접속자 로그테이블에 저장하기
    public LogEntity getClientIP(@RequestBody Long userCode, HttpServletRequest request) throws Exception {
//         MemberEntity member = memberService.read(userCode);
//         log.info(member.toString());

        String ip = request.getHeader("X-FORWARDED-FOR");

        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
            log.info(">>>> Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            log.info(">>>> WL-Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            log.info(">>>> HTTP_CLIENT_IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            log.info(">>>> HTTP_X_FORWARDED_FOR : " + ip);
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        log.info(">>>> Result : IP Address : "+ip);

        LogEntity entity = LogEntity.builder()
                .userCode(userCode)
                .visitIp(ip)
                .visitTime(LocalDateTime.now())
                .build();

        log.info("ip" + ip);
        log.info("entity" + entity);

        return logRepository.save(entity);
    }


    //유저 감정현황 저장
    public EmotionEntity SaveUserEmotion(String emotion, Long userCode) {
        log.info("현재 " + userCode +"의 감정은 "+emotion + "입니다.");
        if(emotion == null) {
            EmotionEntity emotionEntity = EmotionEntity.builder()
                    .emotionCat("NEUTRAL")
                    .emotionDate(LocalDateTime.now())
                    .userCode(userCode)
                    .build();

            log.info(emotionEntity.toString());
            return emotionRepository.save(emotionEntity);

        }else {
            EmotionEntity emotionEntity = EmotionEntity.builder()
                    .emotionCat(emotion)
                    .emotionDate(LocalDateTime.now())
                    .userCode(userCode)
                    .build();
            log.info(emotionEntity.toString());
            return emotionRepository.patch(emotionEntity.getUserCode(), emotionEntity.getEmotionCat(), emotionEntity.getEmotionDate());

        }

    }

//    //음성인식 사용자 수 조회
//    public Long spVisitCount(){
//        return spLogRepository.countAllByLogNo();
//    }
//
//    //음성인식 이번달 사용자 수 조회
//    public Long spVisitCountMonth(){
//        return spLogRepository.countAllByLogNoBetweenAndLoginDate();
//    }
//
//    //음성인식 월평균 사용자 수 조회
//    public int spVisitCountAvg(){
//        return 0;
//    }
//
//    //일주일간 이용이 없는 사용자 리스트 조회
//    public Page<SpLogEntity> selectNotForWeek(){
//        return spLogRepository.findAllByOrOrderByLogNoDesc();
//    }
//
//
//
//    private final ChatLogRepository chatLogRepository;
//    private final ChatLogRepositoryCustom chatLogRepositoryCustom;
//
//    //리스트 출력
//    public Header<List<ChatLogDto>> getChatLogList(Pageable pageable, SearchCondition searchCondition) {
//        return null;
//    }
//
//    //등록
//    public ChatLogEntity create(ChatLogDto chatLogDto) {
//        ChatLogEntity entity = ChatLogEntity.builder()
//                .userCode1(chatLogDto.getUserCode1())
//                .userCode2(chatLogDto.getUserCode2())
//                .accessTime(chatLogDto.getAccessTime())
//                .entrance(chatLogDto.getEntrance())
//                .link(chatLogDto.getLink())
//                .build();
//        return chatLogRepository.save(entity);
//    }
//
//    //삭제 => 3개월 이후 삭제
//    public void delete(Long log_no) {
//        ChatLogEntity entity = chatLogRepository.findById(log_no).orElseThrow(()
//                -> new RuntimeException("해당 logNO을 찾을 수 없습니다."));
//        chatLogRepository.delete(entity);
//    }

    //회원목록 출력
    public Header<List<MemberDto>> memberList(Pageable oriPageable, SearchCondition searchCondition) {
        CustomPageable pageable = new CustomPageable(oriPageable);
        List<MemberDto> list = new ArrayList<>();
        Page<MemberEntity> memberEntities =
                adminRepositoryCustom.findAllBySearchCondition(
                        pageable, searchCondition);

        for (MemberEntity entity : memberEntities) {
            MemberDto dto = MemberDto.builder()
                    .userId(entity.getUserId())
                    .userCode(entity.getUserCode())
                    .enrollDate(String.valueOf(entity.getEnrollDate()))
                    .phone(entity.getPhone())
                    .email(entity.getEmail())
                    .userName(entity.getUserNamee())
                    .permit(entity.getPermit().substring(0,1))
                    .build();
            System.out.println("permit : "+entity.getPermit().substring(0,1));
            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) memberEntities.getTotalElements()
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() + 1
                , 10
        );

        return Header.OK(list, pagination);
    }

    public MemberDto permitMember(MemberDto memberDto) {

        MemberEntity memberEntity = memberRepository.findByUserCode(memberDto.getUserCode()).orElseGet(MemberEntity::new);
        memberEntity.setPermit(memberDto.getUserId());
        memberRepository.save(memberEntity);

        return memberDto;
    }
}
