package com.crud.btt.cs.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private int qna_ref;
}
