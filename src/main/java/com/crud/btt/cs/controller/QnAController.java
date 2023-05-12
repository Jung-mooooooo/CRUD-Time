package com.crud.btt.cs.controller;

import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.model.dto.QnADto;
import com.crud.btt.cs.model.dto.QnAListDto;
import com.crud.btt.cs.model.dto.QnAUpdateDto;


import com.crud.btt.cs.model.service.QnAService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class QnAController {


    private final QnAService qnaService;

    //QNA 목록 출력
    @GetMapping("/admin/AdminQnA")
    public Header<List<QnAListDto>> QnAList(@RequestParam(required = false) String keyword
            , @RequestParam(required = false) String keyValue
            , @PageableDefault(sort = {"qna_no"}) Pageable pageable
    ){
        /*
        검색을 안할때 ( 전체 ) : null ( required ), keyword = "" or null, keyValue = "" or null
        검색을 할때           : keyword, keyValue
        */
        SearchCondition searchCondition = new SearchCondition(keyword,keyValue);
        return qnaService.getQnAList(pageable,searchCondition);
    }

    //QNA 상세보기
    @GetMapping("/admin/AdminQnADetail/{id}")
    public QnADto getQnA(@PathVariable Long qna_no) {
        return qnaService.getQnA(qna_no);
    }


    //QNA 글 작성
    @PostMapping("/admin/AdminQnA/{id}")
    public QnADto qnaCreate(@RequestBody QnADto qnaDto){
        return qnaService.qnaCreate(qnaDto);
    }

    //QNA 글 수정
    @PatchMapping("/admin/AdminQnADetail/{id}")
        public QnAUpdateDto qnaUpdate(@RequestBody QnAUpdateDto qnaUpdateDto){
        return qnaService.qnaUpdate(qnaUpdateDto);
    }

    //QNA 글 삭제
    @DeleteMapping("/admin/AdminQnADetail/{id}")
    public Long  qnaDelete(@PathVariable Long qna_no){
        return qnaService.qnaDelete(qna_no);
    }



}
