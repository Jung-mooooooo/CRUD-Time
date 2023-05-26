package com.crud.btt.map.model.service;

import com.crud.btt.common.CustomPageable;
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
    public Header<List<TouristSpotDto>> getTouristSpotList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
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
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
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
    public Header<List<TouristSpotDto>> getSeaList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
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
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        return Header.OK(list, pagination);
    }
//
//    //카테고리(공원)별 리스트 조회
    public Header<List<TouristSpotDto>> getParkList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
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
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        return Header.OK(list, pagination);
    }
//
//    //카테고리(휴양림)별 리스트 조회
    public Header<List<TouristSpotDto>> getForestList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
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
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        return Header.OK(list, pagination);
    }
//
//    //카테고리(액티비티)별 리스트 조회
    public Header<List<TouristSpotDto>> getActivityList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
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
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        return Header.OK(list, pagination);
    }
//
//    //카테고리(캠핑)별 리스트 조회
    public Header<List<TouristSpotDto>> getCampingList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
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
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        return Header.OK(list, pagination);
    }
//
//    //카테고리(박물관)별 리스트 조회
    public Header<List<TouristSpotDto>> getMuseumList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
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
                    , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                    , pageable.getPageSize() +1
                    , 10
            );

            return Header.OK(list, pagination);
    }
//
//    //카테고리(미술관)별 리스트 조회
    public Header<List<TouristSpotDto>> getGalleryList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
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
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        return Header.OK(list, pagination);
    }

    //등록
    public TouristSpotEntity create(TouristSpotDto touristSpotDto){
        TouristSpotEntity entity = TouristSpotEntity.builder()
                .tsNo(touristSpotDto.getTsNo())
                .tsName(touristSpotDto.getTsName())
                .tsCat(touristSpotDto.getTsCat())
                .address(touristSpotDto.getAddress())
                .address2(touristSpotDto.getAddress2())
                .phone(touristSpotDto.getPhone())
                .latitude(touristSpotDto.getLatitude())
                .longitude(touristSpotDto.getLongitude())
                .build();

        return touristSpotRepository.save(entity);
    }

    //수정
    public List<TouristSpotEntity> update(List<TouristSpotEntity> touristSpotDtoList) {
        List<TouristSpotEntity> updatedEntities = new ArrayList<>();

        for(TouristSpotEntity touristSpotDto : touristSpotDtoList){
            TouristSpotEntity entity = touristSpotRepository.findBytsNo(touristSpotDto.getTsNo());
            entity.setTsNo(touristSpotDto.getTsNo());
            entity.setTsName(touristSpotDto.getTsName());
            entity.setTsCat(touristSpotDto.getTsCat());
            entity.setAddress(touristSpotDto.getAddress());
            entity.setAddress2(touristSpotDto.getAddress2());
            entity.setPhone(touristSpotDto.getPhone());
            entity.setLatitude(touristSpotDto.getLatitude());
            entity.setLongitude(touristSpotDto.getLongitude());
            updatedEntities.add(touristSpotRepository.save(entity));
        }
        return updatedEntities;
    }

    //삭제
    public void delete (Long tsNo){
        TouristSpotEntity entity = touristSpotRepository.findById(tsNo).orElseThrow(() -> new RuntimeException("해당 업체를 찾을 수 없습니다."));
        touristSpotRepository.delete(entity);
    }



}

