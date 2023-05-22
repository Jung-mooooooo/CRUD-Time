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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_log_gen")
    @SequenceGenerator(
            name = "seq_log_gen",
            sequenceName = "SEQ_LOG",
            initialValue=1, //시작값
            allocationSize=1 //메모리를 통해 할당할 범위 사이즈
    )
    @Column(name = "LOG_NO")
    private Long logNo;
    @Column(name = "USER_CODE")
    private Long userCode;
    @Column(name = "VISIT_IP")
    private Long visitIp;
    @Column(name = "VISIT_TIME")
    private Long visitTime;

}
