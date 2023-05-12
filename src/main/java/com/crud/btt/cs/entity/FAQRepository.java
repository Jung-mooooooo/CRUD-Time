package com.crud.btt.cs.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FAQRepository extends JpaRepository<FAQEntity, Long> {
    FAQEntity findByFaqNo(Long faq_no);

    long deleteByFaqNo(Long faq_no);
   //Page<FAQEntity> findByFAQTitleOrFAQContent(Pageable pageable, String keyword);

}
