package com.crud.btt.admin.controller;

import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.model.dto.NoticeDto;
import com.crud.btt.admin.model.service.AdminNoticeService;
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
public class AdminNoticeController {

    private final AdminNoticeService adminNoticeService;
    private static final Logger logger = LoggerFactory.getLogger(AdminNoticeController.class);

    //목록출력
    @GetMapping("/admin/AdminNotice")
    public Header<List<NoticeDto>> NoticeList(@PageableDefault(sort = {"noticeNo"}) Pageable pageable,
                                              SearchCondition searchCondition){
        // logger.info(pageable.getPageSize()+"/"+pageable.getPageNumber());
        // logger.info("=====================Controller NoticeList==================" + adminNoticeService.getNoticeList(pageable,searchCondition));
        return adminNoticeService.getNoticeList(pageable,searchCondition);
    }
    //상세보기
    @GetMapping("/admin/AdminNoticeDetail/{noticeNo}")
    public NoticeDto getNotice(@PathVariable Long noticeNo) {
        //logger.info("=====================Controller NoticeDetail==================" +adminNoticeService.getNotice(noticeNo));
        //logger.info("============================================= noticeNo : =============================================" + noticeNo);
        //logger.info("=============================================adminNoticeService.getNotice(noticeNo) =============================================:"+adminNoticeService.getNotice(noticeNo));
        return adminNoticeService.getNotice(noticeNo);
    }

    //작성
    @PostMapping("/admin/AdminNoticeWrite")
    public NoticeDto noticeCreate(@RequestBody NoticeDto noticeDto){
        //logger.info("================AdminNoticeWrite : ==============" + noticeDto.getCreateAt().toString());
        return adminNoticeService.noticeCreate(noticeDto);
    }

    //수정
    @PatchMapping("/admin/AdminNoticeWrite")
    public NoticeDto update(@RequestBody NoticeDto noticeDto){
        //logger.info("================AdminNoticeWriteUpdate : ==============" + noticeDto.getCreateAt().toString());
        return adminNoticeService.update(noticeDto);
    }

    //삭제
    @DeleteMapping("/admin/AdminNoticeDelete/{noticeNo}")
    public Long  noticeDelete(@PathVariable Long noticeNo){
        return adminNoticeService.noticeDelete(noticeNo);
    }



}
