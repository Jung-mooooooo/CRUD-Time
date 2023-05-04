package com.crud.btt.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "CHAT_LOG")
@Entity
public class ChatLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @SequenceGenerator(name = "chat_log_Sequence", sequenceName = "seq_chat_log", allocationSize = 1)
    @Column(name = "LOG_NO")
    private long log_no;        //로그순번
    @Column(name = "USER_CODE1")
    private long user_code1;    //유저코드1
    @Column(name = "USER_CODE2")
    private long user_code2;    //유저코드2
    @Column(name = "ACCESS_TIME")
    private Date access_time;   //접속시간
    @Column(name = "ENTRANCE")
    private String entrance;    //입장체크(Y/N)
    @Column(name = "LINK")
    private String link;        //채팅내용(file)

}
