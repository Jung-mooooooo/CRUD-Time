//package com.crud.btt.chat.controller;
//
//
//import com.crud.btt.chat.model.dto.ChatDto;
//import com.crud.btt.chat.model.dto.ChatRoom;
//import com.crud.btt.chat.model.service.ChatService;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.json.JsonReadFeature;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.util.*;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
////서버와 클라이언트간 1:n 관계
////여러 클라이언트의 메세지를 핸들링하기 위한 클래스
//public class WebSocketHandler extends TextWebSocketHandler {
////    private static List<WebSocketSession> list = new ArrayList<>();
//    Scanner sc = new Scanner(System.in);
//    private final ChatService chatService;
//    ObjectMapper objectMapper = new ObjectMapper();
//
////    private final ObjectMapper objectMapper;
//
//
//    // Map<String, WebSocketSession> sessionMap = new HashMap<>(); //웹소켓 세션을 담아둘 맵
////    Map<String, String> userMap = new HashMap<>();	//사용자
//
//    //클라이언트로 메세지 수신시 동작
//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
////        Message message = mapper.readValue(textMessage.getPayload(), Message.class);
////        message.setSender(session.getId());
//
//        String payload = (String) message.getPayload();
////        String payload = message.getPayload();
//        log.info("-------------Message------------");
//        log.info("payload : {}", payload);
//        log.info("-------------Message------------");
//
////        for (WebSocketSession sess: list) {
////            sess.sendMessage(message);
////        }
//
////        JSONObject obj = jsonToObjectParser(msg);
////        로그인된 Member (afterConnectionEstablished 메소드에서 session을 저장함)
////        for(String key : sessionMap.keySet()) {
////            WebSocketSession wss = sessionMap.get(key);
////
////            if(userMap.get(wss.getId()) == null) {
////                userMap.put(wss.getId(), (String)obj.get("userName"));
////            }
////
////            //클라이언트에게 메시지 전달
////            wss.sendMessage(new TextMessage(obj.toJSONString()));
////        }
//
//
////        TextMessage initialGreeting = new TextMessage(sc.next());
////        session.sendMessage(initialGreeting);
////        System.out.println(session.toString());
////        System.out.println(message.toString());
//
//
////        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        // 요 아랫 줄을 추가했다!
//        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//        objectMapper.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);
//        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.configure(
//                JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(),
//                true
//        );
//
////         payload = objectMapper.writeValueAsString(payload);
//        ChatDto chat = objectMapper.readValue(payload, ChatDto.class);
//        log.info("chat RoomID: " + chat.getRoomId());
//        log.info("chat Type: " + chat.getType());
//        log.info("chat Sender: " + chat.getSender());
//        log.info("chat Chat: " + chat.getChat());
//        log.info("session : " + session.toString());
//        ChatRoom room = chatService.findById(chat.getRoomId());
//       log.info("room : " + chat.getRoomId().toString());
//
//        room.handleActions(session, chat, chatService);
//    }
//
////    클라이언트 소켓 연결시 동작
////    @Override
////    public void afterConnectionEstablished(WebSocketSession session) throws  Exception {
////        log.info("{} 연결되었습니다."+ session.getId());
////
////        list.add(session);
////        log.info(session + "클라이언트 접속");
////        super.afterConnectionEstablished(session);
////        sessionMap.put(session.getId(), session);
////
////        JSONObject obj = new JSONObject();
////        obj.put("type", "getId");
////        obj.put("sessionId", session.getId()); //세션에 저장
////
////        클라이언트에게 메시지 전달
////        session.sendMessage(new TextMessage("베덴톡입니다."));
////
////    }
//
//    //클라이언트 소켓 종료시 동작
////    @Override
////    public  void  afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
////        log.info("{} 연결이 종료되었습니다." + session.getId());
////        log.info("클라이언트 접속 해제");
////        list.remove(session);
////        super.afterConnectionClosed(session, status);
////        sessionMap.remove(session.getId());
////
////        String userName = userMap.get(session.getId());
////        for(String key : sessionMap.keySet()) {
////            WebSocketSession wss = sessionMap.get(key);
////
////            if(wss == session) continue;
////            JSONObject obj = new JSONObject();
////            obj.put("type", "close");
////            obj.put("userName", userName);
////
////            //클라이언트에게 메시지 전달
////            wss.sendMessage(new TextMessage(obj.toJSONString()));
////        }
////        userMap.remove(session.getId());
////    }
//}
