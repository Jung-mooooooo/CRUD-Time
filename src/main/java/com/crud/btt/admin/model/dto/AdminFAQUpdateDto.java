package com.crud.btt.admin.model.dto;

import com.crud.btt.cs.entity.FAQEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminFAQUpdateDto {

    private long faqNo;
    private Date createAt;
    private String faqTitle;
    private String faqContent;
    private String faqCat;
    private long adminCode;

    public AdminFAQUpdateDto(FAQEntity faqEntity){
        this.faqNo = faqEntity.getFaqNo();
        this.createAt = faqEntity.getCreateAt();
        this.faqTitle = faqEntity.getFaqTitle();
        this.faqContent = faqEntity.getFaqContent();
        this.faqCat = faqEntity.getFaqCat();
        this.adminCode = faqEntity.getAdminCode();
    }

    public AdminFAQUpdateDto(String fail_msg){
        this.faqTitle = fail_msg;
    }
}
