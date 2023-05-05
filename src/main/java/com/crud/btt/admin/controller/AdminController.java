package com.crud.btt.admin.controller;

import com.crud.btt.admin.entity.ChatLogEntity;
import com.crud.btt.admin.model.dto.ChatLogDto;
import com.crud.btt.admin.model.service.AdminService;
import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class AdminController {
    private final AdminService adminService;

    //chatlist 출력용
    @GetMapping("counseling/chattinglist")
    public Header<List<ChatLogDto>> ChatLogList(@PageableDefault(sort = {"log_no"}) Pageable pageable,
                                                SearchCondition searchCondition) {
        return adminService.getChatLogList(pageable, searchCondition);
    }

    //chatlog table insert
    @PostMapping
    public ChatLogEntity create(@RequestBody ChatLogDto chatLogDto) {
        return adminService.create(chatLogDto);
    }

    //chatlog table delete
    @DeleteMapping
    public void delete(@PathVariable Long log_no){
        adminService.delete(log_no);
    }
}
