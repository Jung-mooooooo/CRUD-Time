package com.crud.btt.member.entity;

import com.crud.btt.member.model.dto.MemberDto;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
