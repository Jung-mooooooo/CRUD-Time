package com.crud.btt.map.controller;

import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.map.model.dto.WelfareFacilityDto;
import com.crud.btt.map.model.service.WelfareFacilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class WelfareFacilityController {

    private final WelfareFacilityService welfareFacilityService;

    //페이지 단위 목록 조회
    @GetMapping("/welfarefacility/welfarefacilitylist")
    public Header<List<WelfareFacilityDto>> getWelfareFacilityList(@PageableDefault(sort = {"wfNo"}) Pageable pageable, SearchCondition searchCondition){

        log.info("info" + pageable.toString());

        return welfareFacilityService.getWelfareFacilityList(pageable, searchCondition);
    }

//    //카테고리별 키워드 검색
//    @GetMapping("/welfarefacility/searchlist")
//    public Header<List<WelfareFacilityDto>> getSearchList(@PageableDefault(sort = {"idx"}) Pageable pageable,
//                                                      SearchCondition searchCondition){
//        return welfareFacilityService.getSearchList(pageable, searchCondition);
//    }
//
//    //카테고리(병원)별 리스트 조회
    @GetMapping("/hospital/list")
    public Header<List<WelfareFacilityDto>> getHospitalList(@PageableDefault(sort = {"wfNo"}) Pageable pageable,
                                                            SearchCondition searchCondition){
        return welfareFacilityService.getHospitalList(pageable, searchCondition);
    }
//
//    //카테고리(상담센터)별 리스트 조회
    @GetMapping("/counsellingcenter/list")
    public Header<List<WelfareFacilityDto>> getCounsellingCenterList(@PageableDefault(sort = {"wfNo"}) Pageable pageable,
                                                                     SearchCondition searchCondition){
        return welfareFacilityService.getCounsellingCenterList(pageable, searchCondition);
    }
//
//    //등록
//    @PostMapping("/")
//    public WelfareFacilityEntity create(@RequestBody WelfareFacilityDto welfareFacilityDto){
//        return welfareFacilityService.create(welfareFacilityDto);
//    }
//
//    //수정
    //@PatchMapping("/")
//    public WelfareFacilityEntity update(@RequestBody WelfareFacilityDto welfareFacilityDto){
//        return welfareFacilityService.update(welfareFacilityDto);
//    }
//
//    //삭제
    //@DeleteMapping("/")
//    public void delete (@PathVariable Long wf_no){
//        welfareFacilityService.delete(wf_no);
//    }

}




