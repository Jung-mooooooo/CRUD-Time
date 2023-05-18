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
    private Long adminCode;
    private String adminId;
    private String adminPwd;
    private String adminName;
    private String phone;
    private String email;
    private Date enrollDate;
}
