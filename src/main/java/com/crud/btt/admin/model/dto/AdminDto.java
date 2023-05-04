package com.crud.btt.admin.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDto {
    private long admin_code;
    private String admin_id;
    private String admin_pwd;
    private String admin_name;
    private String phone;
    private String email;
    private Date enroll_date;
}
