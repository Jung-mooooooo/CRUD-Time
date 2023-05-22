package com.crud.btt.cs.model.service;

import com.crud.btt.common.Header;
import com.crud.btt.common.Pagination;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.controller.QnAController;
import com.crud.btt.cs.entity.QnAEntity;
import com.crud.btt.cs.entity.QnARepository;
import com.crud.btt.cs.entity.QnARepositoryCustom;
import com.crud.btt.cs.model.dto.QnAListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class QnAService {

    private final  QnARepository qnARepository;
    private final QnARepositoryCustom qnARepositoryCustom;
    private static final Logger logger = LoggerFactory.getLogger(QnAController.class);

    //목록보기
    public Header<List<QnAListDto>> getQnAList(Pageable pageable, SearchCondition searchCondition) {

        // 결과 리스트 담을 객체
        // QnAListDto랑 QnADto는 다른 클래스(다른 객체임)
        List<QnAListDto> resultList = new ArrayList<>();

        // 질문글만 전체 가져왔음(qnaNO == qnaRef)
        List<QnAEntity> qList = qnARepository.findSameBtwTwoColumn();

        // 질문글을 하나씩 꺼내서 Loop ( for )
        for(QnAEntity entity : qList){
            logger.info("=============entity=============" + entity);
            QnAEntity answerEntity = qnARepository.findByQnaRef(entity.getQnaNo());
            // 질문글의 질문글의 흐름이 있음, 질문글은 무조건 결과리스트에 포함
            // 답변글의 답변글의 흐름이 있음, 답변글은 있어야지만 결과리스트에 포함
            QnAListDto qnaQuestion = new QnAListDto(entity);
            resultList.add(qnaQuestion);
            // resultList.add(new QnAListDto(entity));
            logger.info("=============resultList=============" + resultList);

            if(answerEntity != null){
                QnAListDto qnaAnswer = new QnAListDto(answerEntity);
                logger.info("=============qnAListAnswer=============" + qnaAnswer);
                resultList.add(qnaAnswer);
                // resultList.add(new QnAListDto(AnswerEntity));
            }
        }

        Pagination pagination = new Pagination(
                resultList.size()
                , pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );
        return Header.OK(resultList, pagination);
    }

    // 상세보기
//    public QnADto getQnA(Long qnaNo) {
//
//        // update set count = count +1;
//        QnAEntity qnaEntity = qnARepository.findById(qnaNo).get();
////        if(qnaEntity.getQna_private() != "Y" && 작성자 != 유저
////            || 공개 != "Y" && 관리자 != 유저){
////            return null;
////        }
//        qnaEntity.setQnaReadCount(qnaEntity.getQnaReadCount()+1);
//        return new QnADto(qnARepository.save(qnaEntity));
//    }
//
//    public QnADto qnaCreate(QnADto qnaDto){
//        TimeZone timeZone = TimeZone.getTimeZone("GMT+9");
//        Date now = new Date();
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
//        formatter.setTimeZone(timeZone);
//        String formattedDate = formatter.format(now);
//
//        try {
//            now = formatter.parse(formattedDate);
//        } catch( ParseException e ){
//            e.printStackTrace();
//        } catch( Exception e ){
//            e.printStackTrace();
//        }
//
//        /*
//            객체를 만들건데, 그냥 new 생성자() 로 만드는 경우가 있고,
//            아무데서나 가져올 수는 없으니, 그리고 Member 클래스로 Qna 만드는 기능을 만들었다면
//            Member.make() Qna 타입의 객체를만들수는 있는데,
//            그러면 너무 복잡 불필요하고 굳이?
//            Qna 클래스에 builder 메소드에 Qna 객체를 만드는 코드를 짜놓은거.
//        */
//        QnAEntity qnaEntity = QnAEntity.builder()
//                .qnaTitle(qnaDto.getQna_title())
//                .qnaContent(qnaDto.getQna_content())
//                .createAt(now)
//                .qnaReadCount(qnaDto.getQna_readcount())
//                .qnaOriginalFile(qnaDto.getQna_original_file())
//                .qnaRename_File(qnaDto.getQna_rename_file()).build();
//
//        /*
//            화면에서 qnaDto 를 받음.
//            질문글이라면 ref_no = ""             -> 커스텀한 saveQuestion()으로 처리
//            답변글이라면 ref_no = { 질문글번호 }   -> save()
//
//            화면에서 qnaDto필드에 맞춰 값을 보냄 -> 컨트롤러에서 매핑된 qnaDto 받음
//             -> 컨트롤러에서 서비스로 qnaDto 보냄 -> qnaCreate(QnADto qnaDto) 에서 DTO -> Entity 변환
//
//             ======= 질문글을 작성하는 경우 ======
//            받은 DTO : 질문입니다
//            DB에서 시퀀스로 글번호 만들거고, 참조번호는 쿼리문을 조금 수정해줘야함.
//
//             ======= 답변글을 작성하는 경우 ======
//            받은 DTO : 답변입니다 1
//            DB에서 시퀀스로 글번호를 만들꺼니까, 축약해놓은 글번호, 글제목, 참조번호 세가지 컬럼중에 더 채워넣을게 없음.
//
//        */
//        if(qnaEntity.getQnaRef() > 0){
//            qnaEntity = qnARepository.save(qnaEntity);
//        }else {
//            qnaEntity = qnARepository.saveQuestion(qnaEntity);
//        }
//
//        return QnADto.builder()
//                .qna_no(qnaEntity.getQnANo())
//                .qna_title(qnaEntity.getQnaTitle())
//                .qna_content(qnaEntity.getQnaContent())
//                .create_at(qnaEntity.getCreateAt())
//                .qna_readcount(qnaEntity.getQnaReadCount())
//                .qna_original_file(qnaEntity.getQnaOriginalFile())
//                .qna_rename_file(qnaEntity.getQnaRename_File())
//                .build();
//    }
//
//    //수정
//    public QnAUpdateDto qnaUpdate(QnAUpdateDto qnaUpdateDto){
//
//        if(qnARepository.findByQnANo(qnaUpdateDto.getQna_no()) == null){
//            return new QnAUpdateDto("F");
//        }
//
//        TimeZone timeZone = TimeZone.getTimeZone("GMT+9");
//        Date now = new Date();
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
//        formatter.setTimeZone(timeZone);
//        String formattedDate = formatter.format(now);
//
//        try {
//            now = formatter.parse(formattedDate);
//        } catch( ParseException e ){
//            e.printStackTrace();
//        } catch( Exception e ){
//            e.printStackTrace();
//        }
//
//        QnAEntity qnaEntity = QnAEntity.builder().qnANo(qnaUpdateDto.getQna_no())
//                .qnaTitle(qnaUpdateDto.getQna_title())
//                .qnaContent(qnaUpdateDto.getQna_content())
//                .createAt(now)
//                .qnaOriginalFile(qnaUpdateDto.getQna_original_file())
//                .qnaRename_File(qnaUpdateDto.getQna_rename_file())
//                .build();
//
//        return new QnAUpdateDto(qnARepository.save(qnaEntity));
//    }
//
//    //삭제 (삭제는 반환타입이 Long, 값은 삭제된 행 )
//    public Long qnaDelete(Long qna_no){
//
//        return qnARepository.deleteByQnANo(qna_no);
//
//    }

}
