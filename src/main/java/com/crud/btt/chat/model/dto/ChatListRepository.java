package com.crud.btt.chat.model.dto;

import com.crud.btt.chat.entity.ChatListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ChatListRepository extends JpaRepository<ChatListEntity, Long> {

}
