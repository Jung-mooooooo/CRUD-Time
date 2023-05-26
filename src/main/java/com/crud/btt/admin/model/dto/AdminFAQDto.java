package com.crud.btt.admin.model.dto;

import com.crud.btt.cs.entity.FAQEntity;
import lombok.*;

import java.util.Date;
@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminFAQDto {
    private long faqNo;
    private Date createAt;
    private String faqTitle;
    private String faqContent;
    private long adminCode;
    private int faqReadCount;
    private String faqCat;


    public AdminFAQDto(FAQEntity faqEntity){
        this.faqTitle = faqEntity.getFaqTitle();
        this.faqContent = faqEntity.getFaqContent();
        this.faqReadCount = faqEntity.getFaqReadCount();
        this.createAt = faqEntity.getCreateAt();
    }
}
