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

    private Long emotionNo;
    private String emotionCat;
    private Date emotionDate;
    private Long userCode;

}
