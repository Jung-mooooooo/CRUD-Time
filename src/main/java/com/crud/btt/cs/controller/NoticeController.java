package com.crud.btt.cs.controller;

import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.model.dto.NoticeDto;
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

    //목록출력
    @GetMapping("/cs/Notice")
    public Header<List<NoticeDto>> NoticeList(@PageableDefault(sort = {"noticeNo"}) Pageable pageable,
                                              SearchCondition searchCondition){
         logger.info(pageable.getPageSize()+"/"+pageable.getPageNumber());
        // logger.info("=====================Controller NoticeList==================" + noticeService.getNoticeList(pageable,searchCondition));
        return noticeService.getNoticeList(pageable,searchCondition);
    }
    //상세보기
    @GetMapping("/cs/NoticeDetail/{noticeNo}")
    public NoticeDto getNotice(@PathVariable Long noticeNo) {
        //logger.info("=====================Controller NoticeDetail==================" +noticeService.getNotice(noticeNo));
        //logger.info("============================================= noticeNo : =============================================" + noticeNo);
        //logger.info("=============================================noticeService.getNotice(noticeNo) =============================================:"+noticeService.getNotice(noticeNo));
        return noticeService.getNotice(noticeNo);
    }

//    //작성
//    @PostMapping("/admin/AdminNoticeWrite")
//    public NoticeDto noticeCreate(@RequestBody NoticeDto noticeDto){
//        //logger.info("================AdminNoticeWrite : ==============" + noticeDto.getCreateAt().toString());
//        return noticeService.noticeCreate(noticeDto);
//    }
//
//    //수정
//    @PatchMapping("/admin/AdminNoticeWrite")
//    public NoticeDto update(@RequestBody NoticeDto noticeDto){
//        //logger.info("================AdminNoticeWriteUpdate : ==============" + noticeDto.getCreateAt().toString());
//        return noticeService.update(noticeDto);
//    }
//
//    //삭제
//    @DeleteMapping("/admin/AdminNoticeDelete/{noticeNo}")
//    public Long  noticeDelete(@PathVariable Long noticeNo){
//        return noticeService.noticeDelete(noticeNo);
//    }



}
