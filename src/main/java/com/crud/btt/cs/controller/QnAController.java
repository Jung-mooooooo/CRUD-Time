package com.crud.btt.cs.controller;

import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.model.dto.QnADto;
import com.crud.btt.cs.model.dto.QnAListDto;
import com.crud.btt.cs.model.service.QnAService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class QnAController {


    private final QnAService qnaService;
    private static final Logger logger = LoggerFactory.getLogger(QnAController.class);

    //admin top5리스트
    @GetMapping("admin/qnalist")
    public Header<List<QnADto>> getTop5QnaList(){

        List<QnADto> list = new ArrayList<>();

        return qnaService.top5QnaList();
    }

    //QNA 목록 출력
    @GetMapping("/admin/AdminQnA")
    public Header<List<QnAListDto>> QnAList(@PageableDefault(sort = {"qnaNo"}) Pageable pageable,
                                            SearchCondition searchCondition){

        logger.info("=====================값 확인==================" +
                qnaService.getQnAList(pageable,searchCondition));

        return qnaService.getQnAList(pageable,searchCondition);
    }

    //QNA 상세보기
//    @GetMapping("/admin/AdminQnADetail/{id}")
//    public QnADto getQnA(@PathVariable Long qna_no) {
//        return qnaService.getQnA(qna_no);
//    }
//
//
//    //QNA 글 작성
//    @PostMapping("/admin/AdminQnA/{id}")
//    public QnADto qnaCreate(@RequestBody QnADto qnaDto){
//        return qnaService.qnaCreate(qnaDto);
//    }
//
//    //QNA 글 수정
//    @PatchMapping("/admin/AdminQnADetail/{id}")
//        public QnAUpdateDto qnaUpdate(@RequestBody QnAUpdateDto qnaUpdateDto){
//        return qnaService.qnaUpdate(qnaUpdateDto);
//    }
//
//    //QNA 글 삭제
//    @DeleteMapping("/admin/AdminQnADetail/{id}")
//    public Long  qnaDelete(@PathVariable Long qna_no){
//        return qnaService.qnaDelete(qna_no);
//    }



}
