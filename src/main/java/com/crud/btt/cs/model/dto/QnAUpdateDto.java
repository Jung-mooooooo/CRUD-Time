package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.NoticeEntity;
import com.crud.btt.cs.entity.QnAEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;


@Getter
@Builder
public class QnAUpdateDto {

    private long qna_no;
    private Date create_at;
    private String qna_title;
    private String qna_content;
    private String qna_original_file;
    private String qna_rename_file;

    public QnAUpdateDto(QnAEntity qnaEntity){
        this.qna_no = qnaEntity.getQna_no();
        this.qna_title = qnaEntity.getQna_title();
        this.qna_content = qnaEntity.getQna_content();
        this.create_at = qnaEntity.getCreate_at();
        this.qna_original_file = qnaEntity.getQna_original_file();
        this.qna_rename_file = qnaEntity.getQna_rename_file();
    }

    public QnAUpdateDto(String fail_msg){
        this.qna_title = fail_msg;
    }
}
