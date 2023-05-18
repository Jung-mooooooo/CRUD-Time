package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.QnAEntity;
import lombok.*;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QnADto {
    private long qnaNo;
    private Date createAt;
    private String qnaTitle;
    private String qnaContent;
    private int qnaReadCount;
    private long adminCode;
    private long userCode;
    private String qnaOriginalFile;
    private String qnaRenameFile;
    private String qnaPrivate;
    private long qnaRef;

    public QnADto(QnAEntity qnaEntity){
        this.qnaTitle = qnaEntity.getQnaTitle();
        this.qnaContent = qnaEntity.getQnaContent();
        this.qnaReadCount = qnaEntity.getQnaReadCount();
        this.createAt = qnaEntity.getCreateAt();
        this.qnaOriginalFile = qnaEntity.getQnaOriginalFile();
        this.qnaRenameFile = qnaEntity.getQnaRenameFile();
    }
}
