package com.crud.btt.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CHAT_LIST")
@Entity
public class ChatListEntity {

    @Id
    @SequenceGenerator(name = "SEQ_CHAT_LIST",
            sequenceName = "SEQ_CHAT_LIST",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CHAT_LIST")
    @Column(name="LIST_NO")
    private Long listNo;        //채팅유저리스트순번
    @Column(name="USER_CODE")
    private Long userCode;      //유저코드
    @Column(name="USER_NAME")
    private String userName;    //유저이름
}
