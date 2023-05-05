package com.crud.btt.map.controller;

import com.crud.btt.map.entity.HobbyEntity;
import com.crud.btt.map.entity.HobbyRepository;
import com.crud.btt.map.model.dto.HobbyDto;
import com.crud.btt.map.model.dto.WelfareFacilityDto;
import com.crud.btt.map.model.service.HobbyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class HobbyController {

//    private HobbyService hobbyService;
//
//    //페이지 단위 목록 조회
////    public Header<List<WelfareFacilityDto>> WelfareFacilityList(){}
//
//    //검색 장소 리스트 조회
//
//    //카테고리(병원)별 리스트 조회
//
//    //카테고리(상담센터)별 리스트 조회
//
//    //등록
//    public HobbyEntity create(@RequestBody HobbyDto hobbyDto){
//        return hobbyService.create(hobbyDto);
//    }
//    //수정
//    public HobbyEntity update(@RequestBody HobbyDto hobbyDto){
//        return hobbyService.update(hobbyDto);
//    }
//
//    //삭제
//    public void delete(@PathVariable Long hobby_no){
//        hobbyService.delete(hobby_no);
//    }
}
