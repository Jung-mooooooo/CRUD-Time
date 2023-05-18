package com.crud.btt.admin.model.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SpLogDto {

    private Long logNo;
    private int userCode;
    private Date loginDate;

}
