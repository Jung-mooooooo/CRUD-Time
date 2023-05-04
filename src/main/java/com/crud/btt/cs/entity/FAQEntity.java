package com.crud.btt.cs.entity;

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
@Table(name = "FAQ")
@Entity
public class FAQEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FAQ_NO")
    private long faq_no;
    @Column(name="CREATE_AT")
    private Date create_at;
    @Column(name="FAQ_TITLE")
    private String faq_title;
    @Column(name="FAQ_CONTENT")
    private String faq_content;
    @Column(name="ADMIN_CODE")
    private long admin_code;
    @Column(name="FAQ_READCOUNT")
    private int faq_readcount;
    @Column(name="FAQ_CAT")
    private String faq_cat;


}
