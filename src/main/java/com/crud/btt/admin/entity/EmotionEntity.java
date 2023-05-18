package com.crud.btt.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="EMOTION")
@Entity
public class EmotionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMOTION_NO")
    private Long emotionNo;
    @Column(name = "EMOTION_CAT")
    private Long emotionCat;
    @Column(name = "EMOTION_DATE")
    private Long emotionDate;
    @Column(name = "USER_CODE")
    private Long userCode;

}
