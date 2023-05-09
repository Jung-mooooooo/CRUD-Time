package com.crud.btt.cs.model.service;

import com.crud.btt.common.Header;
import com.crud.btt.common.Pagination;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.entity.FAQEntity;
import com.crud.btt.cs.entity.FAQRepository;
import com.crud.btt.cs.entity.FAQRepositoryCustom;
import com.crud.btt.cs.model.dto.FAQDto;
import com.crud.btt.cs.model.dto.FAQUpdateDto;
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
public class FAQService {

    @Autowired
    FAQRepository faqRepository;
    FAQRepositoryCustom faqRepositoryCustom;

    public Header<List<FAQDto>> getFAQList(Pageable pageable, SearchCondition searchCondition) {
        List<FAQDto> dtos = new ArrayList<>();

        Page<FAQEntity> faqEntities =
                faqRepositoryCustom.findAllBySearchCondition(
                        pageable, searchCondition);
        for (FAQEntity entity : faqEntities) {
            FAQDto dto = FAQDto.builder()
                    .faq_no(entity.getFaq_no())
                    .create_at(entity.getCreate_at())
                    .faq_title(entity.getFaq_title())
                    .faq_content(entity.getFaq_content())
                    .faq_readcount(entity.getFaq_readcount())
                    .admin_code(entity.getAdmin_code())
                    .build();

            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) faqEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(dtos, pagination);
    }

    // 상세보기
    public FAQDto getFAQ(Long faqNo) {

        // update set count = count +1;
        FAQEntity faqEntity = faqRepository.findById(faqNo).get();

        faqEntity.setFaq_readcount(faqEntity.getFaq_readcount()+1);

        return new FAQDto(faqRepository.save(faqEntity));
    }

    public FAQDto faqCreate(FAQDto faqDto){

        FAQEntity faqEntity = FAQEntity.builder()
                .faq_title(faqDto.getFaq_title())
                .faq_content(faqDto.getFaq_content())
                .create_at(faqDto.getCreate_at())
                .faq_readcount(faqDto.getFaq_readcount())
                .build();

        faqEntity = faqRepository.save(faqEntity);
        // return new FAQDto(faqRepository.save(new FAQEntity(faqDto)));
        return FAQDto.builder()
                .faq_no(faqEntity.getFaq_no())
                .faq_title(faqEntity.getFaq_title())
                .faq_content(faqEntity.getFaq_content())
                .create_at(faqEntity.getCreate_at())
                .faq_readcount(faqEntity.getFaq_readcount())
                .build();
    }

    //수정
    public FAQUpdateDto faqUpdate(FAQUpdateDto faqUpdateDto){

        if(faqRepository.findByFAQNo(faqUpdateDto.getFaq_no()) == null){
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

        FAQEntity faqEntity = FAQEntity.builder().faq_no(faqUpdateDto.getFaq_no())
                .faq_title(faqUpdateDto.getFaq_title())
                .faq_content(faqUpdateDto.getFaq_content())
                .create_at(now)
                .build();

        return new FAQUpdateDto(faqRepository.save(faqEntity));
    }

    //삭제 (삭제는 반환타입이 Long, 값은 삭제된 행 )
    public Long faqDelete(Long faq_no){
        return faqRepository.deleteByFAQNo(faq_no);
    }


}
