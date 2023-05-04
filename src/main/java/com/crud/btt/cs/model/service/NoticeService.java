package com.crud.btt.cs.model.service;

import com.crud.btt.common.Header;
import com.crud.btt.common.Pagination;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.entity.NoticeEntity;
import com.crud.btt.cs.model.dto.NoticeDto;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class NoticeService {

//    public Header<List<NoticeDto>> getBoardList(Pageable pageable, SearchCondition searchCondition) {
//        List<NoticeDto> dtos = new ArrayList<>();
//
//        Page<NoticeEntity> noticeEntities =
//                boardRepositoryCustom.findAllBySearchCondition(
//                        pageable, searchCondition);
//        for (NoticeEntity entity : noticeEntities) {
//            NoticeDto dto = BoardDto.builder()
//                    .idx(entity.getIdx())
//                    .author(entity.getAuthor())
//                    .title(entity.getTitle())
//                    .contents(entity.getContents())
//                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
//                    .build();
//
//
//            dtos.add(dto);
//        }
//
//
//
//        Pagination pagination = new Pagination(
//                (int) boardEntities.getTotalElements()
//                , pageable.getPageNumber() + 1
//                , pageable.getPageSize()
//                , 10
//        );
//
//
//        return Header.OK(dtos, pagination);
//    }





}
