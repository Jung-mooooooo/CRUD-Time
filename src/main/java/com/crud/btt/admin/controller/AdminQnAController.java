package com.crud.btt.admin.controller;

import com.crud.btt.admin.model.dto.V_QnADto;
import com.crud.btt.admin.model.service.AdminQnAService;
import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.model.dto.QnADto;
import com.crud.btt.cs.model.dto.QnAListDto;
import com.crud.btt.cs.model.dto.QnAUpdateDto;
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
public class AdminQnAController {


    private final AdminQnAService adminqnaService;
    private static final Logger logger = LoggerFactory.getLogger(AdminQnAController.class);

    //admin top5리스트
    @GetMapping("admin/qnalist")
    public Header<List<V_QnADto>> getTop5QnaList(){

        List<QnADto> list = new ArrayList<>();

        return adminqnaService.top5QnaList();
    }


    //QNA 목록 출력
    @GetMapping("/admin/AdminQnA")
    public Header<List<QnAListDto>> QnAList(@PageableDefault(sort = {"qnaNo"}) Pageable pageable,
                                            SearchCondition searchCondition){

//        logger.info("=====================값 확인==================" +
//                // 전체 리스트를 조회하는거
//                adminqnaService.getQnAList(pageable,searchCondition));

        return adminqnaService.getQnAList(pageable,searchCondition);
    }

    //QNA 상세보기
    @GetMapping("/admin/AdminQnADetail/{qnaNo}")
    public QnADto getQnA(@PathVariable Long qnaNo) {
        logger.info("상세보기 : " + qnaNo);
        return adminqnaService.getQnA(qnaNo);
    }


    //QNA 글 작성
    @PostMapping("/admin/AdminQnAWrite")
    public QnADto qnaCreate(@RequestBody QnADto qnaDto){
        logger.info("qnaCreate In");
        logger.info("qnaDto : "+qnaDto.getQnaRef());
        return adminqnaService.qnaCreate(qnaDto);
    }

    //QNA 글 수정
    @PatchMapping("/admin/AdminQnADetail/{id}")
        public QnAUpdateDto qnaUpdate(@RequestBody QnAUpdateDto qnaUpdateDto){
        return adminqnaService.qnaUpdate(qnaUpdateDto);
    }

    //QNA 글 삭제
    @DeleteMapping("/admin/AdminQnADelete/{qnaNo}")
    public Long  qnaDelete(@PathVariable Long qnaNo){
        return adminqnaService.qnaDelete(qnaNo);
    }

}
