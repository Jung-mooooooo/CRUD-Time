package com.crud.btt.admin.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface EmotionRepository extends JpaRepository<EmotionEntity, Long> {

    //감정 업데이트
    @Modifying
    @Transactional
    @Query(value = "update Emotion set emotion_cat = :emotionCat, emotion_date = sysdate where user_code = :userCode and substr(emotion_date, 1, 10) = substr(sysdate, 1, 10)" , nativeQuery = true)
//    @Query(value = "update Emotion set emotion_cat = :emotionCat, emotion_date = :emotionDate where user_code = :userCode and to_char(emotion_date, 'yyyy-MM-dd') = to_char(:emotionDate, 'yyyy-MM-dd')" , nativeQuery = true)
    void patch(@Param("userCode") Long userCode, @Param("emotionCat") String emotionCat);

    //유저별 감정 확인
    @Query(value = "select * from Emotion where user_code = :userCode and substr(emotion_date, 1, 10) = substr(sysdate, 1, 10)", nativeQuery = true)
    EmotionEntity findByUserCode(Long userCode);

    //@Query(value = "SELECT q FROM QnAEntity q WHERE q.qnaNo = q.qnaRef ORDER BY q.qnaNo DESC", nativeQuery = false)

    //@Query("select emotionCat, round((count(*) / (select count(*) from EmotionEntity) * 100), 2) || '%' as ratioPercentage" +
    //           "from EmotionEntity group by emotionCat")

    @Query(value = "SELECT emotionCat, ROUND((COUNT(*) / (SELECT COUNT(*) FROM emotion) * 100), 2) || '%' AS ratioPercentage FROM emotion GROUP BY emotionCat", nativeQuery = true)
    List<EmotionEntity> countEmotionCat();



}
