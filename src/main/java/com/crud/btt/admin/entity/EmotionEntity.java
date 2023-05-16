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
    private long emotionNo;
    @Column(name = "EMOTION_CAT")
    private long emotionCat;
    @Column(name = "EMOTION_DATE")
    private long emotionDate;
    @Column(name = "USER_CODE")
    private long userCode;

}
