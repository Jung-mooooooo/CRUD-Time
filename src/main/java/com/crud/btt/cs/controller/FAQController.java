package com.crud.btt.cs.controller;

import com.crud.btt.cs.model.dto.FAQDto;
import com.crud.btt.cs.model.dto.FAQUpdateDto;
import com.crud.btt.cs.model.service.FAQService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class FAQController {

//    private final FAQService faqService;

    //FAQ 목록 출력
//    @GetMapping("/admin/AdminFAQ")
//    public Header<List<FAQDto>> FAQList(@RequestParam(required = false) String keyword
//            , @RequestParam(required = false) String keyValue
//            , @PageableDefault(sort = {"FAQ_no"}) Pageable pageable
//    ){
//        /*
//        검색을 안할때 ( 전체 ) : null ( required ), keyword = "" or null, keyValue = "" or null
//        검색을 할때           : keyword, keyValue
//        */
//        SearchCondition searchCondition = new SearchCondition(keyword,keyValue);
//        return faqService.getFAQList(pageable,searchCondition);
//    }

    //FAQ 상세보기
//    @GetMapping("/admin/AdminFAQDetail/{id}")
//    public FAQDto getFAQ(@PathVariable Long FAQ_no) {
//        return faqService.getFAQ(FAQ_no);
//    }


//    //FAQ 글 작성
//    @PostMapping("/admin/AdminFAQWrite/{id}")
//    public FAQDto faqCreate(@RequestBody FAQDto FAQDto){
//        return faqService.faqCreate(FAQDto);
//    }
//
//    //FAQ 글 수정
//    @PatchMapping("/admin/AdminFAQDetail/{id}")
//    public FAQUpdateDto faqUpdate(@RequestBody FAQUpdateDto FAQUpdateDto){
//        return faqService.faqUpdate(FAQUpdateDto);
//    }
//
//    //FAQ 글 삭제
//    @DeleteMapping("/admin/AdminFAQDetail/{id}")
//    public Long  faqDelete(@PathVariable Long FAQ_no){
//        return faqService.faqDelete(FAQ_no);
//    }







}
