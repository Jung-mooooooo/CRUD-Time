package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.QnAEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QnAListDto {

    private long qnaNo;
    private Date createAt;
    private String qnaTitle;
    private int qnaReadCount;
    private long adminCode;
    private long userCode;
    private String qnaPrivate;
    private long qnaRef;

    public QnAListDto(QnAEntity qnaEntity){
        this.qnaNo = qnaEntity.getQnaNo();
        this.qnaTitle = qnaEntity.getQnaTitle();
        this.qnaReadCount = qnaEntity.getQnaReadCount();
        this.createAt = qnaEntity.getCreateAt();
        this.adminCode = qnaEntity.getAdminCode();
        this.userCode = qnaEntity.getUserCode();
        this.qnaRef = qnaEntity.getQnaRef();
        this.qnaPrivate = qnaEntity.getQnaPrivate();

    }

}
