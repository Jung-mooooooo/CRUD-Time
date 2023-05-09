package com.crud.btt.cs.model.dto;

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
public class FAQUpdateDto {

    private long faq_no;
    private Date create_at;
    private String faq_title;
    private String faq_content;
    private int faq_readcount;
    private String faq_cat;


    public FAQUpdateDto(FAQEntity faqEntity){
        this.faq_no = faqEntity.getFaqNo();
        this.faq_title = faqEntity.getFaqTitle();
        this.faq_content = faqEntity.getFaqContent();
        this.create_at = faqEntity.getCreateAt();
        this.faq_readcount = faqEntity.getFaqReadCount();
    }

    public FAQUpdateDto(String fail_msg){
        this.faq_title = fail_msg;
    }
}
