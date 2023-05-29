package com.crud.btt.admin.entity;

import com.crud.btt.common.SearchCondition;
import com.crud.btt.member.entity.MemberEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.crud.btt.member.entity.QMemberEntity.memberEntity;

@RequiredArgsConstructor
@Repository
public class AdminRepositoryCustom {


    private final JPAQueryFactory queryFactory;

    public Page<MemberEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition){

        JPAQuery<MemberEntity> query = queryFactory.selectFrom(memberEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();


        // int customOffset = pageable.getPageNumber() == 0 ? 0 : (pageable.getPageNumber()-1) * pageable.getPageSize();
        // System.out.println("customOffset : "+customOffset);

        List<MemberEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(memberEntity.userCode.desc())
                .fetch();
        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv) {
        if ("userId".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return memberEntity.userId.contains(sv);
            }
        } else if ("userNamee".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return memberEntity.userNamee.contains(sv);
            }
        }
        return null;
    }
}


