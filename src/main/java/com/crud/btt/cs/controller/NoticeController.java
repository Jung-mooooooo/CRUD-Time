package com.crud.btt.cs.controller;

import com.crud.btt.cs.model.dto.NoticeDto;
import com.crud.btt.cs.model.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class NoticeController {

    private final NoticeService noticeService;
//
//    @GetMapping("/admin/AdminNotice")
//    public Header<List<NoticeDto>> NoticeList(){
//
//    }
//
//    @GetMapping("/admin/AdminNoticeDetail/{id}")
//    public NoticeDto getNotice(@PathVariable Long id) {
//        return NoticeService.getBoard(id);
//    }
//
//
//    @PostMapping("/admin/AdminNoticeWrite")
//    public BoardEntity create(@RequestBody BoardDto boardDto) {
//        return boardService.create(boardDto);
//    }
//
//
//    @PatchMapping("/admin/AdminNoticeWrite")
//    public BoardEntity update(@RequestBody BoardDto boardDto) {
//        return boardService.update(boardDto);
//    }
//
//
//    @DeleteMapping("/admin/AdminNoticeDetail/{id}")
//    public void delete(@PathVariable Long id) {
//        boardService.delete(id);
//    }





}
