package com.crud.btt.map.controller;

import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.map.entity.TouristSpotEntity;
import com.crud.btt.map.model.dto.HobbyDto;
import com.crud.btt.map.model.dto.TouristSpotDto;
import com.crud.btt.map.model.service.TouristSpotService;
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
public class TouristSpotController {

    private final TouristSpotService touristSpotService;

    //페이지 단위 목록 조회
    @GetMapping("/touristspot/list")
    public Header<List<TouristSpotDto>> getTouristSpotList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                                           SearchCondition searchCondition){
        return touristSpotService.getTouristSpotList(pageable, searchCondition);
    }

    //카테고리(바다)별 리스트 조회
    @GetMapping("/sea/list")
    public Header<List<TouristSpotDto>> getSeaList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                                   SearchCondition searchCondition){
        return touristSpotService.getSeaList(pageable, searchCondition);
    }

    //카테고리(공원)별 리스트 조회
    @GetMapping("/park/list")
    public Header<List<TouristSpotDto>> getParkList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                                    SearchCondition searchCondition){
        return touristSpotService.getParkList(pageable, searchCondition);
    }

    //카테고리(휴양림)별 리스트 조회
    @GetMapping("/forest/list")
    public Header<List<TouristSpotDto>> getForestList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                                      SearchCondition searchCondition){
        return touristSpotService.getForestList(pageable, searchCondition);
    }

    //카테고리(액티비티)별 리스트 조회
    @GetMapping("/activity/list")
    public Header<List<TouristSpotDto>> getActivityList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                                        SearchCondition searchCondition){
        return touristSpotService.getActivityList(pageable, searchCondition);
    }

    //카테고리(캠핑)별 리스트 조회
    @GetMapping("/camping/list")
    public Header<List<TouristSpotDto>> getCampingList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                                       SearchCondition searchCondition){
        return touristSpotService.getCampingList(pageable, searchCondition);
    }

    //카테고리(박물관)별 리스트 조회
    @GetMapping("/museum/list")
    public Header<List<TouristSpotDto>> getMuseumList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                                      SearchCondition searchCondition){
        return touristSpotService.getMuseumList(pageable, searchCondition);
    }

    // 카테고리(미술관)별 리스트 조회
    @GetMapping("/gallery/list")
    public Header<List<TouristSpotDto>> getGalleryList(@PageableDefault(sort = {"idx"}) Pageable pageable,
                                                       SearchCondition searchCondition){
        return touristSpotService.getGalleryList(pageable, searchCondition);
    }

    //등록
//    public TouristSpotEntity create(@RequestBody TouristSpotDto touristSpotDto){
//        return touristSpotService.create(touristSpotDto);
//    }

    //수정
    public TouristSpotEntity update(@RequestBody TouristSpotDto touristSpotDto){
        return touristSpotService.update(touristSpotDto);
    }

    //삭제
    public void delete(@PathVariable Long ts_no){
        touristSpotService.delete(ts_no);
    }
}
