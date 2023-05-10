package com.crud.btt.admin.model.service;

import com.crud.btt.admin.entity.*;
import com.crud.btt.admin.model.dto.ChatLogDto;
import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {

//    private final EmotionRepository emotionRepository;
//    private final LogRepository logRepository;
//    private final SpLogRepository spLogRepository;

//    private final ChatLogRepository chatLogRepository;
//    private final ChatLogRepositoryCustom chatLogRepositoryCustom;
//
//    public ChatLogEntity create(ChatLogDto chatLogDto) {
//        ChatLogEntity entity = ChatLogEntity.builder()
//                .user_code1(chatLogDto.getUser_code1())
//                .user_code2(chatLogDto.getUser_code2())
//                .access_time(chatLogDto.getAccess_time())
//                .entrance(chatLogDto.getEntrance())
//                .link(chatLogDto.getLink())
//                .build();
//        return chatLogRepository.save(entity);
//    }


//
//    //감정현황 조회
//    public Long emotionCount(){
//        return emotionRepository.countAllByEmotionNo();
//    }
//
//
//    //접속자 수 조회
//    public Long visitCount() {
//        return logRepository.countAllByLogNo();
//    }
//
//    //월 접속자 수 조회
//    public Long visitCountMonth() {
//        return logRepository.countAllByLogNoBetweenAndVisitTime();
//    }
//
//    //월 평균 접속자 수 조회
//    public int visitCountAvg() {
//        return 0;
//    }
//
//    //접속자 로그테이블에 저장하기
////    public int insertLog(LogEntity logEntity) {
////        return logRepository.findLog(logEntity);
////    }
//
//
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
}
