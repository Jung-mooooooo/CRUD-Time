package com.crud.btt.chat.entity;

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
@Table(name = "CHAT_LIST")
@Entity
public class ChatListEntity {

    @Id
    @Column(name="USER_CODE")
    private Long userCode;      //유저코드
    @Column(name="USER_NAME")
    private String userName;    //유저이름
    @Column(name="ENTER")
    private LocalDateTime enter;       //입장시간
}
