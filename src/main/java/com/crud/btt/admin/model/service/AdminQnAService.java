package com.crud.btt.admin.model.service;

import com.crud.btt.admin.entity.AdminRepository;
import com.crud.btt.common.CustomPageable;
import com.crud.btt.common.Header;
import com.crud.btt.common.Pagination;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.cs.controller.QnAController;
import com.crud.btt.cs.entity.QnAEntity;
import com.crud.btt.cs.entity.QnARepository;
import com.crud.btt.cs.entity.QnARepositoryCustom;
import com.crud.btt.cs.model.dto.QnADto;
import com.crud.btt.cs.model.dto.QnAListDto;
import com.crud.btt.cs.model.dto.QnAUpdateDto;
import com.crud.btt.member.entity.MemberEntity;
import com.crud.btt.member.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminQnAService {

    private final  QnARepository qnARepository;
    private final MemberRepository memberRepository;
    private final AdminRepository adminRepository;
    private final QnARepositoryCustom qnARepositoryCustom;
    private final EntityManager entityManager;
    private static final Logger logger = LoggerFactory.getLogger(QnAController.class);

    //목록보기
    public Header<List<QnAListDto>> getQnAList(Pageable oriPageable, SearchCondition searchCondition) {
        CustomPageable pageable = new CustomPageable(oriPageable);
        // 결과 리스트 담을 객체
        // QnAListDto랑 QnADto는 다른 클래스(다른 객체임)
        List<QnAListDto> resultList = new ArrayList<>();

        resultList = getQnAListUp(pageable, searchCondition.getSk(), searchCondition.getSv());

/*
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

            logger.info("=============resultList=============" + resultList);

            if(answerEntity != null){
                QnAListDto qnaAnswer = new QnAListDto(answerEntity);
                qnaAnswer.setUserCode(answerEntity.getAdminCode());
                logger.info("=============qnAListAnswer=============" + qnaAnswer);
                resultList.add(qnaAnswer);

            }
        }
*/
        Pagination pagination = new Pagination(
                new Integer((int)qnARepository.count())
                , pageable.getPageNumber()
                , pageable.getPageSize() +1
                , 10
        );
        return Header.OK(resultList, pagination);
    }

    // 상세보기
    public QnADto getQnA(Long qnaNo, HttpServletRequest request) {

        QnAEntity qnaEntity = qnARepository.findById(qnaNo).get();
//        if(qnaEntity.getQna_private() != "Y" && 작성자 != 유저
//            || 공개 != "Y" && 관리자 != 유저){
//            return null;
//        }
        HttpSession session = request.getSession();
        Long currentUserCode = memberRepository.findByUserId((String)session.getAttribute("id")).orElseGet(MemberEntity::new).getUserCode();

        qnaEntity.setQnaReadCount(qnaEntity.getQnaReadCount()+1);

        return new QnADto(qnARepository.save(qnaEntity)
                , qnaEntity.getUserCode() == null ?
                adminRepository.findById(qnaEntity.getAdminCode()).get().getAdminId()
                : memberRepository.findById(qnaEntity.getUserCode()).get().getUserId()
                , currentUserCode);
    }

    public QnADto qnaCreate(QnADto qnaDto){
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
        //시큐리티 컨택스트(like 세션) //사용자 인증정보
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String loginId = authentication.getName();
        logger.info("login Id : "+loginId);

//        Long userCode = memberRepository.findByUserId(loginId).get().getUserCode();
//        Long adminCode = adminRepository.findByAdminId(loginId).get().getAdminCode();

        /*

        if( qnaDto.getQnaRef() == null || qnaDto.getQnaRef() == 0 ) qnaEntity = new QnAEntity(qnaDto
                                                                                            , memberRepository.findByUserId(loginId).get().getUserCode()
                                                                                            , "Answer");
        else qnaEntity = new QnAEntity(qnaDto, adminRepository.findByAdminId(loginId).get().getAdminCode());

        */
        QnAEntity qnaEntity = null;
        if( qnaDto.getQnaRef() == null || qnaDto.getQnaRef() == 0 ) qnaEntity = new QnAEntity(qnaDto, qnaDto.getUserCode(), "Answer", LocalDateTime.now());
        else qnaEntity = new QnAEntity(qnaDto, qnaDto.getAdminCode(), LocalDateTime.now(), qnARepository.findById(qnaDto.getQnaRef()).get().getQnaPrivate());

        if( qnARepository.findByQnaRef(qnaDto.getQnaRef()) == null ) qnaEntity = qnARepository.save(qnaEntity);
        else return null;
//        if(qnaEntity.getQnaRef() > 0){
//            qnaEntity = qnARepository.save(qnaEntity);
//        }else {
//            qnaEntity = qnARepository.saveQuestion(qnaEntity);
//        }

        return QnADto.builder()
                .qnaNo(qnaEntity.getQnaNo())
                .qnaTitle(qnaEntity.getQnaTitle())
                .qnaContent(qnaEntity.getQnaContent())
                .createAt(qnaEntity.getCreateAt())
                .userCode(qnaEntity.getUserCode())
                .adminCode(qnaEntity.getAdminCode())
                .qnaReadCount(qnaEntity.getQnaReadCount())
                .qnaOriginalFile(qnaEntity.getQnaOriginalFile())
                .qnaRenameFile(qnaEntity.getQnaRenameFile())
                .build();
    }

    //수정
    public QnAUpdateDto qnaUpdate(QnAUpdateDto qnaUpdateDto){

        if(qnARepository.findById(qnaUpdateDto.getQna_no()) == null){
            return new QnAUpdateDto("F");
        }

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

        QnAEntity qnaEntity = QnAEntity.builder().qnaNo(qnaUpdateDto.getQna_no())
                .qnaTitle(qnaUpdateDto.getQna_title())
                .qnaContent(qnaUpdateDto.getQna_content())
                .createAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                .qnaOriginalFile(qnaUpdateDto.getQna_original_file())
                .qnaRenameFile(qnaUpdateDto.getQna_rename_file())
                .build();

        return new QnAUpdateDto(qnARepository.save(qnaEntity));
    }

    //삭제 (삭제는 반환타입이 Long, 값은 삭제된 행 )
    public Long qnaDelete(Long qna_no){
        qnARepository.deleteById(qna_no);
        return 1L;
    }

    //QnA 리스트 출력 쿼리문 사용
    private List<QnAListDto> getQnAListUp (CustomPageable pageable, String sk, String sv){

        StringBuffer sb = new StringBuffer();
        sb.append("SELECT QNA_FIN.QNA_NO                                                                                                ");
        sb.append("       , QNA_FIN.CREATE_AT                                                                                                ");
        sb.append("       , QNA_FIN.QNA_TITLE                                                                                                ");
        sb.append("       , QNA_FIN.QNA_CONTENT                                                                                                ");
        sb.append("       , QNA_FIN.QNA_READCOUNT                                                                                                ");
        sb.append("       , QNA_FIN.QNA_ORIGINAL_FILE                                                                                                ");
        sb.append("       , QNA_FIN.QNA_RENAME_FILE                                                                                                ");
        sb.append("       , QNA_FIN.QNA_PRIVATE                                                                                          ");
//        sb.append("       , DECODE(QNA_FIN.USER_CODE, NULL, ( SELECT ADMIN_ID                                                             ");
//        sb.append("                                             FROM ADMIN                                                                 ");
//        sb.append("                                            WHERE ADMIN_CODE = QNA_FIN.ADMIN_CODE ) , ( SELECT MEMBER_ID                  ");
//        sb.append("                                                                                          FROM MEMBER                      ");
//        sb.append("                                                                                         WHERE MEMBER_CODE = QNA_FIN.MEMBER_CODE ) )                                        ");
        sb.append("       , DECODE(QNA_FIN.USER_CODE, NULL, QNA_FIN.ADMIN_CODE , QNA_FIN.USER_CODE) AS USER_CODE                                      ");
        sb.append("       , 0 AS ADMIN_CODE                                                                                                                  ");
        sb.append("       , QNA_FIN.QNA_REF                                                                                                   ");
        sb.append("  FROM (                                                                                                                         ");
        sb.append("      SELECT ROWNUM AS NUM, QNA_LIST.*                                                                         ");
        sb.append("        FROM (                                                                                                                   ");
        sb.append("            SELECT TOTAL.*                                                                                                    ");
        sb.append("              FROM (                                                                                                             ");
        sb.append("                  SELECT A.QNA_NO                                                                                          ");
        sb.append("                    FROM QNA A                                                                                               ");
        sb.append("                   WHERE A.QNA_REF = A.QNA_NO                                                                     ");
        sb.append("                     AND 'TITLE' = ?                                                                                            ");
        sb.append("                     AND LENGTH(?||'1') > 1                                                                                 ");
        sb.append("                     AND A.QNA_TITLE LIKE '%'||?||'%'                                                                    ");
        sb.append("                                                                                                                                      ");
        sb.append("                      OR A.QNA_REF = A.QNA_NO                                                                        ");
        sb.append("                     AND 'TITLE' = ?                                                                                            ");
        sb.append("                     AND LENGTH(?||'1') > 1                                                                                  ");
        sb.append("                     AND EXISTS ( SELECT 'ANSWER HAS TITLE'                                                        ");
        sb.append("                                    FROM QNA B                                                                                 ");
        sb.append("                                   WHERE A.QNA_NO = B.QNA_REF                                                        ");
        sb.append("                                     AND B.QNA_NO <> B.QNA_REF                                                        ");
        sb.append("                                     AND B.QNA_TITLE LIKE '%'||?||'%' )                                                     ");
        sb.append("                                                                                                                                        ");
        sb.append("                      OR A.QNA_REF = A.QNA_NO                                                                              ");
        sb.append("                     AND 'USER' = ?                                                                                                  ");
        sb.append("                     AND LENGTH(?||'1') > 1                                                                                        ");
        sb.append("                     AND A.USER_CODE = ?                                                                                            ");
        sb.append("                                                                                                                                             ");
        sb.append("                      OR A.QNA_REF = A.QNA_NO                                                                                ");
        sb.append("                     AND 'USER' = ?                                                                                                    ");
        sb.append("                     AND LENGTH(?||'1') > 1                                                                                          ");
        sb.append("                     AND EXISTS ( SELECT 'ANSWER HAS USER'                                                                 ");
        sb.append("                                    FROM QNA B                                                                                         ");
        sb.append("                                   WHERE A.QNA_NO = B.QNA_REF                                                               ");
        sb.append("                                     AND B.QNA_NO <> B.QNA_REF                                                               ");
        sb.append("                                     AND B.USER_CODE = ? )                                                                            ");
        sb.append("                                                                                                                                                ");
        sb.append("                      OR A.QNA_REF = A.QNA_NO                                                                                  ");
        sb.append("                     AND 'USER' = ?                                                                                                      ");
        sb.append("                     AND LENGTH(?||'1') > 1                                                                                            ");
        sb.append("                     AND A.ADMIN_CODE = ?                                                                                             ");
        sb.append("                                                                                                                                                ");
        sb.append("                      OR A.QNA_REF = A.QNA_NO                                                                                     ");
        sb.append("                     AND 'USER' = ?                                                                                                       ");
        sb.append("                     AND LENGTH(?||'1') > 1                                                                                             ");
        sb.append("                     AND EXISTS ( SELECT 'ANSWER HAS USER'                                                                     ");
        sb.append("                                    FROM QNA B                                                                                             ");
        sb.append("                                   WHERE A.QNA_NO = B.QNA_REF                                                                     ");
        sb.append("                                     AND B.QNA_NO <> B.QNA_REF                                                                     ");
        sb.append("                                     AND B.ADMIN_CODE = ? )                                                                               ");
        sb.append("                                                                                                                                                     ");
        sb.append("                      OR A.QNA_REF = A.QNA_NO                                                                                       ");
        sb.append("                     AND LENGTH(?||'1') = 1                                                                                                 ");
        sb.append("                     ) QUESTION                                                                                                               ");
        sb.append("                     , QNA TOTAL                                                                                                               ");
        sb.append("             WHERE TOTAL.QNA_REF = QUESTION.QNA_NO                                                                     ");
        sb.append("             ORDER BY TOTAL.QNA_REF DESC, TOTAL.QNA_NO ASC                                                                     ");
        sb.append("             ) QNA_LIST                                                                                                                        ");
        sb.append("         )QNA_FIN                                                                                                                                         ");
        sb.append(" WHERE NUM BETWEEN ( ? - 1 ) * ? + 1 AND ? * ?                                                                     ");

        String mode = "";
        if( sk.equals("qnaTitle") ) mode = "TITLE";
        else if( sk.equals("userCode")) mode = "USER";
        else mode = "";

        String sql = sb.toString();
        Query nativeQuery = entityManager.createNativeQuery(sql, QnAEntity.class)
                .setParameter(1,mode)
                .setParameter(2,sv)
                .setParameter(3,sv)
                .setParameter(4,mode)
                .setParameter(5,sv)
                .setParameter(6,sv)
                .setParameter(7,mode)
                .setParameter(8,sv)
                .setParameter(9,sv)
                .setParameter(10,mode)
                .setParameter(11,sv)
                .setParameter(12,sv)
                .setParameter(13,mode)
                .setParameter(14,sv)
                .setParameter(15,sv)
                .setParameter(16,mode)
                .setParameter(17,sv)
                .setParameter(18,sv)
                .setParameter(19,sv)
                .setParameter(20,pageable.getPageNumber())
                .setParameter(21,pageable.getPageSize())
                .setParameter(22,pageable.getPageNumber())
                .setParameter(23,pageable.getPageSize())
                ;

        List<QnAEntity> entities = nativeQuery.getResultList();
        List<QnAListDto> results = new ArrayList<>();
        for( QnAEntity entity : entities){
            String userId = "";
            if( (entity.getQnaNo() - entity.getQnaRef())<0.1 ) userId = memberRepository.findById(entity.getUserCode()).get().getUserId();
            else userId = adminRepository.findById(entity.getUserCode()).get().getAdminId();
            if(!((entity.getQnaNo() - entity.getQnaRef())<0.1)) entity.setQnaTitle("  ┗>[답변입니다] " + entity.getQnaTitle());
            QnAListDto dtos = new QnAListDto(entity, userId);
            results.add(dtos);
        }


        return results;
    }

}