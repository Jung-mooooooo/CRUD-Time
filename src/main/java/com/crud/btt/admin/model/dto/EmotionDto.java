package com.crud.btt.admin.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmotionDto {

    private long emotion_no;
    private String emotion_cat;
    private Date emotion_date;
    private long user_code;

}
