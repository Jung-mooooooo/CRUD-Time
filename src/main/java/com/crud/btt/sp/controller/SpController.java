package com.crud.btt.sp.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;




@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class SpController {


    @PostMapping("/sp/auth")
    @ResponseBody
    public String spAuthMethod() {
        System.out.println("sp/auth 실행됨");
//      String result = new Speech().vtos("1234");
        return "1";
    }


    @PostMapping("/sp/speech")
    @ResponseBody
    public String spSpeechMethod(
            @RequestParam(value = "fd", required = false) MultipartFile mf
    ) throws Exception {
        System.out.println("sp/speech 실행됨");

//      String result = new Speech().vtos("1234");
        return "1";
    }


    @PostMapping("/sp/music")
    @ResponseBody
    public String spMusicMethod() {
        System.out.println("sp/music 실행됨");
//      String result = new Speech().vtos("1234");
        return "1";
    }


}
