package com.crud.btt.cs.model.service;

import com.crud.btt.common.Header;
import com.crud.btt.common.Pagination;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.entity.QnAEntity;
import com.crud.btt.cs.entity.QnARepository;
import com.crud.btt.cs.entity.QnARepositoryCustom;
import com.crud.btt.cs.model.dto.QnADto;
import com.crud.btt.cs.model.dto.QnAListDto;
import com.crud.btt.cs.model.dto.QnAUpdateDto;
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
public class QnAService {
    @Autowired
    QnARepository qnaRepository;
    QnARepositoryCustom qnaRepositoryCustom;
    public Header<List<QnAListDto>> getQnAList(Pageable pageable, SearchCondition searchCondition) {
        List<QnADto> dtos = new ArrayList<>();
        /*
        Page<QnAEntity> qnaEntities =
                qnaRepositoryCustom.findAllBySearchCondition(
                        pageable, searchCondition);
        */

        // 결과 리스트 담을 객체
        // QnAListDto랑 QnADto는 다른 클래스(다른 객체임)
        List<QnAListDto> resultList = null;

        // 질문글만 전체 가져왔음
        List<QnAEntity> qList = qnaRepository.findSameBtwTwoColumn();

        // 질문글을 하나씩 꺼내서 Loop ( for )
        for(QnAEntity entity : qList){
            QnAEntity AnswerEntity = qnaRepository.findByRefNo(entity.getQna_no());
            // 질문글의 질문글의 흐름이 있음, 질문글은 무조건 결과리스트에 포함
            // 답변글의 답변글의 흐름이 있음, 답변글은 있어야지만 결과리스트에 포함
            QnAListDto qnAListQuestion = new QnAListDto(entity);
            resultList.add(qnAListQuestion);
            // resultList.add(new QnAListDto(entity));
            if(AnswerEntity != null){
                QnAListDto qnAListAnswer = new QnAListDto(AnswerEntity);
                resultList.add(qnAListAnswer);
                // resultList.add(new QnAListDto(AnswerEntity));
            }
        }

        Pagination pagination = new Pagination(
                resultList.size()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(resultList, pagination);
    }

    // 상세보기
    public QnADto getQnA(Long qnaNo) {

        // update set count = count +1;
        QnAEntity qnaEntity = qnaRepository.findById(qnaNo).get();
//        if(qnaEntity.getQna_private() != "Y" && 작성자 != 유저
//            || 공개 != "Y" && 관리자 != 유저){
//            return null;
//        }
        qnaEntity.setQna_readcount(qnaEntity.getQna_readcount()+1);
        return new QnADto(qnaRepository.save(qnaEntity));
    }

    public QnADto qnaCreate(QnADto qnaDto){

        QnAEntity qnaEntity = QnAEntity.builder()
                .qna_title(qnaDto.getQna_title())
                .qna_content(qnaDto.getQna_content())
                .create_at(qnaDto.getCreate_at())
                .qna_readcount(qnaDto.getQna_readcount())
                .qna_original_file(qnaDto.getQna_original_file())
                .qna_rename_file(qnaDto.getQna_rename_file()).build();

        qnaEntity = qnaRepository.save(qnaEntity);
        return QnADto.builder()
                .qna_no(qnaEntity.getQna_no())
                .qna_title(qnaEntity.getQna_title())
                .qna_content(qnaEntity.getQna_content())
                .create_at(qnaEntity.getCreate_at())
                .qna_readcount(qnaEntity.getQna_readcount())
                .qna_original_file(qnaEntity.getQna_original_file())
                .qna_rename_file(qnaEntity.getQna_rename_file())
                .build();
    }

    //수정
    public QnAUpdateDto qnaUpdate(QnAUpdateDto qnaUpdateDto){

        if(qnaRepository.findByQnANo(qnaUpdateDto.getQna_no()) == null){
            return new QnAUpdateDto("F");
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

        QnAEntity qnaEntity = QnAEntity.builder().qna_no(qnaUpdateDto.getQna_no())
                .qna_title(qnaUpdateDto.getQna_title())
                .qna_content(qnaUpdateDto.getQna_content())
                .create_at(now)
                .qna_original_file(qnaUpdateDto.getQna_original_file())
                .qna_rename_file(qnaUpdateDto.getQna_rename_file())
                .build();

        return new QnAUpdateDto(qnaRepository.save(qnaEntity));
    }

    //삭제 (삭제는 반환타입이 Long, 값은 삭제된 행 )
    public Long qnaDelete(Long qna_no){

        return qnaRepository.deleteByQnANo(qna_no);

    }

}
