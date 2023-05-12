package com.crud.btt.cs.controller;

import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.entity.NoticeEntity;
import com.crud.btt.cs.model.dto.NoticeDto;
import com.crud.btt.cs.model.dto.NoticeUpdateDto;
import com.crud.btt.cs.model.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class NoticeController {

    private final NoticeService noticeService;

    //공지사항 목록 출력

    @GetMapping("/admin/AdminNotice")
    public Header<List<NoticeDto>> NoticeList(//@RequestParam(required = false) String keyword
//                                              ,@RequestParam(required = false) String keyValue
                                                SearchCondition searchCondition,
                                                @PageableDefault(sort = {"noticeNo"}) Pageable pageable
    ){
        System.out.println("In NoticeList");
        /*
        검색을 안할때 ( 전체 ) : null ( required ), keyword = "" or null, keyValue = "" or null
        검색을 할때           : keyword, keyValue
        */
        //SearchCondition searchCondition = new SearchCondition(keyword,keyValue);
        return noticeService.getNoticeList(pageable,searchCondition);
    }


    //공지사항 상세보기
//   @GetMapping("/admin/AdminNoticeDetail/{id}")
//    public NoticeDto getNotice(@PathVariable Long noticeNo) {
//        return noticeService.getNotice(noticeNo);
//    }


    //공지사항 글 작성
    @PostMapping("/admin/AdminNotice/{id}")
    public NoticeDto noticeCreate(@RequestBody NoticeDto noticeDto){
        return noticeService.noticeCreate(noticeDto);
    }

    //공지사항 글 수정
    @PatchMapping("/admin/AdminNoticeDetail/{id}")
    public NoticeUpdateDto noticeUpdate(@RequestBody NoticeUpdateDto noticeUpdateDto){
        return noticeService.noticeUpdate(noticeUpdateDto);
    }

    //공지사항 글 삭제
    @DeleteMapping("/admin/AdminNoticeDetail/{id}")
    public Long  noticeDelete(@PathVariable Long noticeNo){
        return noticeService.noticeDelete(noticeNo);
    }



}

