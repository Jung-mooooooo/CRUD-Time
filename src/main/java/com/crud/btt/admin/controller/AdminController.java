package com.crud.btt.admin.controller;

import com.crud.btt.admin.entity.EmotionEntity;
import com.crud.btt.admin.entity.EmotionRepository;
import com.crud.btt.admin.entity.LogRepository;
import com.crud.btt.admin.model.dto.EmotionDto;
import com.crud.btt.admin.model.service.AdminService;
import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.member.model.dto.MemberDto;
import com.crud.btt.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.DecimalFormat;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class AdminController {

    private final AdminService adminService;
    private final MemberService memberService;
    private final LogRepository logRepository;
    private final EmotionRepository emotionRepository;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    //chatlist 출력용
//    @GetMapping("counseling/chattinglist")
//    public Header<List<ChatLogDto>> ChatLogList(@PageableDefault(sort = {"log_no"}) Pageable pageable,
//                                                SearchCondition searchCondition) {
//        return adminService.getChatLogList(pageable, searchCondition);
//    }

//
//    //chatlog table insert

//    @PostMapping
//    public ChatLogEntity create(@RequestBody ChatLogDto chatLogDto) {
//        return adminService.create(chatLogDto);
//    }


    //감정 체크
    @PatchMapping("/emotion")
    public ResponseEntity<EmotionEntity> userEmotion(@RequestBody EmotionDto emotionDto) {
        String emotionCat = emotionDto.getEmotionCat();
        Long userCode = emotionDto.getUserCode();

        log.info("유저 감정 컨트롤 - " + userCode + "님의 감정 상태는 "+ emotionCat);
        EmotionEntity emotionEntity = adminService.SaveUserEmotion(emotionCat, userCode);
        return new ResponseEntity<>(emotionEntity, HttpStatus.OK);
    }


    //감정현황 조회
    @GetMapping("/admin/emotion")
    public String clickEmotionCount() {

        // angry 감정클릭 수
        int angry = Math.toIntExact(adminService.clickEmotionAngry());

        // anxious 감정클릭 수
        int anxious = Math.toIntExact(adminService.clickEmotionAnxious());

        // excited 감정클릭 수
        int excited = Math.toIntExact(adminService.clickEmotionExcited());

        // happy 감정클릭 수
        int happy = Math.toIntExact(adminService.clickEmotionHappy());

        // sad 감정클릭 수
        int sad = Math.toIntExact(adminService.clickEmotionSad());

        // scary 감정클릭 수
        int scary = Math.toIntExact(adminService.clickEmotionScary());

        // tired 감정클릭 수
        int tired = Math.toIntExact(adminService.clickEmotionTired());

        // lonely 감정클릭 수
        int lonely  = Math.toIntExact(adminService.clickEmotionLonely());

        double sum = angry + anxious + excited + happy + sad + scary + tired + lonely;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double angryAvgD = (angry / sum) * 100;
        String angryAvg = decimalFormat.format(angryAvgD);

        double anxiousAvgD = (anxious / sum) * 100;
        String anxiousAvg = decimalFormat.format(angryAvgD);

        double excitedAvgD = (excited / sum) * 100;
        String excitedAvg = decimalFormat.format(excitedAvgD);

        double happyAvgD = (happy / sum) * 100;
        String happyAvg = decimalFormat.format(happyAvgD);

        double sadAvgD = (sad / sum) * 100;
        String sadAvg = decimalFormat.format(sadAvgD);

        double scaryAvgD = (scary / sum) * 100;
        String scaryAvg = decimalFormat.format(scaryAvgD);

        double tiredAvgD = (tired / sum) * 100;
        String tiredAvg = decimalFormat.format(tiredAvgD);

        double lonelyAvgD = (lonely / sum) * 100;
        String lonelyAvg = decimalFormat.format(lonelyAvgD);


        JSONObject job = new JSONObject();

        job.put("angryAvg", angryAvg);
        job.put("anxiousAvg", anxiousAvg);
        job.put("excitedAvg", excitedAvg);
        job.put("happyAvg", happyAvg);
        job.put("sadAvg", sadAvg);
        job.put("scaryAvg", scaryAvg);
        job.put("tiredAvg", tiredAvg);
        job.put("lonelyAvg", lonelyAvg);

        return job.toJSONString();
    }


    //접속자 수 조회
    @GetMapping("/admin/user")
    public String visitUserCount(HttpServletResponse response) {

        // 오늘 접속자 수
        String visitorsT = Integer.toString(Math.toIntExact(adminService.visitCount()));

        // 월 접속자 수(해당 달 총 접속자수=> 데일리로 누적됨)
        String visitorsM = Integer.toString(Math.toIntExact(adminService.visitCountMonth()));

        // 월평균 접속자 수(한달 평균 접속자수)
        // 월접속자수를 view단에서 일수로 나누기. => if문 사용
        // <c:if test="new Date().substring(4, 6) == '02'">
        long datetime = 0;
        Date date = new Date(datetime);
        String visitorsAvg;
        if (date.toString().substring(4, 6).equals("02")) {
            visitorsAvg = Integer.toString((int) (adminService.visitCountMonth() / 28));
        } else if (date.toString().substring(4, 6).equals("04") || date.toString().substring(4, 6).equals("06")
                || date.toString().substring(4, 6).equals("09") || date.toString().substring(4, 6).equals("11")) {
            visitorsAvg = Integer.toString((int) (adminService.visitCountMonth() / 30));

        } else {
            visitorsAvg = Integer.toString((int) (adminService.visitCountMonth() / 31));

        }

        JSONObject job = new JSONObject();

        job.put("visitorsT", visitorsT);
        job.put("visitorsM", visitorsM);
        job.put("visitorsAvg", visitorsAvg);


        return job.toJSONString();

    }




    //음성인식 사용자 수 조회
//    public String visitSpecialUserCount(HttpServletResponse response) {
//
//        // 오늘 접속자 수
//        String visitorsT = Integer.toString(adminService.spVisitCount());
//
//        // 월 접속자 수(해당 달 총 접속자수=> 데일리로 누적됨)
//        String visitorsM = Integer.toString(adminService.spVisitCountMonth());
//
//        // 월평균 접속자 수(한달 평균 접속자수)
//        // 월접속자수를 view단에서 일수로 나누기. => if문 사용
//        // <c:if test="new Date().substring(4, 6) == '02'">
//        Date date = new Date();
//        String visitorsAvg;
//        if (date.toString().substring(4, 6) == "02") {
//            visitorsAvg = Integer.toString(adminService.spVisitCountMonth() / 28);
//        } else if (date.toString().substring(4, 6) == "04" || date.toString().substring(4, 6) == "06"
//                || date.toString().substring(4, 6) == "09" || date.toString().substring(4, 6) == "11") {
//            visitorsAvg = Integer.toString(adminService.spVisitCountMonth() / 30);
//
//        } else {
//            visitorsAvg = Integer.toString(adminService.spVisitCountMonth() / 31);
//
//        }
//
//        JSONObject job = new JSONObject();
//
//        job.put("visitorsT", visitorsT);
//        job.put("visitorsM", visitorsM);
//        job.put("visitorsAvg", visitorsAvg);
//
//        logger.info("adminBox.do 실행");
//
//        return job.toJSONString();
//
//    }


    //일주일간 이용이 없는 사용자 리스트 조회
//    public String notForWeekUser(){
//        return null;
//    }

    //chatlog table delete
//    @DeleteMapping
//    public void delete(@PathVariable Long log_no){
//        adminService.delete(log_no);
//    }

    //회원목록
    @GetMapping("/admin/AdminMemberManager")
    public Header<List<MemberDto>> memberList(@PageableDefault(sort = {"userCode"}) Pageable pageable,
                                              SearchCondition searchCondition){
        // logger.info(pageable.getPageSize()+"/"+pageable.getPageNumber());
         logger.info("=====================Controller memberList==================" + adminService.memberList(pageable,searchCondition));
        return adminService.memberList(pageable,searchCondition);
    }

    @PutMapping("/admin/PermitMember")
    public MemberDto permitMember(@RequestBody MemberDto memberDto){
        // logger.info(pageable.getPageSize()+"/"+pageable.getPageNumber());
        logger.info("memberDto Permit method : "+memberDto.getUserId()+", "+memberDto.getUserCode());
        return adminService.permitMember(memberDto);
    }

}
