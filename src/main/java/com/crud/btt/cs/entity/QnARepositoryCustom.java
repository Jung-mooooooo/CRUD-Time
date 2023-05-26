package com.crud.btt.cs.entity;

import com.crud.btt.common.SearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static com.crud.btt.cs.entity.QQnAEntity.qnAEntity;


@RequiredArgsConstructor
@Repository
public class QnARepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;

//    public List<QnAEntity> findTop5ByOrderByCreateAtDesc() {
//        Query query = entityManager.createNativeQuery("SELECT * FROM v_qna", QnAEntity.class);
//        return query.getResultList();
//    }

    public List<QnAEntity> findTop5ByOrderByCreateAtDesc() {
        String queryStr = "SELECT q FROM QnAEntity q ORDER BY q.createAt DESC";
        TypedQuery<QnAEntity> query = entityManager.createQuery(queryStr, QnAEntity.class);
        query.setMaxResults(5);
        return query.getResultList();
    }

//    public List<QnAEntity> findTop5ByOrderByCreateAtDesc() {
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<QnAEntity> query = builder.createQuery(QnAEntity.class);
//        Root<QnAEntity> root = query.from(QnAEntity.class);
//        query.orderBy(builder.desc(root.get("createAt")));
//        return entityManager.createQuery(query)
//                .setMaxResults(5)
//                .getResultList();
//    }

//    public List<QnAEntity> findTop5ByOrderByCreateAtDesc(){
//
//        JPAQuery<QnAEntity> query = new JPAQuery<>();
//        query.select(qnAEntity.qnaNo, qnAEntity.qnaTitle, memberEntity.userId, qnAEntity.createAt)
//                .from(qnAEntity)
//                .join(qnAEntity.member, memberEntity)
//                .on(qnAEntity.userCode.eq(memberEntity.userCode))
//                .orderBy(qnAEntity.createAt.desc())
//                .offset(0)
//                .limit(5);
//
//        return query.fetch();
//    };


    public Page<QnAEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition){

        JPAQuery<QnAEntity> query = queryFactory.selectFrom(qnAEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();

        List<QnAEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(qnAEntity.qnaNo.desc())
                .fetch();
        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv) {


        if("qnaTitle".equals(sk)){
            if(StringUtils.hasLength(sv)){
                return qnAEntity.qnaTitle.contains(sv);
            }
        } else if ("qnaContent".equals(sk)) {


            if(StringUtils.hasLength(sv)){
                return qnAEntity.qnaContent.contains(sv);
            }
        }
        return null;

    }
}