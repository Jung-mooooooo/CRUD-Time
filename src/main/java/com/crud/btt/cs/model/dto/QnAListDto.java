package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.QnAEntity;
import lombok.*;

import java.util.Date;

@Data
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
        this.qna_no = qnaEntity.getQnaNo();
        this.create_at = qnaEntity.getCreateAt();
        this.qna_title = qnaEntity.getQnaTitle();
        this.qna_readcount = qnaEntity.getQnaReadCount();
        this.admin_code = qnaEntity.getAdminCode();
        this.user_code = qnaEntity.getUserCode();
        this.qna_private = qnaEntity.getQnaPrivate();
        this.qna_ref = qnaEntity.getQnaRef();

    }
}
