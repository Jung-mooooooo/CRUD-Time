package com.crud.btt.cs.model.dto;

import com.crud.btt.cs.entity.FAQEntity;
import com.crud.btt.cs.entity.NoticeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;


@Getter
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
        this.faq_no = faqEntity.getFaq_no();
        this.faq_title = faqEntity.getFaq_title();
        this.faq_content = faqEntity.getFaq_content();
        this.create_at = faqEntity.getCreate_at();
        this.faq_readcount = faqEntity.getFaq_readcount();
    }

    public FAQUpdateDto(String fail_msg){
        this.faq_title = fail_msg;
    }
}
