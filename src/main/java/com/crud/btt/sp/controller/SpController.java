package com.crud.btt.sp.controller;


import com.crud.btt.sp.entity.SpEntity;
import com.crud.btt.sp.model.service.SpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.json.JsonObject;
import javax.mail.Session;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class SpController {

    private final SpService spService;

    @PostMapping("/sp/auth")
    @ResponseBody
    public String spAuthMethod(
            @RequestParam(value = "fd") MultipartFile mf,
            @CookieValue (name="user_code", required = false) Long user_code,
            HttpServletRequest request
            ) throws IOException {

        String path = System.getProperty("user.dir") + "/src/main/webapp/resources/voice/"+user_code+".ogg";
        File file = new File(path);

        mf.transferTo(file);

        String pass = Speech.vtos(path);

        SpEntity member = spService.userAuth(user_code, pass);

        if(member !=null){
            System.out.println("로그인 성공");
            request.getSession();
            return "ok";
        }
        else {
            System.out.println("로그인 실패");
            return "no";
        }
    }


    @PostMapping("/sp/speech")
    @ResponseBody
    public String spSpeechMethod(
            @RequestParam(value = "fd") MultipartFile mf,
            @CookieValue (name="user_code", required = false) Long user_code,
            HttpServletRequest request

    ) throws Exception {

        String path = System.getProperty("user.dir") + "/src/main/resources/voice/"+user_code;
        File file = new File(path+".ogg");

        mf.transferTo(file);

        String vtos = Speech.vtos(path);
        String response = ChatBot.sendMessage(vtos);
        TTS.tts(user_code,response);

        File responceFile = new File(path+".mp3");

        return "";
    }


    @PostMapping("/sp/music")
    @ResponseBody
    public String spMusicMethod() {
        System.out.println("sp/music 실행됨");
//      String result = new Speech().vtos("1234");
        return "1";
    }


}
