package com.crud.btt.map.model.service;

import com.crud.btt.common.CustomPageable;
import com.crud.btt.common.Header;
import com.crud.btt.common.Pagination;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.map.entity.HobbyEntity;
import com.crud.btt.map.entity.HobbyRepository;
import com.crud.btt.map.entity.HobbyRepositoryCustom;
import com.crud.btt.map.model.dto.HobbyDto;
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
public class HobbyService {
    private final HobbyRepository hobbyRepository;
    private final HobbyRepositoryCustom hobbyRepositoryCustom;

    //지도 목록 조회(페이징 처리)
    public Header<List<HobbyDto>> getHobbyList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
        List<HobbyDto> list = new ArrayList<>();

        Page<HobbyEntity> hobbyEntities = hobbyRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (HobbyEntity entity : hobbyEntities) {
            HobbyDto dto = HobbyDto.builder()
                    .hobbyNo(entity.getHobbyNo())
                    .hobbyName(entity.getHobbyName())
                    .hobbyCat(entity.getHobbyCat())

                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) hobbyEntities.getTotalElements()
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        return Header.OK(list, pagination);
    }

//    //카테고리별 키워드 검색
//    public Header<List<HobbyDto>> getSearchList(Pageable pageable, SearchCondition searchCondition) {
//        return null;
//    }
//
//
    //카테고리(음악)별 리스트 조회
    public Header<List<HobbyDto>> getMusicList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
        List<HobbyDto> list = new ArrayList<>();

        Page<HobbyEntity> hobbyEntities = hobbyRepositoryCustom.findAllByCategoryIsAndNameLikeMusic(pageable, searchCondition);
        for (HobbyEntity entity : hobbyEntities) {
            HobbyDto dto = HobbyDto.builder()
                    .hobbyNo(entity.getHobbyNo())
                    .hobbyName(entity.getHobbyName())
                    .hobbyCat(entity.getHobbyCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) hobbyEntities.getTotalElements()
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        return Header.OK(list, pagination);
    }

    //카테고리(미술)별 리스트 조회
    public Header<List<HobbyDto>> getArtList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
        List<HobbyDto> list = new ArrayList<>();

        Page<HobbyEntity> hobbyEntities = hobbyRepositoryCustom.findAllByCategoryIsAndNameLikeArt(pageable, searchCondition);
        for (HobbyEntity entity : hobbyEntities) {
            HobbyDto dto = HobbyDto.builder()
                    .hobbyNo(entity.getHobbyNo())
                    .hobbyName(entity.getHobbyName())
                    .hobbyCat(entity.getHobbyCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) hobbyEntities.getTotalElements()
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        return Header.OK(list, pagination);
    }

    //카테고리(무용)별 리스트 조회
    public Header<List<HobbyDto>> getDanceList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
        List<HobbyDto> list = new ArrayList<>();

        Page<HobbyEntity> hobbyEntities = hobbyRepositoryCustom.findAllByCategoryIsAndNameLikeDance(pageable, searchCondition);
        for (HobbyEntity entity : hobbyEntities) {
            HobbyDto dto = HobbyDto.builder()
                    .hobbyNo(entity.getHobbyNo())
                    .hobbyName(entity.getHobbyName())
                    .hobbyCat(entity.getHobbyCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) hobbyEntities.getTotalElements()
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        return Header.OK(list, pagination);
    }

    //카테고리(언어)별 리스트 조회
    public Header<List<HobbyDto>> getLanguageList(Pageable page, SearchCondition searchCondition){
        CustomPageable pageable = new CustomPageable(page);
        List<HobbyDto> list = new ArrayList<>();

        Page<HobbyEntity> hobbyEntities = hobbyRepositoryCustom.findAllByCategoryIsAndNameLikeLanguage(pageable, searchCondition);
        for (HobbyEntity entity : hobbyEntities) {
            HobbyDto dto = HobbyDto.builder()
                    .hobbyNo(entity.getHobbyNo())
                    .hobbyName(entity.getHobbyName())
                    .hobbyCat(entity.getHobbyCat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .longitude(entity.getLongitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) hobbyEntities.getTotalElements()
                , pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );

        return Header.OK(list, pagination);
    }



    //등록
    public HobbyEntity create(HobbyDto hobbyDto){
        HobbyEntity entity = HobbyEntity.builder()
                .hobbyNo(hobbyDto.getHobbyNo())
                .hobbyName(hobbyDto.getHobbyName())
                .hobbyCat(hobbyDto.getHobbyCat())
                .address(hobbyDto.getAddress())
                .address2(hobbyDto.getAddress2())
                .phone(hobbyDto.getPhone())
                .latitude(hobbyDto.getLatitude())
                .longitude(hobbyDto.getLongitude())
                .build();

        return hobbyRepository.save(entity);
    }

    //수정
    public List<HobbyEntity> update(List<HobbyEntity> hobbyDtoList){
        List<HobbyEntity> updatedEntities = new ArrayList<>();

        for(HobbyEntity hobbyDto : hobbyDtoList){
            HobbyEntity entity = hobbyRepository.findByhobbyNo(hobbyDto.getHobbyNo());
            entity.setHobbyNo(hobbyDto.getHobbyNo());
            entity.setHobbyName(hobbyDto.getHobbyName());
            entity.setHobbyCat(hobbyDto.getHobbyCat());
            entity.setAddress(hobbyDto.getAddress());
            entity.setAddress2(hobbyDto.getAddress2());
            entity.setPhone(hobbyDto.getPhone());
            entity.setLatitude(hobbyDto.getLatitude());
            entity.setLongitude(hobbyDto.getLongitude());
            updatedEntities.add(hobbyRepository.save(entity));
        }
        return updatedEntities;
    }

    //삭제
    public void delete(Long hobbyNo){
        HobbyEntity entity = hobbyRepository.findById(hobbyNo).orElseThrow(() -> new RuntimeException("해당 업체를 찾을 수 없습니다."));
        hobbyRepository.delete(entity);
    }

}
