package com.crud.btt.chat.model.dto;


import lombok.*;
import lombok.extern.slf4j.Slf4j;
import java.util.UUID;

@Slf4j
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class ChatRoom { //채팅방을 위한 dto
    //채팅방 구현을 위한 클래스

    private String roomId;      //채팅방 id
    private String name;    //채팅방 이름

    //입장한 클라이언트 정보 보관을 위해 websocketSession 정보 리스트를 멤버 필드로 갖음.
//    private Set<WebSocketSession> sessions = new HashSet<>();    //client session 정보

//    @Builder
   //pub/sub => 구독자 관리가 자동으로 되므로 아래의 웹소켓 세션 관리가 필요 없음.
    //또한 클라이언트에 메세지 발송이 필요 없음 => 자동 발송
    public static ChatRoom create(String name){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }


    //채팅방에서 필요한 내용
    //입장한 클라이언트 session 정보, 채팅방id(-> 추후 mathchId + 진영코드 + 소환사명을 구별 ID로 함)
    //입장과 통신 기능을 위해 handleAcion => 분기 처리
    //입장시 채팅방의 session 정보 리스트에 클라이언트 session 추가,
    //채팅방에 메세지 도착하는 경우 모든 session에 메세지 발송 => 채팅 완성
//    public void handleActions(WebSocketSession session, ChatDto chatDto, ChatService chatService) {
//        log.info("handleActions method");
//        if (chatDto.getType().equals(ChatDto.ChatType.ENTER)){
//            sessions.add(session);  //클라이언트 session에 채팅방 session 정보 저장
//            //입장한 client를 내용에 추가.
//            chatDto.setChat(chatDto.getSender() + "님이 입장했습니다.");
//        }
//        sendChat(chatDto, chatService);
//    }
//
//    public <T> void sendChat(T chat, ChatService chatService) {
//        log.info("sendChat method");
//        //Streams : 컬렉션, 배열 등에 저장된 요소들을 하나씩 참조하면서 코드를 실행할 수 있는 기능.
//        //Stream을 사용하면, 불필요한 for문을 사용하지 않을 수 있으며, 람다식을 활요하여 코드를 직관적으로 처리가능.
//        //Stream은 데이터를 담는 저장소가 아니며, 데이터 변경 x, 재사용 불가, 각 요소가 한번씩 처리, 무제한(실시간으로 들어올때)
//        //parallelStream : 위의 내용과 동일하지만, 데이터를 병렬처리하여 대용량 데이터에서 performance가 더 뛰어남.
//        sessions.parallelStream().forEach(session -> chatService.sendChat(session, chat));
//    }

}
