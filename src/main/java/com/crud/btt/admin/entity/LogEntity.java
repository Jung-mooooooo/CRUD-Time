package com.crud.btt.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
            allocationSize=1 //메모리를 통해 할당할 범위 사이즈
    )
    @Column(name = "LOG_NO")
    private Long logNo;
    @Column(name = "USER_CODE")
    private Long userCode;
    @Column(name = "VISIT_IP")
    private String visitIp;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name = "VISIT_TIME")
    private LocalDateTime visitTime;

}
