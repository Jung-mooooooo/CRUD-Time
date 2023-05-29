package com.crud.btt.admin.model.dto;

import com.crud.btt.admin.entity.AdminEntity;
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

    public AdminDto(AdminEntity entity){
        this.adminCode = entity.getAdminCode();
        this.adminId = entity.getAdminId();
        this.adminPwd = entity.getAdminPwd();
        this.adminName = entity.getAdminName();
        this.phone = entity.getPhone();
        this.email = entity.getEmail();
    }
}
