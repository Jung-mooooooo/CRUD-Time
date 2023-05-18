package com.crud.btt.cs.controller;

import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.model.dto.NoticeDto;
import com.crud.btt.cs.model.dto.NoticeUpdateDto;
import com.crud.btt.cs.model.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class NoticeController {

    private final NoticeService noticeService;
    private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

    //공지사항 목록 출력
    @GetMapping("/admin/AdminNotice")
    public Header<List<NoticeDto>> NoticeList(@PageableDefault(sort = {"noticeNo"}) Pageable pageable,
                                              SearchCondition searchCondition){
        /*
        검색을 안할때 ( 전체 ) : null ( required ), keyword = "" or null, keyValue = "" or null
        검색을 할때           : keyword, keyValue
        */
        // logger.info(pageable.getPageSize()+"/"+pageable.getPageNumber());
        logger.info("=====================값 확인==================" + noticeService.getNoticeList(pageable,searchCondition));

        return noticeService.getNoticeList(pageable,searchCondition);

    }
    
    //공지사항 상세보기
//   @GetMapping("/admin/AdminNoticeDetail/{id}")
//    public NoticeDto getNotice(@PathVariable Long notice_no) {
//        return noticeService.getNotice(notice_no);
//    }


    //공지사항 글 작성
//    @PostMapping("/admin/AdminNoticeWrite/{id}")
//    public NoticeDto noticeCreate(@RequestBody NoticeDto noticeDto){
//        return noticeService.noticeCreate(noticeDto);
//    }

    //공지사항 글 수정
    @PatchMapping("/admin/AdminNoticeDetail/{id}")
    public NoticeUpdateDto noticeUpdate(@RequestBody NoticeUpdateDto noticeUpdateDto){
        return noticeService.noticeUpdate(noticeUpdateDto);
    }

    //공지사항 글 삭제
    @DeleteMapping("/admin/AdminNoticeDetail/{id}")
    public Long  noticeDelete(@PathVariable Long notice_no){
        return noticeService.noticeDelete(notice_no);
    }



}
