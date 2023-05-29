package com.crud.btt.admin.controller;

import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.model.dto.FAQDto;
import com.crud.btt.cs.model.dto.FAQUpdateDto;
import com.crud.btt.admin.model.service.AdminFAQService;
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
public class AdminFAQController {

    private final AdminFAQService adminfaqService;

    private static final Logger logger = LoggerFactory.getLogger(AdminFAQController.class);

    //목록출력
    @GetMapping("/admin/AdminFAQ")
    public Header<List<FAQDto>> getFAQList(@PageableDefault(sort = {"faqNo"}) Pageable pageable,
                                              SearchCondition searchCondition){
        // logger.info(pageable.getPageSize()+"/"+pageable.getPageNumber());
        logger.info("=====================Controller FAQList==================" + adminfaqService.getFAQList(pageable,searchCondition));
        return adminfaqService.getFAQList(pageable,searchCondition);
    }
    //상세보기
    @GetMapping("/admin/AdminFAQDetail/{faqNo}")
    public FAQDto getFAQ(@PathVariable Long faqNo) {
        //logger.info("=====================Controller FAQDetail==================" +adminfaqService.getFAQ(faqNo));
        //logger.info("============================================= faqNo : =============================================" + faqNo);
        //logger.info("=============================================adminfaqService.getFAQ(faqNo) =============================================:"+adminfaqService.getFAQ(faqNo));
        return adminfaqService.getFAQ(faqNo);
    }

    //작성
    @PostMapping("/admin/AdminFAQWrite")
    public FAQDto create(@RequestBody FAQDto faqDto){
        //logger.info("================AdminFAQWrite : ==============" + faqDto.getCreateAt().toString());
        return adminfaqService.create(faqDto);
    }

    //수정
    @PatchMapping("/admin/AdminFAQWrite")
    public FAQUpdateDto update(@RequestBody FAQUpdateDto faqUpdateDto){
        if( faqUpdateDto == null ) logger.info("update method get null object");
        else logger.info("update method get not null object");
        // logger.info("================AdminFAQWriteUpdate : ==============" + faqUpdateDto.getCreateAt().toString());
        logger.info("PATCH METHOD UPDATE : "+faqUpdateDto.getFaqCat());
        return adminfaqService.update(faqUpdateDto);
    }

    //삭제
    @DeleteMapping("/admin/AdminFAQDelete/{faqNo}")
    public Long faqDelete(@PathVariable Long faqNo){
        logger.info("faqNo : " + faqNo);
        return adminfaqService.faqDelete(faqNo);
    }


}

