package com.crud.btt.map.model.service;

import com.crud.btt.common.Header;
import com.crud.btt.common.Pagination;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.map.entity.HobbyEntity;
import com.crud.btt.map.entity.HobbyRepository;
import com.crud.btt.map.model.dto.HobbyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.crud.btt.common.Header;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class HobbyService {
    private final HobbyRepository hobbyRepository;

    //지도 목록 조회(페이징 처리)
    public Header<List<HobbyDto>> getHobbyList(Pageable pageable, SearchCondition searchCondition){
        List<HobbyDto> list = new ArrayList<>();

        Page<HobbyEntity> hobbyEntities = hobbyRepository.findAllBySearchCondition(pageable, searchCondition);
        for (HobbyEntity entity : hobbyEntities) {
            HobbyDto dto = HobbyDto.builder()
                    .hobby_no(entity.getHobby_no())
                    .hobby_name(entity.getHobby_name())
                    .hobby_cat(entity.getHobby_cat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .logitude(entity.getLogitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) hobbyEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }


    //카테고리(음악)별 리스트 조회
    public Header<List<HobbyDto>> getMusicList(Pageable pageable, SearchCondition searchCondition){
        List<HobbyDto> list = new ArrayList<>();

        Page<HobbyEntity> hobbyEntities = hobbyRepository.findAllBySearchCondition(pageable, searchCondition);
        for (HobbyEntity entity : hobbyEntities) {
            HobbyDto dto = HobbyDto.builder()
                    .hobby_no(entity.getHobby_no())
                    .hobby_name(entity.getHobby_name())
                    .hobby_cat(entity.getHobby_cat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .logitude(entity.getLogitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) hobbyEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }

    //카테고리(미술)별 리스트 조회
    public Header<List<HobbyDto>> getArtList(Pageable pageable, SearchCondition searchCondition){
        List<HobbyDto> list = new ArrayList<>();

        Page<HobbyEntity> hobbyEntities = hobbyRepository.findAllBySearchCondition(pageable, searchCondition);
        for (HobbyEntity entity : hobbyEntities) {
            HobbyDto dto = HobbyDto.builder()
                    .hobby_no(entity.getHobby_no())
                    .hobby_name(entity.getHobby_name())
                    .hobby_cat(entity.getHobby_cat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .logitude(entity.getLogitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) hobbyEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }

    //카테고리(무용)별 리스트 조회
    public Header<List<HobbyDto>> getDanceList(Pageable pageable, SearchCondition searchCondition){
        List<HobbyDto> list = new ArrayList<>();

        Page<HobbyEntity> hobbyEntities = hobbyRepository.findAllBySearchCondition(pageable, searchCondition);
        for (HobbyEntity entity : hobbyEntities) {
            HobbyDto dto = HobbyDto.builder()
                    .hobby_no(entity.getHobby_no())
                    .hobby_name(entity.getHobby_name())
                    .hobby_cat(entity.getHobby_cat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .logitude(entity.getLogitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) hobbyEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }

    //카테고리(언어)별 리스트 조회
    public Header<List<HobbyDto>> getLanguageList(Pageable pageable, SearchCondition searchCondition){
        List<HobbyDto> list = new ArrayList<>();

        Page<HobbyEntity> hobbyEntities = hobbyRepository.findAllBySearchCondition(pageable, searchCondition);
        for (HobbyEntity entity : hobbyEntities) {
            HobbyDto dto = HobbyDto.builder()
                    .hobby_no(entity.getHobby_no())
                    .hobby_name(entity.getHobby_name())
                    .hobby_cat(entity.getHobby_cat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .logitude(entity.getLogitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) hobbyEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }

    //카테고리(미디어)별 리스트 조회
    public Header<List<HobbyDto>> getMediaList(Pageable pageable, SearchCondition searchCondition){
        List<HobbyDto> list = new ArrayList<>();

        Page<HobbyEntity> hobbyEntities = hobbyRepository.findAllBySearchCondition(pageable, searchCondition);
        for (HobbyEntity entity : hobbyEntities) {
            HobbyDto dto = HobbyDto.builder()
                    .hobby_no(entity.getHobby_no())
                    .hobby_name(entity.getHobby_name())
                    .hobby_cat(entity.getHobby_cat())
                    .address(entity.getAddress())
                    .address2(entity.getAddress2())
                    .phone(entity.getPhone())
                    .latitude(entity.getLatitude())
                    .logitude(entity.getLogitude())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) hobbyEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }


    //등록
    public HobbyEntity create(HobbyDto hobbyDto){
        HobbyEntity entity = HobbyEntity.builder().build();

        return hobbyRepository.save(entity);
    }

    //수정
    public HobbyEntity update(HobbyDto hobbyDto){
        HobbyEntity entity = HobbyEntity.builder().build();

        return hobbyRepository.save(entity);
    }

    //삭제
    public void delete(Long hobby_no){}

}
