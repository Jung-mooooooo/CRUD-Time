package com.crud.btt.sp.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

public class SpController {


    @RequestMapping(value = "/sp/speech", method = RequestMethod.POST)
    @ResponseBody
    public String speechTest(
            @RequestParam(value = "fd", required = false) MultipartFile mf
    ) throws Exception {
        System.out.println("menu/speech 실행됨");


//      String result = new Speech().vtos("1234");
        return "1";
    }




}
