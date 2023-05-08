package com.crud.btt.sp.model.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SpDto {

    private long user_code;
    private String device_id;
    private String user_name;
    private String user_auth;
    private String phone;
    private Date enroll_date;

}
