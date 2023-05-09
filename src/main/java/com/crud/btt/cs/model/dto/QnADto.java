package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.NoticeEntity;
import com.crud.btt.cs.entity.QnAEntity;
import lombok.*;

import java.util.Date;
@Data
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
        this.qna_title = qnaEntity.getQnaTitle();
        this.qna_content = qnaEntity.getQnaContent();
        this.qna_readcount = qnaEntity.getQnaReadCount();
        this.create_at = qnaEntity.getCreateAt();
        this.qna_original_file = qnaEntity.getQnaOriginalFile();
        this.qna_rename_file = qnaEntity.getQnaRename_File();
    }
}
