package com.crud.btt.chat.model.dto;

import com.crud.btt.chat.entity.ChatListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ChatListRepository extends JpaRepository<ChatListEntity, Long> {


    //감정과 현재 채팅페이지에 존재하는 유저 목록 리스트 출력
//    @Query(value = "select m.user_code, m.user_name, e.emotion_cat from member m, emotion e where m.user_code = e.user_code and substr(e.emotion_date, 1, 10) = substr(sysdate, 1, 10)", nativeQuery = true)
    @Query(value = "SELECT m.user_code, m.user_name, e.emotion_cat FROM member m LEFT JOIN emotion e ON m.user_code = e.user_code WHERE SUBSTR(e.emotion_date, 1, 10) = SUBSTR(sysdate, 1, 10) GROUP BY m.user_code, m.user_name, e.emotion_cat", nativeQuery = true)
    List<Object[]> List();
}
