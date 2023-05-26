package com.crud.btt.admin.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmotionDto {

    private Long emotionNo;
    private String emotionCat;
    private LocalDateTime emotionDate;
    private Long userCode;

}
