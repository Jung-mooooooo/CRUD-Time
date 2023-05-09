package com.crud.btt.cs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    private long notice_no;
    @Column(name="CREATE_AT")
    private Date create_at;
    @Column(name="NOTICE_TITLE")
    private String notice_title;
    @Column(name="NOTICE_CONTENT")
    private String notice_content;
    @Column(name="NOTICE_READCOUNT")
    private int notice_readcount;
    @Column(name="ADMIN_CODE")
    private long admin_code;
    @Column(name="NOTICE_ORIGINAL_FILE")
    private String notice_original_file;
    @Column(name="NOTICE_RENAME_FILE")
    private String notice_rename_file;


    public NoticeEntity setNotice_no(Long notice_no){
        this.notice_no = notice_no;
        return this;
    }

}
