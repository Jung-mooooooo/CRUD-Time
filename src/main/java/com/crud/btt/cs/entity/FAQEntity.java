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
    private long faqNo;
    @Column(name="CREATE_AT")
    private Date createAt;
    @Column(name="FAQ_TITLE")
    private String faqTitle;
    @Column(name="FAQ_CONTENT")
    private String faqContent;
    @Column(name="ADMIN_CODE")
    private long adminCode;
    @Column(name="FAQ_READCOUNT")
    private int faqReadCount;
    @Column(name="FAQ_CAT")
    private String faqCat;


}
