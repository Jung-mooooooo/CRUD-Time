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
    private long logNo;
    @Column(name = "USER_CODE")
    private long userCode;
    @Column(name = "VISIT_IP")
    private long visitIp;
    @Column(name = "VISIT_TIME")
    private long visitTime;

}
