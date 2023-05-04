package com.crud.btt.sp.model.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SpLogDto {

    private long log_no;
    private int user_code;
    private Date login_date;

}
