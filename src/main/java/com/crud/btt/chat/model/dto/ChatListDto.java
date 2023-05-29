package com.crud.btt.chat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatListDto {

    private Long userCode;      //유저코드
    private String userName;    //유저이름
    private String emotionCat;  //유저 감정
    private LocalDateTime ENTER;       //입장시간
}
