package com.crud.btt.cs.model.service;

import com.crud.btt.common.Header;
import com.crud.btt.common.Pagination;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.entity.NoticeEntity;
import com.crud.btt.cs.entity.NoticeRepository;
//import com.crud.btt.cs.entity.NoticeRepositoryCustom;
import com.crud.btt.cs.model.dto.NoticeDto;
import com.crud.btt.cs.model.dto.NoticeUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoticeService {

    @Autowired
    NoticeRepository noticeRepository;
    //NoticeRepositoryCustom noticeRepositoryCustom;

    //목록보기
//    public Header<List<NoticeDto>> getNoticeList(Pageable pageable, SearchCondition searchCondition) {
//        List<NoticeDto> dtos = new ArrayList<>();
//
//        Page<NoticeEntity> noticeEntities =
//                noticeRepositoryCustom.findAllBySearchCondition(
//                        pageable, searchCondition);
//        for (NoticeEntity entity : noticeEntities) {
//            NoticeDto dto = NoticeDto.builder()
//                    .notice_no(entity.getNotice_no())
//                    .create_at(entity.getCreate_at())
//                    .notice_title(entity.getNotice_title())
//                    .notice_content(entity.getNotice_content())
//                    .notice_readcount(entity.getNotice_readcount())
//                    .admin_code(entity.getAdmin_code())
//                    .notice_original_file(entity.getNotice_original_file())
//                    .notice_rename_file(entity.getNotice_rename_file())
//                    .build();
//
//            dtos.add(dto);
//        }
//
//        Pagination pagination = new Pagination(
//                (int) noticeEntities.getTotalElements()
//                , pageable.getPageNumber() + 1
//                , pageable.getPageSize()
//                , 10
//        );
//
//        /*
//        Page<NoticeEntity> noticeEntities1 = null;
//        if(searchCondition.getSv().length() > 0){
//            noticeEntities1 = noticeRepository.findByNoticeTitleOrNoticeContent(searchCondition.getSv());
//        } else {
//            noticeEntities1 = noticeRepository.findAll(pageable);
//        }
//        */
//        return Header.OK(dtos, pagination);
//    }

    // 상세보기
    public NoticeDto getNotice(Long noticeNo) {

        // update set count = count +1;
        NoticeEntity noticeEntity = noticeRepository.findById(noticeNo).get();
        /*
            글제목 : 제목입니다.
            조회수 : 1
            글내용 : 내용입니다.
        */
        noticeEntity.setNoticeReadCount(noticeEntity.getNoticeReadCount()+1);
        /*
            글제목 : 제목입니다.
            조회수 : 2            // setNotice_readcount(noticeEntity.getNotice_readcount() + 1 )
            글내용 : 내용입니다.                                    = 1
        */

        return new NoticeDto(noticeRepository.save(noticeEntity));
    }
            
    // 글작성
    // 1. 컨트롤러에서 Dto를 받아온다.
    // 2. Entity <- Dto, Entity를 Repository.save() 디비에 인서트를 한다.
    // 3. Dto <- Entity
    // 4. 컨트롤러로 Dto 리턴
    public NoticeDto noticeCreate(NoticeDto noticeDto){
        // noticeEntity <= noticeDto
        /*
        noticeEntity = noticeDto.getNotice_no(); // 안해도 됨
        noticeEntity.setNotice_title(noticeDto.getNotice_title());
        noticeEntity.setNotice_content(noticeDto.getNotice_content());
        noticeEntity.setCreate_at(noticeDto.getCreate_at());
        noticeEntity.setNotice_original_file(noticeDto.getNotice_original_file());
        noticeEntity.setNotice_rename_file(noticeDto.getNotice_rename_file());
        */

        NoticeEntity noticeEntity = NoticeEntity.builder()
                .noticeTitle(noticeDto.getNotice_title())
                .noticeContent(noticeDto.getNotice_content())
                .createAt(noticeDto.getCreate_at())
                .noticeReadCount(noticeDto.getNotice_readcount())
                .noticeOriginalFile(noticeDto.getNotice_original_file())
                .noticeRenameFile(noticeDto.getNotice_rename_file()).build();

        noticeEntity = noticeRepository.save(noticeEntity);
        // return new NoticeDto(noticeRepository.save(new NoticeEntity(noticeDto)));
      return NoticeDto.builder()
              .notice_no(noticeEntity.getNoticeNo())
              .notice_title(noticeEntity.getNoticeTitle())
              .notice_content(noticeEntity.getNoticeContent())
              .create_at(noticeEntity.getCreateAt())
              .notice_readcount(noticeEntity.getNoticeReadCount())
              .notice_original_file(noticeEntity.getNoticeOriginalFile())
              .notice_rename_file(noticeEntity.getNoticeRenameFile())
              .build();
    }

    //수정
    public NoticeUpdateDto noticeUpdate(NoticeUpdateDto noticeUpdateDto){

        if(noticeRepository.findByNoticeNo(noticeUpdateDto.getNotice_no()) == null){
            return new NoticeUpdateDto("F");
        }
        /*
        if(noticeRepository.findByNoticeNo(noticeUpdateDto.getNotice_no()) == null){
            return new RuntimeException("Notice not found");
        }
        */

        TimeZone timeZone = TimeZone.getTimeZone("GMT+9");
        Date now = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        formatter.setTimeZone(timeZone);
        String formattedDate = formatter.format(now);

        try {
            now = formatter.parse(formattedDate);
        } catch( ParseException e ){
            e.printStackTrace();
        } catch( Exception e ){
            e.printStackTrace();
        }

        NoticeEntity noticeEntity = NoticeEntity.builder().noticeNo(noticeUpdateDto.getNotice_no())
                .noticeTitle(noticeUpdateDto.getNotice_title())
                .noticeContent(noticeUpdateDto.getNotice_content())
                .createAt(now)
                .noticeOriginalFile(noticeUpdateDto.getNotice_original_file())
                .noticeRenameFile(noticeUpdateDto.getNotice_rename_file())
                .build();
        /*
        NoticeEntity noticeEntity1 = noticeRepository.findByNoticeNo(noticeUpdateDto.getNotice_no());
        noticeEntity1.setNotice_title(noticeUpdateDto.getNotice_title());
        noticeEntity1.setNotice_content(noticeUpdateDto.getNotice_content());
        noticeRepository.save(noticeEntity1);
        */

       return new NoticeUpdateDto(noticeRepository.save(noticeEntity));
    }

    //삭제 (삭제는 반환타입이 Long, 값은 삭제된 행 )
    public Long noticeDelete(Long notice_no){
        /*
            JPA - ORM ( Object.. ) 객체형 디비관리
            Mybatis - SQL 직접.
        */

        // NoticeEntity noticeEntity = new NoticeEntity();
        // noticeRepository.delete(noticeEntity.setNotice_no(notice_no));

        return noticeRepository.deleteByNoticeNo(notice_no);

    }



}
