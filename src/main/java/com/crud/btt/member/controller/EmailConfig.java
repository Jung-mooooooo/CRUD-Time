package com.crud.btt.member.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


@Configuration
@PropertySource("classpath:email.properties")
public class EmailConfig {

    @Value("${AdminMail.id}")
    private String id;
    @Value("${AdminMail.password}")
    private String password;

    @Bean
    public JavaMailSender javaMailService() {
        System.out.println("1번 자바메일 서비스");
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost("smtp.naver.com");   //메인 도메인 서버 주소 = smtp 서버 주소
        javaMailSender.setUsername(id);
        javaMailSender.setPassword(password);
        javaMailSender.setPort(587);                //메일 인증서버 포트
        javaMailSender.setJavaMailProperties(getMailProperties());  //메일 인증서버 정보 가져오기

        return javaMailSender;
    }

    private Properties getMailProperties() {
        System.out.println("2번 자바메일 프로퍼티스");
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");      //프로토콜설정
        properties.setProperty("mail.smtp.auth", "true");               //smtp 인증
        properties.setProperty("mail.smtp.starttls.enable","true");     //smtp strattles사용
        properties.setProperty("mail.debug", "true");                   //디버그 사용
        properties.setProperty("mail.smtp.ssl.trust","smtp.naver.com"); //ssl 인증 서버는 smtp.naver.com
        //properties.setProperty("mail.smtp.ssl.enable","true");
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        return properties;
    }




}
