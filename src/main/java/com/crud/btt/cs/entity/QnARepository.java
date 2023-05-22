package com.crud.btt.cs.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QnARepository extends JpaRepository<QnAEntity, Long>{

    /*
        @Query : JPQL
        method : 쿼리메소드
    */
    /*
    기본 제공 쿼리메서드는 리포지토리에 없어도 쓸 수 있음.
    또한 이렇게 커스텀도 가능함.
    @Query(value = "value = INSERT INTO QNA (qna_no, create_at, qna_title, qna_content, qna_readcount, admin_code, user_code, qna_original_file, qna_rename_file, qna_private, qna_ref)" +
                            "VALUES (qna_sequence_name.nextval, current_timestamp, :qna_title, :qna_content, :qna_readcount, :admin_code, :user_code, :qna_original_file, :qna_rename_file, :qna_private, qna_sequence_name.currval)"
                             ,nativeQuery = true)
    QnAEntity save(QnAEntity qnAEntity);
    */

//    @Query(value = "value = INSERT INTO QnA q (q.qna_no, q.create_at, q.qna_title, q.qna_content, q.qna_readcount, q.admin_code, q.user_code, q.qna_original_file, q.qna_rename_file, q.qna_private, q.qna_ref)" +
//            "VALUES (qna_sequence_name.nextval, current_timestamp, :#{#qnAEntity.qna_title}:, :#{#qnAEntity.qna_content}, :#{#qnAEntity.qna_readcount}, :#{#qnAEntity.admin_code}, :#{#qnAEntity.user_code}, :#{#qnAEntity.qna_original_file}, :#{#qnAEntity.qna_rename_file}, :#{#qnAEntity.qna_private}, qna_sequence_name.currval)"
//            ,nativeQuery = true)
//    QnAEntity saveQuestion(@Param(value = "qnAEntity")QnAEntity qnAEntity);

    Page<QnAEntity> findAllByOrderByQnaNoDesc(Pageable pageable);

    //QnAEntity findByQnaNo(Long qnaNo);

    long deleteByQnaNo(Long qnaNo);

    @Query(value = "SELECT q FROM QnAEntity q WHERE q.qnaNo = q.qnaRef ORDER BY q.qnaNo DESC", nativeQuery = false)
    List<QnAEntity> findSameBtwTwoColumn();

    @Query(value = "SELECT q FROM QnAEntity q WHERE q.qnaNo = :qnaNo", nativeQuery = false)
    QnAEntity findByQnaNo(@Param("qnaNo") Long qnaNo);

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
