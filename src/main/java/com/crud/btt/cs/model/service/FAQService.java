package com.crud.btt.cs.model.service;

import com.crud.btt.cs.entity.FAQEntity;
import com.crud.btt.cs.entity.FAQRepository;
import com.crud.btt.cs.model.dto.FAQDto;
import com.crud.btt.cs.model.dto.FAQUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
@RequiredArgsConstructor
@Service
public class FAQService {

    @Autowired
    FAQRepository faqRepository;
    //FAQRepositoryCustom faqRepositoryCustom;

    //목록보기
//    public Header<List<FAQDto>> getFAQList(Pageable pageable, SearchCondition searchCondition) {
//        List<FAQDto> dtos = new ArrayList<>();
//
//        Page<FAQEntity> faqEntities =
//                faqRepositoryCustom.findAllBySearchCondition(
//                        pageable, searchCondition);
//        for (FAQEntity entity : faqEntities) {
//            FAQDto dto = FAQDto.builder()
//                    .faq_no(entity.getFaq_no())
//                    .create_at(entity.getCreate_at())
//                    .faq_title(entity.getFaq_title())
//                    .faq_content(entity.getFaq_content())
//                    .faq_readcount(entity.getFaq_readcount())
//                    .admin_code(entity.getAdmin_code())
//                    .build();
//
//            dtos.add(dto);
//        }
//
//        Pagination pagination = new Pagination(
//                (int) faqEntities.getTotalElements()
//                , pageable.getPageNumber() + 1
//                , pageable.getPageSize()
//                , 10
//        );
//
//        return Header.OK(dtos, pagination);
//    }

    // 상세보기
    public FAQDto getFAQ(Long faqNo) {

        // update set count = count +1;
        FAQEntity faqEntity = faqRepository.findById(faqNo).get();

        faqEntity.setFaqReadCount(faqEntity.getFaqReadCount()+1);

        return new FAQDto(faqRepository.save(faqEntity));
    }

    public FAQDto faqCreate(FAQDto faqDto){

        FAQEntity faqEntity = FAQEntity.builder()
                .faqTitle(faqDto.getFaq_title())
                .faqContent(faqDto.getFaq_content())
                .createAt(faqDto.getCreate_at())
                .faqReadCount(faqDto.getFaq_readcount())
                .build();

        faqEntity = faqRepository.save(faqEntity);
        // return new FAQDto(faqRepository.save(new FAQEntity(faqDto)));
        return FAQDto.builder()
                .faq_no(faqEntity.getFaqNo())
                .faq_title(faqEntity.getFaqTitle())
                .faq_content(faqEntity.getFaqContent())
                .create_at(faqEntity.getCreateAt())
                .faq_readcount(faqEntity.getFaqReadCount())
                .build();
    }

    //수정
    public FAQUpdateDto faqUpdate(FAQUpdateDto faqUpdateDto){

        if(faqRepository.findByFaqNo(faqUpdateDto.getFaq_no()) == null){
            return new FAQUpdateDto("F");
        }

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

        FAQEntity faqEntity = FAQEntity.builder().faqNo(faqUpdateDto.getFaq_no())
                .faqTitle(faqUpdateDto.getFaq_title())
                .faqContent(faqUpdateDto.getFaq_content())
                .createAt(now)
                .build();

        return new FAQUpdateDto(faqRepository.save(faqEntity));
    }

    //삭제 (삭제는 반환타입이 Long, 값은 삭제된 행 )
    public Long faqDelete(Long faq_no){
        return faqRepository.deleteByFaqNo(faq_no);
    }


}
