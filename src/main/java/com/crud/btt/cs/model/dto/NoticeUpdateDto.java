package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.NoticeEntity;
import lombok.*;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeUpdateDto {

    private long noticeNo;
    private Date createAt;
    private String noticeTitle;
    private String noticeContent;
    private String noticeOriginalFile;
    private String noticeRenameFile;

    public NoticeUpdateDto(NoticeEntity noticeEntity){
        this.noticeNo = noticeEntity.getNoticeNo();
        this.noticeTitle = noticeEntity.getNoticeTitle();
        this.noticeContent = noticeEntity.getNoticeContent();
        this.createAt = noticeEntity.getCreateAt();
        this.noticeOriginalFile = noticeEntity.getNoticeOriginalFile();
        this.noticeRenameFile = noticeEntity.getNoticeRenameFile();
    }

    public NoticeUpdateDto(String fail_msg){
        this.noticeTitle = fail_msg;
    }
}
