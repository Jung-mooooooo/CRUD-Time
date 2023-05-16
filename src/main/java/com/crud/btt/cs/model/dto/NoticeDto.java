package com.crud.btt.cs.model.dto;

import lombok.*;

import java.util.Date;
@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDto {

    // 필드값 없으면 : object.notice_content = "" or null -> undefind
    // 그러므로 꼭 넣어야 하는건 아님

    private long noticeNo;
    private Date createAt;
    private String noticeTitle;
    private String noticeContent;
    private int noticeReadCount;
    private long adminCode;
    private String noticeOriginalFile;
    private String noticeRenameFile;

//    public NoticeDto(NoticeEntity noticeEntity){
//        this.noticeTitle = noticeEntity.noticeTitle();
//        this.noticeContent = noticeEntity.getNoticeContent();
//        this.noticeReadCount = noticeEntity.getNoticeReadCount();
//        this.createAt = noticeEntity.getCreateAt();
//        this.noticeOriginalFile = noticeEntity.getNoticeOriginalFile();
//        this.noticeRenameFile = noticeEntity.getNoticeRenameFile();
//    }

}
