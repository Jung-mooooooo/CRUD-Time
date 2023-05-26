package com.crud.btt.cs.controller;

import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.model.dto.QnADto;
import com.crud.btt.cs.model.dto.QnAListDto;
import com.crud.btt.cs.model.dto.QnAUpdateDto;
import com.crud.btt.cs.model.service.QnAService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/cs/QnA")
    public Header<List<QnAListDto>> QnAList(@PageableDefault(sort = {"qnaNo"}) Pageable pageable,
                                            SearchCondition searchCondition){

//        logger.info("=====================값 확인==================" +
//                // 전체 리스트를 조회하는거
//                qnaService.getQnAList(pageable,searchCondition));

        return qnaService.getQnAList(pageable,searchCondition);
    }

    //QNA 상세보기
    @GetMapping("/cs/QnADetail/{qnaNo}")
    public QnADto getQnA(@PathVariable Long qnaNo) {
        logger.info("상세보기 : " + qnaNo);
        return qnaService.getQnA(qnaNo);
    }


    //QNA 글 작성
    @PostMapping("/cs/QnAWrite")
    public QnADto qnaCreate(@RequestBody QnADto qnaDto){
        logger.info("qnaCreate In");
        logger.info("qnaDto : "+qnaDto.getQnaRef());
        return qnaService.qnaCreate(qnaDto);
    }

    //QNA 글 수정
    @PatchMapping("/cs/QnADetail/{id}")
        public QnAUpdateDto qnaUpdate(@RequestBody QnAUpdateDto qnaUpdateDto){
        return qnaService.qnaUpdate(qnaUpdateDto);
    }

    //QNA 글 삭제
    @DeleteMapping("/cs/QnADelete/{qnaNo}")
    public Long  qnaDelete(@PathVariable Long qnaNo){
        return qnaService.qnaDelete(qnaNo);
    }

}
