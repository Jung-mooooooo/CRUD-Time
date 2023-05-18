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


//    @SequenceGenerator(name = "chat_log_Sequence", sequenceName = "seq_chat_log", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_NO")
    private Long logNo;        //로그순번
    @Column(name = "USER_CODE1")
    private Long userCode1;    //유저코드1
    @Column(name = "USER_CODE2")
    private Long userCode2;    //유저코드2
    @Column(name = "ACCESS_TIME")
    private Date accessTime;   //접속시간
    @Column(name = "ENTRANCE")
    private String entrance;    //입장체크(Y/N)
    @Column(name = "LINK")
    private String link;        //채팅내용(file)

}
