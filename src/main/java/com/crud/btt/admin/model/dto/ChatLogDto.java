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
    private Long logNo;        //로그순번
    private Long userCode1;    //유저코드1
    private Long userCode2;    //유저코드2
    private Date accessTime;   //접속시간
    private String entrance;    //입장체크(Y/N)
    private String link;        //채팅내용(file)
}
