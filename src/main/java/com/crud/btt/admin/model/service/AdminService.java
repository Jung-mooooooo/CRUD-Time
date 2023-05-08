package com.crud.btt.admin.model.service;

import com.crud.btt.admin.entity.EmotionRepository;
import com.crud.btt.admin.entity.LogEntity;
import com.crud.btt.admin.entity.LogRepository;
import com.crud.btt.admin.entity.SpLogRepository;
import com.crud.btt.sp.entity.SpEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {

    private final EmotionRepository emotionRepository;
    private final LogRepository logRepository;
    private final SpLogRepository spLogRepository;

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



    //감정현황 조회
    public int emotionCount(){
        return emotionRepository.selectEmotion();
    }


    //접속자 수 조회
    public int visitCount() {
        return logRepository.selectLogCount();
    }

    //월 접속자 수 조회
    public int visitCountMonth() {
        return logRepository.selectMonthCount();
    }

    //월 평균 접속자 수 조회
    public int visitCountAvg() {
        return logRepository.selectAvgCount();
    }

    //접속자 로그테이블에 저장하기
    public int insertLog(LogEntity logEntity) {
        return logRepository.insertLog(logEntity);
    }


    //음성인식 사용자 수 조회
    public int spVisitCount(){
        return spLogRepository.selectSpLogCount();
    }

    //음성인식 이번달 사용자 수 조회
    public int spVisitCountMonth(){
        return spLogRepository.selectSpMonthCount();
    }

    //음성인식 월평균 사용자 수 조회
    public int spVisitCountAvg(){
        return spLogRepository.selectSpAvgCount();
    }

    //일주일간 이용이 없는 사용자 리스트 조회
    public ArrayList<SpEntity> selectNotForWeek(){
        return spLogRepository.selectNotForWeek();
    }

}
