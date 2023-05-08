package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.NoticeEntity;
import com.crud.btt.cs.entity.QnAEntity;
import lombok.*;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QnADto {
    private long qna_no;
    private Date create_at;
    private String qna_title;
    private String qna_content;
    private int qna_readcount;
    private long admin_code;
    private long user_code;
    private String qna_original_file;
    private String qna_rename_file;
    private String qna_private;
    private long qna_ref;

    public QnADto(QnAEntity qnaEntity){
        this.qna_title = qnaEntity.getQna_title();
        this.qna_content = qnaEntity.getQna_content();
        this.qna_readcount = qnaEntity.getQna_readcount();
        this.create_at = qnaEntity.getCreate_at();
        this.qna_original_file = qnaEntity.getQna_original_file();
        this.qna_rename_file = qnaEntity.getQna_rename_file();
    }
}
