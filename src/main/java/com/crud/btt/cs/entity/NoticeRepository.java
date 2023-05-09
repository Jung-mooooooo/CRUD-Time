package com.crud.btt.cs.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
    Page<NoticeEntity> findAllByOrderByIdxDesc(Pageable pageable);

    NoticeEntity findByNoticeNo(Long noticeNo);

    // delete : 삭제 + By : 뒤에 조건이 온다는 약속 + 필드명 + And + 필드명2 ... -> 파라미터도 일치시켜야 함
    long deleteByNoticeNo(Long noticeNo);
    // = where notice_no = { notice_no }

    //Page<NoticeEntity> findByNoticeTitleOrNoticeContent(Pageable pageable, String keyword);

    //Page<NoticeEntity> findByCategoryAndNoticeTitleOrNoticeContent(Pageable pageable, String Categroy, String keyword);

}
