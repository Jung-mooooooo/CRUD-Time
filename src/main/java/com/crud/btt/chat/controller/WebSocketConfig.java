package com.crud.btt.chat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;


@Slf4j
@Configuration
//@RequiredArgsConstructor
@EnableWebSocketMessageBroker    //STOMP 사용을 위해 선언.
//@EnableWebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//    @Autowired
//    private final WebSocketHandler webSocketHandler;
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        System.out.println("chat server open");
//        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
//                .withSockJS();
//            registry.addHandler(skHandler(), "/chat").withSockJS();

//    }

//    @Bean
//    public WebSocketHandler skHandler(){
//        System.out.println("skHandler 들어옴");
//        return new WebSocketHandler();
//    }

//    @Override
//    public void registerWebSocketHandlers/*registerStompEndpoints*/(WebSocketHandlerRegistry registry/*StompEndpointRegistry registry*/) {    //connection
//        registry.addEndpoint("/ws/chat")    //접속주소
//                .setAllowedOriginPatterns("*")
//                .withSockJS();
//        registry.addHandler(webSocketHandler, "/ws/chat")    //접속주소
//                .setAllowedOriginPatterns("*");
//                .withSockJS();
//        log.info("접속 시작");
//    }

//
    @Override
    //브로커 생성: message brocker => 집배원로부터 전달받은 메세지를 구독자에게 메세지를 주고받게 해주는 중간 역활하는 것.
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //pub & sub
        //메시지를 공급하는 주체(pub)와 소비하는 주체(sub)를 분리해 제공하는 메시징 방법
        //우체통(topic = 채팅방 생성), 집배원(publisher = 채팅방에 글을 써서 보내는 행위, 우체통에 신문 넣기),
        //구독자(subscriber = 채팅방에 들어가는 구독자)

        //메세지 구독하는 요청의 prefix는 [/sub] 로 시작 설정
        config.enableSimpleBroker("/sub");
        //메세지 발행하는 요청의 prefix는 [/pub] 로 시작 설정
        config.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/counseling/chatting").setAllowedOriginPatterns("*");
    }


}













