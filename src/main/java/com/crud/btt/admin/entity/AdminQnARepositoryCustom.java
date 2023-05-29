package com.crud.btt.admin.entity;

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

import static com.crud.btt.admin.entity.QAdminQnAEntity.adminQnAEntity;


@RequiredArgsConstructor
@Repository
public class AdminQnARepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;

    public List<V_QnAEntity> findTop5ByOrderByCreateAtDesc() {
        String queryStr = "SELECT q FROM V_QnAEntity q ORDER BY q.createAt DESC";
        TypedQuery<V_QnAEntity> query = entityManager.createQuery(queryStr, V_QnAEntity.class);
        query.setMaxResults(5);
        return query.getResultList();
    }

    public Page<AdminQnAEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition){

        JPAQuery<AdminQnAEntity> query = queryFactory.selectFrom(adminQnAEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();

        List<AdminQnAEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(adminQnAEntity.qnaNo.desc())
                .fetch();
        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv) {


        if("qnaTitle".equals(sk)){
            if(StringUtils.hasLength(sv)){
                return adminQnAEntity.qnaTitle.contains(sv);
            }
        } else if ("qnaContent".equals(sk)) {


            if(StringUtils.hasLength(sv)){
                return adminQnAEntity.qnaContent.contains(sv);
            }
        }
        return null;

    }

}