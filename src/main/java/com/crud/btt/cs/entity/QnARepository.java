package com.crud.btt.cs.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QnARepository extends JpaRepository<QnAEntity, Long>{

    /*
        @Query : JPQL
        method : 쿼리메소드
    */

//    @Query(value = "value = INSERT INTO QnA q (q.qna_no, q.create_at, q.qna_title, q.qna_content, q.qna_readcount, q.admin_code, q.user_code, q.qna_original_file, q.qna_rename_file, q.qna_private, q.qna_ref)" +
//            "VALUES (qna_sequence_name.nextval, current_timestamp, :#{#qnAEntity.qna_title}:, :#{#qnAEntity.qna_content}, :#{#qnAEntity.qna_readcount}, :#{#qnAEntity.admin_code}, :#{#qnAEntity.user_code}, :#{#qnAEntity.qna_original_file}, :#{#qnAEntity.qna_rename_file}, :#{#qnAEntity.qna_private}, qna_sequence_name.currval)"
//            ,nativeQuery = true)
//    QnAEntity saveQuestion(@Param(value = "qnAEntity")QnAEntity qnAEntity);

//    @Query(value = "SELECT q.qnaNo, q.qnaTitle, m.userId, q.createAt FROM QnAEntity q join MemberEntity m on q.userCode = m.userCode ORDER BY q.createAt DESC", nativeQuery = false)
//    @Query(value = "SELECT ROWNUM, qa.qnaNo, qa.qnaTitle, qa.userId, qa.createAt " +
//        "FROM (SELECT q.qnaNo, q.qnaTitle, m.userId, q.createAt " +
//        "FROM QnAEntity q " +
//        "JOIN MemberEntity m ON q.userCode = m.userCode " +
//        "ORDER BY q.createAt DESC) qa " +
//        "WHERE ROWNUM <= 5",
//        nativeQuery = true)
//    List<QnAEntity> findTop5ByOrderByCreateAtDesc();

    Page<QnAEntity> findAllByOrderByQnaNoDesc(Pageable pageable);


    QnAEntity findByQnaNo(Long qnaNo);

    @Transactional
    long deleteByQnaNo(Long qnaNo);

    @Query(value = "SELECT q FROM QnAEntity q WHERE q.qnaNo = q.qnaRef ORDER BY q.qnaNo DESC", nativeQuery = false)
    List<QnAEntity> findSameBtwTwoColumn();

    @Query("SELECT a " +
            "FROM QnAEntity a WHERE a.qnaRef = :qnaNo AND a.qnaNo <> a.qnaRef")
    QnAEntity findByQnaRef(@Param("qnaNo") Long qnaNo);

//    @Query("SELECT a " +
//            "FROM QnAEntity a INNER JOIN QnAEntity b ON a.qnaRef = b.qnaNo " +
//            "WHERE b.qnaNo = :qnaNo AND a.qnaNo <> b.qnaRef")
//    QnAEntity findByQnaRef(@Param("qnaNo") Long qnaNo);


    /*
    find ->      select         select *
    by ->        where          where
    fieldName -> 조건컬럼         refNo  =
    ()        -> 검색값           { qna_no_to_ref }
    and       -> and            and
    qnaNo     -> 조건컬럼         qnaNo
    Not       -> <>              <>
    ()        -> 검색값           { qna_no_to_no }
    */
    /*
        SELECT * FROM QNA A WHERE A.REF_NO = A.QNA_NO;
        1 질문입니다 1
        SELECT * FROM QNA A WHERE A.REF_NO = { QNA_NO };
        QNA_NO를 2로 넣음.
        2 질문입니다. 2
        3 답변입니다. 2
        1. 글번호와 참조번호가 다르면 답변글이니까, 이 둘이 다른 대상을 찾아도됨.
        2. 글번호가 입력한 글번호와 다른 대상도 해당됨.
    */
}
