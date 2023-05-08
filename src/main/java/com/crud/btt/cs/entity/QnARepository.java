package com.crud.btt.cs.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QnARepository extends JpaRepository<QnAEntity, Long>{

    Page<QnAEntity> findAllByOrderByIdxDesc(Pageable pageable);

    QnAEntity findByQnANo(Long qnaNo);

    long deleteByQnANo(Long qnaNo);

    Page<QnAEntity> findByQnATitleOrQnAContent(Pageable pageable, String keyword);

    @Query(value = "SELECT * FROM QNA WHERE QNA.QNA_NO = QNA.REF_NO ORDER BY QNA.QNA_NO DESC", nativeQuery = true)
    List<QnAEntity> findSameBtwTwoColumn();

    QnAEntity findByRefNo(Long qna_no);
    /*
    find ->      select         select *
    by ->        where          where refNo = { qnaNo };
    fieldName -> 조건
    */
}
