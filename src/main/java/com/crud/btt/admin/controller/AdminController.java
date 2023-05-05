package com.crud.btt.admin.controller;

import com.crud.btt.admin.entity.ChatLogEntity;
import com.crud.btt.admin.model.dto.ChatLogDto;
import com.crud.btt.admin.model.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class AdminController {
//    private final AdminService adminService;

//    @GetMapping("counseling/chattinglist")
//    public Header<List<ChatLogDto>> ChatLogList (@PageableDefault(sort = {"log_no"})Pageable pageable,
//                                                 SearchCondition searchCondition) {
//        return adminService.getChatLogList(pageable, searchCondition);
//    }

    //chatlog table insert
//    public ChatLogEntity create(@RequestBody ChatLogDto chatLogDto){
//        return adminService.create(chatLogDto);
//    }

}
