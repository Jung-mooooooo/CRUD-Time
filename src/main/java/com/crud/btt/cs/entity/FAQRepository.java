package com.crud.btt.cs.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface FAQRepository extends JpaRepository<FAQEntity, Long> {
    FAQEntity findByFaqNo(Long faqNo);
    @Transactional
    long deleteByFaqNo(Long faqNo);


}
