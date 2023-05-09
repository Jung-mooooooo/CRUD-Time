package com.crud.btt.cs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "NOTICE")
@Entity
public class NoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="NOTICE_NO")
    private long noticeNo;
    @Column(name="CREATE_AT")
    private Date createAt;
    @Column(name="NOTICE_TITLE")
    private String noticeTitle;
    @Column(name="NOTICE_CONTENT")
    private String noticeContent;
    @Column(name="NOTICE_READCOUNT")
    private int noticeReadCount;
    @Column(name="ADMIN_CODE")
    private long adminCode;
    @Column(name="NOTICE_ORIGINAL_FILE")
    private String noticeOriginalFile;
    @Column(name="NOTICE_RENAME_FILE")
    private String noticeRenameFile;


}
