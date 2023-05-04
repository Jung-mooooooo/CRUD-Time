package com.crud.btt.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="LOG")
@Entity
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_NO")
    private long log_no;
    @Column(name = "USER_CODE")
    private long user_code;
    @Column(name = "VISIT_IP")
    private long visit_ip;
    @Column(name = "VISIT_TIME")
    private long visit_time;

}
