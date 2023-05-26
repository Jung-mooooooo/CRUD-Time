package com.crud.btt.cs.controller;

import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.model.dto.FAQDto;
import com.crud.btt.cs.model.service.FAQService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class FAQController {

    private final FAQService faqService;

    private static final Logger logger = LoggerFactory.getLogger(FAQController.class);

    //목록출력
    @GetMapping("/cs/FAQ")
    public Header<List<FAQDto>> getFAQList(@PageableDefault(sort = {"faqNo"}) Pageable pageable,
                                              SearchCondition searchCondition){
        // logger.info(pageable.getPageSize()+"/"+pageable.getPageNumber());
        logger.info("=====================Controller FAQList==================" + faqService.getFAQList(pageable,searchCondition));
        return faqService.getFAQList(pageable,searchCondition);
    }
    //상세보기
    @GetMapping("/cs/FAQDetail/{faqNo}")
    public FAQDto getFAQ(@PathVariable Long faqNo) {
        //logger.info("=====================Controller FAQDetail==================" +faqService.getFAQ(faqNo));
        //logger.info("============================================= faqNo : =============================================" + faqNo);
        //logger.info("=============================================faqService.getFAQ(faqNo) =============================================:"+faqService.getFAQ(faqNo));
        return faqService.getFAQ(faqNo);
    }
//
//    //작성
//    @PostMapping("/admin/AdminFAQWrite")
//    public FAQDto faqCreate(@RequestBody FAQDto faqDto){
//        //logger.info("================AdminFAQWrite : ==============" + faqDto.getCreateAt().toString());
//        return faqService.faqCreate(faqDto);
//    }
//
//    //수정
//    @PatchMapping("/admin/AdminFAQWrite")
//    public FAQUpdateDto update(@RequestBody FAQUpdateDto faqUpdateDto){
//        if( faqUpdateDto == null ) logger.info("update method get null object");
//        else logger.info("update method get not null object");
//        // logger.info("================AdminFAQWriteUpdate : ==============" + faqUpdateDto.getCreateAt().toString());
//        logger.info("PATCH METHOD UPDATE : "+faqUpdateDto.getFaqCat());
//        return faqService.update(faqUpdateDto);
//    }
//
//    //삭제
//    @DeleteMapping("/admin/AdminFAQDelete/{faqNo}")
//    public Long faqDelete(@PathVariable Long faqNo){
//        logger.info("faqNo : " + faqNo);
//        return faqService.faqDelete(faqNo);
//    }






}

