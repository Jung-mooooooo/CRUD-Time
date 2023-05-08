package com.crud.btt.admin.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "SP_LOG")
@Entity
@Builder

public class SpLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_NO")
    private Long log_no;
    @Column(name = "USER_CODE")
    private Long user_code;
    @Column(name = "LOGIN_DATE")
    private LocalDateTime login_date;

}