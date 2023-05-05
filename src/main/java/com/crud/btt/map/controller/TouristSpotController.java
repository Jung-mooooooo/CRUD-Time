package com.crud.btt.map.controller;

import com.crud.btt.map.entity.TouristSpotEntity;
import com.crud.btt.map.model.dto.TouristSpotDto;
import com.crud.btt.map.model.service.TouristSpotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class TouristSpotController {
    private TouristSpotService touristSpotService;

    //페이지 단위 목록 조회
//    public Header<List<TouristSpotDto>> TouristSpotList(){}

    //검색 장소 리스트 조회

    //카테고리(병원)별 리스트 조회

    //카테고리(상담센터)별 리스트 조회

    //등록
//    public TouristSpotEntity create(@RequestBody TouristSpotDto touristSpotDto){
//        return touristSpotService.create(touristSpotDto);
//    }

    //수정

    //삭제
}
