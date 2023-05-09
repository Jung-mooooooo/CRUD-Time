package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.NoticeEntity;
import lombok.*;

import java.util.Date;

@Data
@Getter
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
        this.notice_no = noticeEntity.getNoticeNo();
        this.notice_title = noticeEntity.getNoticeTitle();
        this.notice_content = noticeEntity.getNoticeContent();
        this.create_at = noticeEntity.getCreateAt();
        this.notice_original_file = noticeEntity.getNoticeOriginalFile();
        this.notice_rename_file = noticeEntity.getNoticeRenameFile();
    }

    public NoticeUpdateDto(String fail_msg){
        this.notice_title = fail_msg;
    }
}
