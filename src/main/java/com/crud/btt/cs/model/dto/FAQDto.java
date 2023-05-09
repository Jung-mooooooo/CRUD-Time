package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.FAQEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FAQDto {
    private long faq_no;
    private Date create_at;
    private String faq_title;
    private String faq_content;
    private int faq_readcount;
    private long admin_code;
    private String faq_cat;


    public FAQDto(FAQEntity faqEntity){
        this.faq_title = faqEntity.getFaqTitle();
        this.faq_content = faqEntity.getFaqContent();
        this.faq_readcount = faqEntity.getFaqReadCount();
        this.create_at = faqEntity.getCreateAt();
    }
}
