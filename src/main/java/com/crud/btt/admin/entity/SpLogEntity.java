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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_splog_gen")
    @SequenceGenerator(
            name = "seq_splog_gen",
            sequenceName = "SEQ_SP_LOG",
            initialValue=1, //시작값
            allocationSize=1 //메모리를 통해 할당할 범위 사이즈
    )
    @Column(name = "LOG_NO")
    private Long logNo;
    @Column(name = "USER_CODE")
    private Long userCode;
    @Column(name = "LOGIN_DATE")
    private LocalDateTime loginDate;

}
