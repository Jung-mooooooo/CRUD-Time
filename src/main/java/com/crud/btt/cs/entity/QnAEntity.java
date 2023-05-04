package com.crud.btt.cs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "QNA")
@Entity
public class QnAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="QNA_NO")
    private long qna_no;
    @Column(name="CREATE_AT")
    private Date create_at;
    @Column(name="QNA_TITLE")
    private String qna_title;
    @Column(name="QNA_CONTENT")
    private String qna_content;
    @Column(name="QNA_READCOUNT")
    private int qna_readcount;
    @Column(name="ADMIN_CODE")
    private long admin_code;
    @Column(name="USER_CODE")
    private long user_code;
    @Column(name="QNA_ORIGINAL_FILE")
    private String qna_original_file;
    @Column(name="QNA_RENAME_FILE")
    private String qna_rename_file;
    @Column(name="QNA_PRIVATE")
    private String qna_private;
    @Column(name="QNA_REF")
    private int qna_ref;
}
