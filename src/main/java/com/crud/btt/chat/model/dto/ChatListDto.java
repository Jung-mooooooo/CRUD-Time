package com.crud.btt.chat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatListDto {

    private Long listNo;        //채팅유저리스트순번
    private Long userCode;      //유저코드
    private String userName;    //유저이름
}
