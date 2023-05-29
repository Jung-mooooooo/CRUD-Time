
package com.crud.btt.cs.entity;

import com.crud.btt.cs.model.dto.QnADto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "QNA")
@Entity
public class QnAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_QNA")
    @SequenceGenerator(name = "SEQ_QNA", sequenceName = "SEQ_QNA", allocationSize = 1)
    @Column(name="QNA_NO")
    private Long qnaNo;
    @Column(name="CREATE_AT")
    private LocalDateTime createAt;
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

    public QnAEntity(QnADto qnADto, Long userCode, String mode, LocalDateTime createAt){
        this.qnaNo = qnADto.getQnaNo();
        this.qnaTitle = qnADto.getQnaTitle();
        this.qnaContent = qnADto.getQnaContent();
        this.userCode = userCode;
        this.createAt = createAt;
        this.qnaPrivate = qnADto.getQnaPrivate();
    }

    public QnAEntity(QnADto qnADto, Long adminCode, LocalDateTime createAt, String qnaPrivate){
        this.qnaRef = qnADto.getQnaRef();
        this.qnaTitle = qnADto.getQnaTitle();
        this.qnaContent = qnADto.getQnaContent();
        this.adminCode = adminCode;
        this.createAt = createAt;
        this.qnaPrivate = qnaPrivate;
    }
}

