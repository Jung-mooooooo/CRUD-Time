
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qna_sequence")
    @SequenceGenerator(name = "qna_sequence", sequenceName = "qna_sequence", allocationSize = 1)
    @Column(name="QNA_NO")
    private long qnaNo;
    @Column(name="CREATE_AT")
    private Date createAt;
    @Column(name="QNA_TITLE")
    private String qnaTitle;
    @Column(name="QNA_CONTENT")
    private String qnaContent;
    @Column(name="QNA_READCOUNT")
    private int qnaReadCount;
    @Column(name="ADMIN_CODE")
    private long adminCode;
    @Column(name="USER_CODE")
    private long userCode;
    @Column(name="QNA_ORIGINAL_FILE")
    private String qnaOriginalFile;
    @Column(name="QNA_RENAME_FILE")
    private String qnaRenameFile;
    @Column(name="QNA_PRIVATE")
    private String qnaPrivate;
    @Column(name="QNA_REF")
    private long qnaRef;


}

