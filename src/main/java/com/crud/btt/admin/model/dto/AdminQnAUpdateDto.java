package com.crud.btt.admin.model.dto;

import com.crud.btt.cs.entity.QnAEntity;
import lombok.*;

import java.util.Date;


@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminQnAUpdateDto {

    private long qna_no;
    private Date create_at;
    private String qna_title;
    private String qna_content;
    private String qna_original_file;
    private String qna_rename_file;

    public AdminQnAUpdateDto(QnAEntity qnaEntity){
        this.qna_no = qnaEntity.getQnaNo();
        this.qna_title = qnaEntity.getQnaTitle();
        this.qna_content = qnaEntity.getQnaContent();
        this.create_at = qnaEntity.getCreateAt();
        this.qna_original_file = qnaEntity.getQnaOriginalFile();
        this.qna_rename_file = qnaEntity.getQnaRenameFile();
    }

    public AdminQnAUpdateDto(String fail_msg){
        this.qna_title = fail_msg;
    }
}
