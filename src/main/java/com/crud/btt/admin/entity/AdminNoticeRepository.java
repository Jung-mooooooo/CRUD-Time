package com.crud.btt.admin.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AdminNoticeRepository extends JpaRepository<AdminNoticeEntity, Long> {
    Page<AdminNoticeEntity> findAllByOrderByNoticeNoDesc(Pageable pageable);

    AdminNoticeEntity findByNoticeNo(Long id);

    @Transactional
    long deleteByNoticeNo(Long noticeNo);


}
