package com.crud.btt.sp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    private Long userCode;
    @Column(name = "DEVICE_ID")
    private String deviceId;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_AUTH")
    private String userAuth;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ENROLL_DATE")
    private Date enrollDate;

}
