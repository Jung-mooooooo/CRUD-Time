package com.crud.btt.admin.entity;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ChatLogRepository extends JpaRepository<ChatLogEntity, Long> {
    
}
