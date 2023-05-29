package com.crud.btt.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="EMOTION")
@Entity
public class EmotionEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMOTION")
    @SequenceGenerator(name = "SEQ_EMOTION", sequenceName = "SEQ_EMOTION", allocationSize = 1)
    @Id
    @Column(name = "EMOTION_NO")
    private Long emotionNo;            //이모션 넘버링
    @Column(name = "USER_CODE")
    private Long userCode;              //유저코드
    @Column(name = "EMOTION_CAT")
    private String emotionCat;          //감정카테고리
    @Column(name = "EMOTION_DATE")
    private LocalDateTime emotionDate;  //날짜


}
