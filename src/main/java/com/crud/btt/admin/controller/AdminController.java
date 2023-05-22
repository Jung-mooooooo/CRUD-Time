package com.crud.btt.admin.controller;

import com.crud.btt.admin.model.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class AdminController {

    private final AdminService adminService;

//private static final Logger logger = LoggerFactory.getLogger(AdminController.class);


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


    //감정현황 조회
//    @GetMapping("/admin")
//    public List<EmotionEntity> userEmotionCount(HttpServletResponse response) {
//
//        return adminService.emotionCount();
//    }


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
//    public String visitUserCount(HttpServletResponse response) {
//
//        // 오늘 접속자 수
//        String visitorsT = Integer.toString(Math.toIntExact(adminService.visitCount()));
//
//        // 월 접속자 수(해당 달 총 접속자수=> 데일리로 누적됨)
//        String visitorsM = Integer.toString(Math.toIntExact(adminService.visitCountMonth()));
//
//        // 월평균 접속자 수(한달 평균 접속자수)
//        // 월접속자수를 view단에서 일수로 나누기. => if문 사용
//        // <c:if test="new Date().substring(4, 6) == '02'">
//        long datetime = 0;
//        Date date = new Date(datetime);
//        String visitorsAvg;
//        if (date.toString().substring(4, 6).equals("02")) {
//            visitorsAvg = Integer.toString((int) (adminService.visitCountMonth() / 28));
//        } else if (date.toString().substring(4, 6).equals("04") || date.toString().substring(4, 6).equals("06")
//                || date.toString().substring(4, 6).equals("09") || date.toString().substring(4, 6).equals("11")) {
//            visitorsAvg = Integer.toString((int) (adminService.visitCountMonth() / 30));
//
//        } else {
//            visitorsAvg = Integer.toString((int) (adminService.visitCountMonth() / 31));
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
//        return job.toJSONString();

//    }




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
}
