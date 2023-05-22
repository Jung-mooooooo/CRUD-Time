package com.crud.btt.admin.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionRepository extends JpaRepository<EmotionEntity, Long> {

    //@Query(value = "SELECT q FROM QnAEntity q WHERE q.qnaNo = q.qnaRef ORDER BY q.qnaNo DESC", nativeQuery = false)

    //@Query("select emotionCat, round((count(*) / (select count(*) from EmotionEntity) * 100), 2) || '%' as ratioPercentage" +
    //           "from EmotionEntity group by emotionCat")

//    @Query(value = "SELECT emotionCat, ROUND((COUNT(*) / (SELECT COUNT(*) FROM emotion) * 100), 2) || '%' AS ratioPercentage FROM emotion GROUP BY emotionCat", nativeQuery = true)
//    List<EmotionEntity> countEmotion();
}
