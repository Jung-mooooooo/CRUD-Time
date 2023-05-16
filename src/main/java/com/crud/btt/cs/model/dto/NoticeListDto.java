package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.NoticeEntity;
import lombok.*;

import java.util.Date;
@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeListDto {

    private long noticeNo;
    private String noticeTitle;
    private long adminCode;
    private Date createAt;


    public NoticeListDto(NoticeEntity noticeEntity){
        this.noticeNo = noticeEntity.getNoticeNo();
        this.noticeTitle = noticeEntity.getNoticeTitle();
        this.adminCode = noticeEntity.getAdminCode();
        this.createAt = noticeEntity.getCreateAt();
    }
}
