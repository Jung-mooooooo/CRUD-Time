//package com.crud.btt.chat.model.dto;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.PostConstruct;
//import java.util.*;
//
//@Slf4j
//@Repository
//public class ChatRoomRepository {   //채팅방 생성, 정보 조회하는 repository 생성.
//
//    //생성한 방을 Map 구조체에 저장.
//    //이후에 db에 저장 예정.
//    private Map<String, ChatRoom> chatRoomMap;
////    private Map<String, ChatRoom> chatRooms;   //서버에 생성된 모든 채팅방의 정보를 모아둔 구조체.
//
//
//    @PostConstruct //의존성 주입이 이루어진 후 초기화를 수행하는 메서드, 다른 리소스에 호출되지 않아도 수행됨
//    private void init(){
//        log.info("service init");
//        chatRoomMap = new LinkedHashMap<>();
//    }
//
//    //채팅방 리스트 조회
//    public List<ChatRoom> findAllRoom() {
//        //채팅방 생성순서 최근 순으로 반환
//        List chatRooms = new ArrayList<>(chatRoomMap.values());
//        Collections.reverse(chatRooms);
//        return chatRooms;
//    }
//
//    //채팅방 정보 조회
//    public ChatRoom findRoomById(String roomId){
//        return chatRoomMap.get(roomId);
//    }
//
//    //채팅방 생성
//    public ChatRoom createChatRoom(String name) {
//        log.info("repository - create chat room");
//        ChatRoom chatRoom = ChatRoom.create(name);
//        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
//        return chatRoom;
//    }
//}
