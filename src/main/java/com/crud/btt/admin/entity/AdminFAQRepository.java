package com.crud.btt.admin.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AdminFAQRepository extends JpaRepository<AdminFAQEntity, Long> {
    AdminFAQEntity findByFaqNo(Long faqNo);
    @Transactional
    long deleteByFaqNo(Long faqNo);


}
