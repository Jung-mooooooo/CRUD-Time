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
    @GetMapping("/hobby/list")
    public Header<List<HobbyDto>> getHobbyList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                               SearchCondition searchCondition){
        return hobbyService.getHobbyList(pageable, searchCondition);
    }

    //카테고리별 키워드 검색
    @GetMapping("/hobby/searchlist")
    public Header<List<HobbyDto>> getSearchList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                                SearchCondition searchCondition){
        return hobbyService.getSearchList(pageable, searchCondition);
    }

    //카테고리(음악)별 리스트 조회
    @GetMapping("/hobby/musiclist")
    public Header<List<HobbyDto>> getMusicList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                               SearchCondition searchCondition){
        return hobbyService.getMusicList(pageable, searchCondition);
    }

    //카테고리(미술)별 리스트 조회
    @GetMapping("/hobby/artlist")
    public Header<List<HobbyDto>> getArtList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                             SearchCondition searchCondition){
        return hobbyService.getArtList(pageable, searchCondition);
    }

    //카테고리(무용)별 리스트 조회
    @GetMapping("/hobby/dancelist")
    public Header<List<HobbyDto>> getDanceList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                               SearchCondition searchCondition){
        return hobbyService.getDanceList(pageable, searchCondition);
    }

    //카테고리(언어)별 리스트 조회
    @GetMapping("/hobby/languagelist")
    public Header<List<HobbyDto>> getLanguageList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                                  SearchCondition searchCondition){
        return hobbyService.getLanguageList(pageable, searchCondition);
    }

    //카테고리(미디어)별 리스트 조회
    @GetMapping("/hobby/medialist")
    public Header<List<HobbyDto>> getMediaList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                               SearchCondition searchCondition){
        return hobbyService.getMediaList(pageable, searchCondition);
    }

    //등록
    public HobbyEntity create(@RequestBody HobbyDto hobbyDto){
        return hobbyService.create(hobbyDto);
    }
    //수정
    public HobbyEntity update(@RequestBody HobbyDto hobbyDto){
        return hobbyService.update(hobbyDto);
    }

    //삭제
    public void delete(@PathVariable Long hobby_no){
        hobbyService.delete(hobby_no);
    }
}
