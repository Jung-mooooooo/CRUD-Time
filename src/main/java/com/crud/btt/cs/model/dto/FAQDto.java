package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.FAQEntity;
import lombok.*;

import java.util.Date;
@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FAQDto {
    private long faqNo;
    private Date createAt;
    private String faqTitle;
    private String faqContent;
    private long adminCode;
    private int faqReadCount;
    private String faqCat;


    public FAQDto(FAQEntity faqEntity){
        this.faqTitle = faqEntity.getFaqTitle();
        this.faqContent = faqEntity.getFaqContent();
        this.faqReadCount = faqEntity.getFaqReadCount();
        this.createAt = faqEntity.getCreateAt();
    }
}
