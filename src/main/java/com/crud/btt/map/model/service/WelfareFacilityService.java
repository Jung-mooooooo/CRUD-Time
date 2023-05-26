package com.crud.btt.map.model.service;

import com.crud.btt.common.CustomPageable;
import com.crud.btt.common.Header;
import com.crud.btt.common.Pagination;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.map.entity.WelfareFacilityEntity;
import com.crud.btt.map.entity.WelfareFacilityRepository;
import com.crud.btt.map.entity.WelfareFacilityRepositoryCustom;
import com.crud.btt.map.model.dto.WelfareFacilityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class WelfareFacilityService {

    private final WelfareFacilityRepository welfareFacilityRepository;
    private final WelfareFacilityRepositoryCustom welfareFacilityRepositoryCustom;

    //지도 목록 조회(페이징 처리)
    public Header<List<WelfareFacilityDto>> getWelfareFacilityList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
        List<WelfareFacilityDto> list = new ArrayList<>();

        Page<WelfareFacilityEntity> welfareFacilityEntities = welfareFacilityRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (WelfareFacilityEntity entity : welfareFacilityEntities) {
            WelfareFacilityDto dto = WelfareFacilityDto.builder()
                    .wfNo(entity.getWfNo())
                    .wfName(entity.getWfName())
                    .wfCat(entity.getWfCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) welfareFacilityEntities.getTotalElements()
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        log.info(pagination.toString());

        return Header.OK(list, pagination);
    }

//    //카테고리별 키워드 검색
//    public Header<List<WelfareFacilityDto>> getSearchList(Pageable pageable, SearchCondition searchCondition) {
//        return null;
//    }



//    //카테고리(병원)별 리스트 조회
    public Header<List<WelfareFacilityDto>> getHospitalList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
        List<WelfareFacilityDto> list = new ArrayList<>();

        Page<WelfareFacilityEntity> welfareFacilityEntities = welfareFacilityRepositoryCustom.findAllByCategoryIsAndNameLikeHospital(pageable, searchCondition);
        for (WelfareFacilityEntity entity : welfareFacilityEntities) {
            WelfareFacilityDto dto = WelfareFacilityDto.builder()
                    .wfNo(entity.getWfNo())
                    .wfName(entity.getWfName())
                    .wfCat(entity.getWfCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();
            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) welfareFacilityEntities.getTotalElements()
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        return Header.OK(list, pagination);
    }
//
//    //카테고리(상담센터)별 리스트 조회
    public Header<List<WelfareFacilityDto>> getCounsellingCenterList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
        List<WelfareFacilityDto> list = new ArrayList<>();

        Page<WelfareFacilityEntity> welfareFacilityEntities = welfareFacilityRepositoryCustom.findAllByCategoryIsAndNameLikeCounselling(pageable, searchCondition);
        for (WelfareFacilityEntity entity : welfareFacilityEntities) {
            WelfareFacilityDto dto = WelfareFacilityDto.builder()
                    .wfNo(entity.getWfNo())
                    .wfName(entity.getWfName())
                    .wfCat(entity.getWfCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) welfareFacilityEntities.getTotalElements()
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        return Header.OK(list, pagination);
    }


    //등록
    public WelfareFacilityEntity create(WelfareFacilityDto welfareFacilityDto){
        WelfareFacilityEntity entity = WelfareFacilityEntity.builder()
                .wfNo(welfareFacilityDto.getWfNo())
                .wfName(welfareFacilityDto.getWfName())
                .wfCat(welfareFacilityDto.getWfCat())
                .address(welfareFacilityDto.getAddress())
                .address2(welfareFacilityDto.getAddress2())
                .phone(welfareFacilityDto.getPhone())
                .latitude(welfareFacilityDto.getLatitude())
                .longitude(welfareFacilityDto.getLongitude())
                .build();

        return welfareFacilityRepository.save(entity);
    }

    //수정
    public List<WelfareFacilityEntity> update(List<WelfareFacilityEntity> welfareFacilityDtoList){
        List<WelfareFacilityEntity> updatedEntities = new ArrayList<>();

        for (WelfareFacilityEntity welfareFacilityDto : welfareFacilityDtoList) {
            WelfareFacilityEntity entity = welfareFacilityRepository.findBywfNo(welfareFacilityDto.getWfNo());
            entity.setWfNo(welfareFacilityDto.getWfNo());
            entity.setWfName(welfareFacilityDto.getWfName());
            entity.setWfCat(welfareFacilityDto.getWfCat());
            entity.setAddress(welfareFacilityDto.getAddress());
            entity.setAddress2(welfareFacilityDto.getAddress2());
            entity.setPhone(welfareFacilityDto.getPhone());
            entity.setLatitude(welfareFacilityDto.getLatitude());
            entity.setLongitude(welfareFacilityDto.getLongitude());
            updatedEntities.add(welfareFacilityRepository.save(entity));
        }

        return updatedEntities;
    }

    //삭제
    public void delete (Long wfNo){
        WelfareFacilityEntity entity = welfareFacilityRepository.findById(wfNo).orElseThrow(() -> new RuntimeException("해당 업체를 찾을 수 없습니다."));
        welfareFacilityRepository.delete(entity);
    }
    }


