package com.crud.btt.sp.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "SP_MEMBER")
@Entity
@Builder

public class SpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_CODE")
    private Long user_code;
    @Column(name = "DEVICE_ID")
    private String device_id;
    @Column(name = "USER_NAME")
    private String user_name;
    @Column(name = "USER_AUTH")
    private String user_auth;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ENROLL_DATE")
    private LocalDateTime enroll_date;

}
