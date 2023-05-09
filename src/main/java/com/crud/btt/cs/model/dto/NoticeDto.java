package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.NoticeEntity;
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

    private long notice_no;
    private Date create_at;
    private String notice_title;
    private String notice_content;
    private int notice_readcount;
    private long admin_code;
    private String notice_original_file;
    private String notice_rename_file;

    public NoticeDto(NoticeEntity noticeEntity){
        this.notice_title = noticeEntity.getNoticeTitle();
        this.notice_content = noticeEntity.getNoticeContent();
        this.notice_readcount = noticeEntity.getNoticeReadCount();
        this.create_at = noticeEntity.getCreateAt();
        this.notice_original_file = noticeEntity.getNoticeOriginalFile();
        this.notice_rename_file = noticeEntity.getNoticeRenameFile();
    }

}
