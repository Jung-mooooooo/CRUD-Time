package com.crud.btt.map.controller;

import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.map.entity.HobbyEntity;
import com.crud.btt.map.model.dto.HobbyDto;
import com.crud.btt.map.model.service.HobbyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class HobbyController {

    private final HobbyService hobbyService;

    //페이지 단위 목록 조회
    @GetMapping("/welfareProgram/hobbyList")
    public Header<List<HobbyDto>> getHobbyList(@PageableDefault(sort = {"hobbyNo"}) Pageable pageable, SearchCondition searchCondition){
        return hobbyService.getHobbyList(pageable, searchCondition);
    }

    //카테고리별 키워드 검색
//    @GetMapping("/hobby/searchlist")
//    public Header<List<HobbyDto>> getSearchList(@PageableDefault(sort = {"idx"}) Pageable pageable,
//                                               SearchCondition searchCondition){
//        return hobbyService.getSearchList(pageable, searchCondition);
//    }

    //카테고리(음악)별 리스트 조회
    @GetMapping("/hobby/musiclist")
    public Header<List<HobbyDto>> getMusicList(@PageableDefault(sort = {"hobbyNo"}) Pageable pageable,
                                               SearchCondition searchCondition){
        return hobbyService.getMusicList(pageable, searchCondition);
    }

    //카테고리(미술)별 리스트 조회
    @GetMapping("/hobby/artlist")
    public Header<List<HobbyDto>> getArtList(@PageableDefault(sort = {"hobbyNo"}) Pageable pageable,
                                             SearchCondition searchCondition){
        return hobbyService.getArtList(pageable, searchCondition);
    }

    //카테고리(무용)별 리스트 조회
    @GetMapping("/hobby/dancelist")
    public Header<List<HobbyDto>> getDanceList(@PageableDefault(sort = {"hobbyNo"}) Pageable pageable,
                                               SearchCondition searchCondition){
        return hobbyService.getDanceList(pageable, searchCondition);
    }

    //카테고리(언어)별 리스트 조회
    @GetMapping("/hobby/languagelist")
    public Header<List<HobbyDto>> getLanguageList(@PageableDefault(sort = {"hobbyNo"}) Pageable pageable,
                                                  SearchCondition searchCondition){
        return hobbyService.getLanguageList(pageable, searchCondition);
    }


    //등록
    @PostMapping("/hobby")
    public HobbyEntity create(@RequestBody HobbyDto hobbyDto){
        return hobbyService.create(hobbyDto);
    }

    //수정
    @PatchMapping("/hobby")
    public List<HobbyEntity> update(@RequestBody List<HobbyEntity> entity){
        return hobbyService.update(entity);
    }

    //삭제
    @DeleteMapping("/hobby/{hobbyNo}")
    public void delete(@PathVariable Long hobbyNo){
        hobbyService.delete(hobbyNo);
    }
}
