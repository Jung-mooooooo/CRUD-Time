package com.crud.btt.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatDto {  //채팅 메세지 주고받기 위한 dto
    //채팅방 입장, 메세지 전송에 필요한 enum구현
    //enum(enumerated type) : 열거형. 서로 연관된 상수들의 집합 => class

    public enum ChatType {
        //채팅방 입장, 메세지 전송
        ENTER, TALK
    }

    @JsonProperty("type")
    private ChatType type;     //메세지 타입
    @JsonProperty("roomId")
    private String roomId;        //방번호
    @JsonProperty("sender")
    private String sender;       //보내는이
    @JsonProperty("chat")
    private String chat;        //내용

}
