package com.crud.btt.admin.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class V_QnADto {
    private Long qnaNo;
    private String createAt;
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

}