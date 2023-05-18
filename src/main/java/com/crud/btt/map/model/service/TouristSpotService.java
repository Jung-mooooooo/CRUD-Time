package com.crud.btt.map.model.service;

import com.crud.btt.common.Header;
import com.crud.btt.common.Pagination;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.map.entity.TouristSpotEntity;
import com.crud.btt.map.entity.TouristSpotRepository;
import com.crud.btt.map.entity.TouristSpotRepositoryCustom;
import com.crud.btt.map.model.dto.TouristSpotDto;
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
public class TouristSpotService {

    private final TouristSpotRepository touristSpotRepository;

    private final TouristSpotRepositoryCustom touristSpotRepositoryCustom;

    //지도 목록 조회(페이징 처리)
    public Header<List<TouristSpotDto>> getTouristSpotList(Pageable pageable, SearchCondition searchCondition){
        List<TouristSpotDto> list = new ArrayList<>();

        Page<TouristSpotEntity> touristSpotEntities = touristSpotRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (TouristSpotEntity entity : touristSpotEntities) {
            TouristSpotDto dto = TouristSpotDto.builder()
                    .tsNo(entity.getTsNo())
                    .tsName(entity.getTsName())
                    .tsCat(entity.getTsCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) touristSpotEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }
//
//    //카테고리별 키워드 검색
//    public Header<List<TouristSpotDto>> getSearchList(Pageable pageable, SearchCondition searchCondition) {
//        return null;
//    }
//
//
//    //카테고리(바다)별 리스트 조회
    public Header<List<TouristSpotDto>> getSeaList(Pageable pageable, SearchCondition searchCondition){
        List<TouristSpotDto> list = new ArrayList<>();

        Page<TouristSpotEntity> touristSpotEntities = touristSpotRepositoryCustom.findAllByCategoryIsAndNameLikeSea(pageable, searchCondition);
        for (TouristSpotEntity entity : touristSpotEntities) {
            TouristSpotDto dto = TouristSpotDto.builder()
                    .tsNo(entity.getTsNo())
                    .tsName(entity.getTsName())
                    .tsCat(entity.getTsCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) touristSpotEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }
//
//    //카테고리(공원)별 리스트 조회
    public Header<List<TouristSpotDto>> getParkList(Pageable pageable, SearchCondition searchCondition){
        List<TouristSpotDto> list = new ArrayList<>();

        Page<TouristSpotEntity> touristSpotEntities = touristSpotRepositoryCustom.findAllByCategoryIsAndNameLikePark(pageable, searchCondition);
        for (TouristSpotEntity entity : touristSpotEntities) {
            TouristSpotDto dto = TouristSpotDto.builder()
                    .tsNo(entity.getTsNo())
                    .tsName(entity.getTsName())
                    .tsCat(entity.getTsCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) touristSpotEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }
//
//    //카테고리(휴양림)별 리스트 조회
    public Header<List<TouristSpotDto>> getForestList(Pageable pageable, SearchCondition searchCondition){
        List<TouristSpotDto> list = new ArrayList<>();

        Page<TouristSpotEntity> touristSpotEntities = touristSpotRepositoryCustom.findAllByCategoryIsAndNameLikeForest(pageable, searchCondition);
        for (TouristSpotEntity entity : touristSpotEntities) {
            TouristSpotDto dto = TouristSpotDto.builder()
                    .tsNo(entity.getTsNo())
                    .tsName(entity.getTsName())
                    .tsCat(entity.getTsCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) touristSpotEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }
//
//    //카테고리(액티비티)별 리스트 조회
    public Header<List<TouristSpotDto>> getActivityList(Pageable pageable, SearchCondition searchCondition){
        List<TouristSpotDto> list = new ArrayList<>();

        Page<TouristSpotEntity> touristSpotEntities = touristSpotRepositoryCustom.findAllByCategoryIsAndNameLikeActivity(pageable, searchCondition);
        for (TouristSpotEntity entity : touristSpotEntities) {
            TouristSpotDto dto = TouristSpotDto.builder()
                    .tsNo(entity.getTsNo())
                    .tsName(entity.getTsName())
                    .tsCat(entity.getTsCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) touristSpotEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }
//
//    //카테고리(캠핑)별 리스트 조회
    public Header<List<TouristSpotDto>> getCampingList(Pageable pageable, SearchCondition searchCondition){
        List<TouristSpotDto> list = new ArrayList<>();

        Page<TouristSpotEntity> touristSpotEntities = touristSpotRepositoryCustom.findAllByCategoryIsAndNameLikeCamping(pageable, searchCondition);
        for (TouristSpotEntity entity : touristSpotEntities) {
            TouristSpotDto dto = TouristSpotDto.builder()
                    .tsNo(entity.getTsNo())
                    .tsName(entity.getTsName())
                    .tsCat(entity.getTsCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) touristSpotEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }
//
//    //카테고리(박물관)별 리스트 조회
    public Header<List<TouristSpotDto>> getMuseumList(Pageable pageable, SearchCondition searchCondition){
            List<TouristSpotDto> list = new ArrayList<>();

            Page<TouristSpotEntity> touristSpotEntities = touristSpotRepositoryCustom.findAllByCategoryIsAndNameLikeMuseum(pageable, searchCondition);
            for (TouristSpotEntity entity : touristSpotEntities) {
                TouristSpotDto dto = TouristSpotDto.builder()
                        .tsNo(entity.getTsNo())
                        .tsName(entity.getTsName())
                        .tsCat(entity.getTsCat())
                        .address(entity.getAddress())
                        .address2(entity.getAddress2())
                        .phone(entity.getPhone())
                        .latitude(entity.getLatitude())
                        .longitude(entity.getLongitude())
                        .build();

                list.add(dto);
            }

            Pagination pagination = new Pagination(
                    (int) touristSpotEntities.getTotalElements()
                    , pageable.getPageNumber() + 1
                    , pageable.getPageSize()
                    , 10
            );

            return Header.OK(list, pagination);
    }
//
//    //카테고리(미술관)별 리스트 조회
    public Header<List<TouristSpotDto>> getGalleryList(Pageable pageable, SearchCondition searchCondition){
        List<TouristSpotDto> list = new ArrayList<>();

        Page<TouristSpotEntity> touristSpotEntities = touristSpotRepositoryCustom.findAllByCategoryIsAndNameLikeGallery(pageable, searchCondition);
        for (TouristSpotEntity entity : touristSpotEntities) {
            TouristSpotDto dto = TouristSpotDto.builder()
                    .tsNo(entity.getTsNo())
                    .tsName(entity.getTsName())
                    .tsCat(entity.getTsCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) touristSpotEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }
//
//    //등록
//    public TouristSpotEntity create(TouristSpotDto touristSpotDto){
//        TouristSpotEntity entity = TouristSpotEntity.builder().build();
//
//        return touristSpotRepository.save(entity);
//    }
//
//    //수정
//    public TouristSpotEntity update(TouristSpotDto touristSpotDto) {
//        TouristSpotEntity entity = TouristSpotEntity.builder().build();
//
//        return touristSpotRepository.save(entity);
//    }
//
//    //삭제
//    public void delete (Long ts_no){}
//


}

