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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_emotion_gen")
    @SequenceGenerator(
            name = "seq_emotion_gen",
            sequenceName = "SEQ_EMOTION",
            initialValue=1, //시작값
            allocationSize=1 //메모리를 통해 할당할 범위 사이즈
    )
    @Column(name = "EMOTION_NO")
    private Long emotionNo;
    @Column(name = "USER_CODE")
    private Long userCode;
    @Column(name = "EMOTION_CAT")
    private String emotionCat;
    @Column(name = "EMOTION_DATE")
    private LocalDateTime emotionDate;


}
