package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.NoticeEntity;
import lombok.*;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeUpdateDto {

    private long notice_no;
    private Date create_at;
    private String notice_title;
    private String notice_content;
    private String notice_original_file;
    private String notice_rename_file;

    public NoticeUpdateDto(NoticeEntity noticeEntity){
        this.notice_no = noticeEntity.getNotice_no();
        this.notice_title = noticeEntity.getNotice_title();
        this.notice_content = noticeEntity.getNotice_content();
        this.create_at = noticeEntity.getCreate_at();
        this.notice_original_file = noticeEntity.getNotice_original_file();
        this.notice_rename_file = noticeEntity.getNotice_rename_file();
    }

    public NoticeUpdateDto(String fail_msg){
        this.notice_title = fail_msg;
    }
}
