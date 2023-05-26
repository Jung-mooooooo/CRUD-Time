package com.crud.btt.admin.model.dto;

import com.crud.btt.cs.entity.NoticeEntity;
import lombok.*;

import java.util.Date;


@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminNoticeDto {

    private long noticeNo;
    private Date createAt;
    private String noticeTitle;
    private String noticeContent;
    private int noticeReadCount;
    private long adminCode;
    private String noticeOriginalFile;
    private String noticeRenameFile;

    public AdminNoticeDto(NoticeEntity noticeEntity){
        this.noticeTitle = noticeEntity.getNoticeTitle();
        this.noticeContent = noticeEntity.getNoticeContent();
        this.noticeReadCount = noticeEntity.getNoticeReadCount();
        this.createAt = noticeEntity.getCreateAt();
        this.noticeOriginalFile = noticeEntity.getNoticeOriginalFile();
        this.noticeRenameFile = noticeEntity.getNoticeRenameFile();
    }

}
