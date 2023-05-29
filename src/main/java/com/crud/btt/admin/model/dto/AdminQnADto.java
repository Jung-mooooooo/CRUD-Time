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
public class AdminQnADto {
    private Long qnaNo;
    private LocalDateTime createAt;
    private String userId;
    private String qnaTitle;
    private String qnaContent;
    private Integer qnaReadCount;
    private Long adminCode;
    private Long userCode;
    private String qnaOriginalFile;
    private String qnaRenameFile;
    private String qnaPrivate;
    private Long qnaRef;

    public AdminQnADto(QnAEntity qnaEntity, String userId){
        this.qnaNo = qnaEntity.getQnaNo();
        this.qnaRef = qnaEntity.getQnaRef();
        this.userId = userId;
        this.qnaTitle = qnaEntity.getQnaTitle();
        this.qnaContent = qnaEntity.getQnaContent();
        this.qnaReadCount = qnaEntity.getQnaReadCount();
        this.createAt = qnaEntity.getCreateAt();
        this.qnaOriginalFile = qnaEntity.getQnaOriginalFile();
        this.qnaRenameFile = qnaEntity.getQnaRenameFile();
    }
}
