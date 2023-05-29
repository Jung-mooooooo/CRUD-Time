
package com.crud.btt.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "V_QNA")
public class V_QnAEntity {
    @Id
    @Column(name="RN")
    private long rn;
    @Column(name="QNA_NO")
    private long qnaNo;
    @Column(name="CREATE_AT")
    private LocalDateTime createAt;
    @Column(name="QNA_TITLE")
    private String qnaTitle;

    @Column(name="USER_ID")
    private String userId;


}

