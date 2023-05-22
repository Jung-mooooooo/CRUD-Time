package com.crud.btt.member.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Getter
@Setter
@ToString
@Entity
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name="MEMBER_AUTH")
public class MemberAuth {

    @Id
    @SequenceGenerator(name = "SEQ_MEMBER_AUTH",
            sequenceName = "SEQ_MEMBER_AUTH",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEMBER_AUTH")
    private Long userAuthNo;

    @Column(name = "USER_CODE")
    private Long userCode;

    @Column(length = 50)
    private String auth;

//    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
//    @CreationTimestamp
//    private LocalDateTime regDate;
//
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
//    @UpdateTimestamp
//    private LocalDateTime updDate;

}