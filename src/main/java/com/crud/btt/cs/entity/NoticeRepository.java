package com.crud.btt.cs.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
    Page<NoticeEntity> findAllByOrderByNoticeNoDesc(Pageable pageable);

    NoticeEntity findByNoticeNo(Long id);

    @Transactional
    long deleteByNoticeNo(Long noticeNo);


}
