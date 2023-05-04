package com.crud.btt.cs.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FAQDto {
    private long faq_no;
    private Date create_at;
    private String faq_title;
    private String faq_content;
    private int faq_readcount;
    private long admin_code;
    private String faq_cat;
}
