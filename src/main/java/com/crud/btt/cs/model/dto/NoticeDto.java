package com.crud.btt.cs.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeDto {
    private long notice_no;
    private Date create_at;
    private String notice_title;
    private String notice_content;
    private int notice_readcount;
    private long admin_code;
    private String notice_original_file;
    private String notice_rename_file;
}
