
package com.crud.btt.admin.entity;

import com.crud.btt.cs.model.dto.QnADto;
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
public class AdminQnAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_QNA")
    @SequenceGenerator(name = "SEQ_QNA", sequenceName = "SEQ_QNA", allocationSize = 1)
    @Column(name="QNA_NO")
    private Long qnaNo;
    @Column(name="CREATE_AT")
    private Date createAt;
    @Column(name="QNA_TITLE")
    private String qnaTitle;
    @Column(name="QNA_CONTENT")
    private String qnaContent;
    @Column(name="QNA_READCOUNT")
    private Integer qnaReadCount = 0 ;
    @Column(name="ADMIN_CODE")
    private Long adminCode;
    @Column(name="USER_CODE")
    private Long userCode;
    @Column(name="QNA_ORIGINAL_FILE")
    private String qnaOriginalFile;
    @Column(name="QNA_RENAME_FILE")
    private String qnaRenameFile;
    @Column(name="QNA_PRIVATE")
//    @ColumnDefault("Y")
    private String qnaPrivate;
    @Column(name="QNA_REF")
    private Long qnaRef;

    public AdminQnAEntity(QnADto qnADto, Long userCode, String mode, Date createAt){
        this.qnaTitle = qnADto.getQnaTitle();
        this.qnaContent = qnADto.getQnaContent();
        this.userCode = userCode;
        this.createAt = createAt;
        this.qnaPrivate = qnADto.getQnaPrivate();
    }

    public AdminQnAEntity(QnADto qnADto, Long adminCode, Date createAt, String qnaPrivate){
        this.qnaRef = qnADto.getQnaRef();
        this.qnaTitle = qnADto.getQnaTitle();
        this.qnaContent = qnADto.getQnaContent();
        this.adminCode = adminCode;
        this.createAt = createAt;
        this.qnaPrivate = qnaPrivate;
    }
}

