package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.QnAEntity;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QnAListDto {

    private long qna_no;
    private Date create_at;
    private String qna_title;
    private int qna_readcount;
    private long admin_code;
    private long user_code;
    private String qna_private;
    private long qna_ref;

    public QnAListDto(QnAEntity qnaEntity){
        this.qna_no = qnaEntity.getQna_no();
        this.create_at = qnaEntity.getCreate_at();
        this.qna_title = qnaEntity.getQna_title();
        this.qna_readcount = qnaEntity.getQna_readcount();
        this.admin_code = qnaEntity.getAdmin_code();
        this.user_code = qnaEntity.getUser_code();
        this.qna_private = qnaEntity.getQna_private();
        this.qna_ref = qnaEntity.getQna_ref();

    }
}
