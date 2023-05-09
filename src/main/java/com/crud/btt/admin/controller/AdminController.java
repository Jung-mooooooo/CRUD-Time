package com.crud.btt.admin.controller;

import com.crud.btt.admin.entity.ChatLogEntity;
import com.crud.btt.admin.model.dto.ChatLogDto;
import com.crud.btt.admin.model.service.AdminService;
import com.crud.btt.common.Header;
import com.crud.btt.common.SearchCondition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class AdminController {
    private final AdminService adminService;
private static final Logger logger = LoggerFactory.getLogger(AdminController.class);


    //chatlist 출력용
    @GetMapping("counseling/chattinglist")
    public Header<List<ChatLogDto>> ChatLogList(@PageableDefault(sort = {"log_no"}) Pageable pageable,
                                                SearchCondition searchCondition) {
        return adminService.getChatLogList(pageable, searchCondition);
    }

    //chatlog table insert
    @PostMapping
    public ChatLogEntity create(@RequestBody ChatLogDto chatLogDto) {
        return adminService.create(chatLogDto);
    }


    //감정현황 조회
    public String userEmotionCount(HttpServletResponse response) {
        return null;
    }


    //회원 ip 메소드
    public String getClientIP(HttpServletRequest request){
        String ip = request.getHeader("X-FORWARDED-FOR");
        if(ip == null || ip.length() == 0){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0){
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    //접속자 수 조회
    public String visitUserCount(HttpServletResponse response) {

//        // 오늘 접속자 수
//        String visitorsT = Integer.toString(adminService.visitCount());
//
//        // 월 접속자 수(해당 달 총 접속자수=> 데일리로 누적됨)
//        String visitorsM = Integer.toString(adminService.visitCountMonth());
//
//        // 월평균 접속자 수(한달 평균 접속자수)
//        // 월접속자수를 view단에서 일수로 나누기. => if문 사용
//        // <c:if test="new Date().substring(4, 6) == '02'">
//        Date date = new Date();
//        String visitorsAvg;
//        if (date.toString().substring(4, 6) == "02") {
//            visitorsAvg = Integer.toString(adminService.visitCountMonth() / 28);
//        } else if (date.toString().substring(4, 6) == "04" || date.toString().substring(4, 6) == "06"
//                || date.toString().substring(4, 6) == "09" || date.toString().substring(4, 6) == "11") {
//            visitorsAvg = Integer.toString(adminService.visitCountMonth() / 30);
//
//        } else {
//            visitorsAvg = Integer.toString(adminService.visitCountMonth() / 31);
//
//        }
//
//        JSONObject job = new JSONObject();
//
//        job.put("visitorsT", visitorsT);
//        job.put("visitorsM", visitorsM);
//        job.put("visitorsAvg", visitorsAvg);
//
//
//        logger.info("adminBox.do 실행");
//
//        return job.toJSONString();

        return null;

    }




    //음성인식 사용자 수 조회
    public String visitSpecialUserCount(HttpServletResponse response) {

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

        return null;

    }


    //일주일간 이용이 없는 사용자 리스트 조회
    public String notForWeekUser(){
        return null;
    }

    //chatlog table delete
    @DeleteMapping
    public void delete(@PathVariable Long log_no){
        adminService.delete(log_no);
    }
}
