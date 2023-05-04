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
    private long emotion_no;
    @Column(name = "EMOTION_CAT")
    private long emotion_cat;
    @Column(name = "EMOTION_DATE")
    private long emotion_date;
    @Column(name = "USER_CODE")
    private long user_code;

}
