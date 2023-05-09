package com.crud.btt.admin.model.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatLogDto {
    private long logNo;        //로그순번
    private long userCode1;    //유저코드1
    private long userCode2;    //유저코드2
    private Date accessTime;   //접속시간
    private String entrance;    //입장체크(Y/N)
    private String link;        //채팅내용(file)
}
