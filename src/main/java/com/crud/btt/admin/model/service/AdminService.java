package com.crud.btt.admin.model.service;

import com.crud.btt.admin.entity.ChatLogEntity;
import com.crud.btt.admin.entity.ChatLogRepository;
import com.crud.btt.admin.entity.ChatLogRepositoryCustom;
import com.crud.btt.admin.model.dto.ChatLogDto;
import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {


    private final ChatLogRepository chatLogRepository;
    private final ChatLogRepositoryCustom chatLogRepositoryCustom;

    //리스트 출력
    public Header<List<ChatLogDto>> getChatLogList(Pageable pageable, SearchCondition searchCondition) {
        return null;
    }

    //등록
    public ChatLogEntity create(ChatLogDto chatLogDto) {
        ChatLogEntity entity = ChatLogEntity.builder()
                .user_code1(chatLogDto.getUser_code1())
                .user_code2(chatLogDto.getUser_code2())
                .access_time(chatLogDto.getAccess_time())
                .entrance(chatLogDto.getEntrance())
                .link(chatLogDto.getLink())
                .build();
        return chatLogRepository.save(entity);
    }

    //삭제 => 3개월 이후 삭제
    public void delete(Long log_no) {
        ChatLogEntity entity = chatLogRepository.findById(log_no).orElseThrow(()
                -> new RuntimeException("해당 logNO을 찾을 수 없습니다."));
        chatLogRepository.delete(entity);
    }
}
