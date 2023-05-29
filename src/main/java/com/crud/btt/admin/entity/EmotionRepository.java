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
//    List<EmotionEntity> countEmotionCat();

    //월 감정클릭 (angry)
    @Query(value = "select count(e) from EmotionEntity e where substr(e.emotionDate, 1, 6) = substr(current_timestamp, 1, 6) AND e.emotionCat = 'angry'")
    Long countByMonthAngry();

    //월 감정클릭 (anxious)
    @Query(value = "select count(e) from EmotionEntity e where substr(e.emotionDate, 1, 6) = substr(current_timestamp, 1, 6) AND e.emotionCat = 'anxious'")
    Long countByMonthAnxious();

    //월 감정클릭 (excited)
    @Query(value = "select count(e) from EmotionEntity e where substr(e.emotionDate, 1, 6) = substr(current_timestamp, 1, 6) AND e.emotionCat = 'excited'")
    Long countByMonthExcited();

    //월 감정클릭 (happy)
    @Query(value = "select count(e) from EmotionEntity e where substr(e.emotionDate, 1, 6) = substr(current_timestamp, 1, 6) AND e.emotionCat = 'happy'")
    Long countByMonthHappy();

    //월 감정클릭 (sad)
    @Query(value = "select count(e) from EmotionEntity e where substr(e.emotionDate, 1, 6) = substr(current_timestamp, 1, 6) AND e.emotionCat = 'sad'")
    Long countByMonthSad();

    //월 감정클릭 (scary)
    @Query(value = "select count(e) from EmotionEntity e where substr(e.emotionDate, 1, 6) = substr(current_timestamp, 1, 6) AND e.emotionCat = 'scary'")
    Long countByMonthScary();

    //월 감정클릭 (tired)
    @Query(value = "select count(e) from EmotionEntity e where substr(e.emotionDate, 1, 6) = substr(current_timestamp, 1, 6) AND e.emotionCat = 'tired'")
    Long countByMonthTired();

    //월 감정클릭 (lonely)
    @Query(value = "select count(e) from EmotionEntity e where substr(e.emotionDate, 1, 6) = substr(current_timestamp, 1, 6) AND e.emotionCat = 'lonely'")
    Long countByMonthLonely();

}
