package com.crud.btt.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ADMIN")
@Entity
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ADMIN_CODE")
    private long adminCode;
    @Column(name="ADMIN_ID")
    private String adminId;
    @Column(name="ADMIN_PWD")
    private String adminPwd;
    @Column(name="ADMIN_NAME")
    private String adminName;
    @Column(name="PHONE")
    private String phone;
    @Column(name="EMAIL")
    private String email;
    @Column(name="ENROLL_DATE")
    private Date enrollDate;
}
