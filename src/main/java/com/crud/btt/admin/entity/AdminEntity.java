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
    private long admin_code;
    @Column(name="ADMIN_ID")
    private String admin_id;
    @Column(name="ADMIN_PWD")
    private String admin_pwd;
    @Column(name="ADMIN_NAME")
    private String admin_name;
    @Column(name="PHONE")
    private String phone;
    @Column(name="EMAIL")
    private String email;
    @Column(name="ENROLL_DATE")
    private Date enroll_date;
}
