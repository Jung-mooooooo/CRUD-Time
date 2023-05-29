package com.crud.btt.admin.model.dto;

import com.crud.btt.cs.entity.QnAEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminQnAListDto {

    private long qnaNo;
    private LocalDateTime createAt;
    private String qnaTitle;
    private int qnaReadCount;
    // private long adminCode;
    private long userCode;
    private String userId;
    private String qnaPrivate;
    private long qnaRef;

    public AdminQnAListDto(QnAEntity qnaEntity, String userId){
        this.qnaNo = qnaEntity.getQnaNo();
        this.qnaTitle = qnaEntity.getQnaTitle();
        this.qnaReadCount = qnaEntity.getQnaReadCount();
        this.createAt = qnaEntity.getCreateAt();
        // this.adminCode = qnaEntity.getAdminCode();
        this.userCode = qnaEntity.getUserCode();
        this.userId = userId;
        this.qnaRef = qnaEntity.getQnaRef();
        this.qnaPrivate = qnaEntity.getQnaPrivate();

    }

}
