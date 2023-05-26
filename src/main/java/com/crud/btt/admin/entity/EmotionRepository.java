package com.crud.btt.admin.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface EmotionRepository extends JpaRepository<EmotionEntity, Long> {

    //감정 업데이트
    @Query(value = "update Emotion set emotion_cat = :emotionCat, emotion_date = :emotionDate where user_code = :userCode" , nativeQuery = true)
    EmotionEntity patch(@Param("userCode") Long userCode, @Param("emotionCat") String emotionCat, @Param("emotionDate")LocalDateTime emotionDate);



    //@Query(value = "SELECT q FROM QnAEntity q WHERE q.qnaNo = q.qnaRef ORDER BY q.qnaNo DESC", nativeQuery = false)

    //@Query("select emotionCat, round((count(*) / (select count(*) from EmotionEntity) * 100), 2) || '%' as ratioPercentage" +
    //           "from EmotionEntity group by emotionCat")

//    @Query(value = "SELECT emotionCat, ROUND((COUNT(*) / (SELECT COUNT(*) FROM emotion) * 100), 2) || '%' AS ratioPercentage FROM emotion GROUP BY emotionCat", nativeQuery = true)
//    List<EmotionEntity> countEmotion();
}
