package com.crud.btt.chat.controller;


import com.crud.btt.admin.model.dto.EmotionDto;
import com.crud.btt.chat.entity.ChatListEntity;
import com.crud.btt.chat.model.dto.ChatDto;
import com.crud.btt.chat.model.dto.ChatListDto;
import com.crud.btt.chat.model.dto.ChatListRepository;
import com.crud.btt.chat.model.dto.ChatRoom;
import com.crud.btt.chat.model.service.ChatService;
import com.crud.btt.common.SearchCondition;
import com.crud.btt.member.entity.MemberEntity;
import com.crud.btt.member.model.dto.MemberDto;
import com.crud.btt.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ChatController {

    //stomp protocol
    private final SimpMessageSendingOperations sendingOperations;
    private final ChatService chatService;
    private final ChatListRepository chatListRepository;

    //채팅 유저별 emotion view
    @GetMapping("/emotion/{userCode}")
    public String getUserEmotion(@PathVariable Long userCode) {
        String emotion = null;

      switch (chatService.getUserEmotion(userCode).getEmotionCat()){
          case "angry" : emotion = "😡"; break;
          case "anxious" : emotion = "😔"; break;
          case "excited" : emotion = "😆"; break;
          case "happy" : emotion = "😍"; break;
          case "lonely" : emotion = "🤕"; break;
          case "sad" : emotion = "😥"; break;
          case "scary" : emotion = "😨"; break;
          case "tired" : emotion = "🥱"; break;
          case "NEUTRAL" : emotion = "😐"; break;
      }

      return emotion;
    }



    //채팅 유저 리스트 생성 = 유저 입장
    @PostMapping("/chatuser")
    public ResponseEntity<ChatListEntity> chatUser(@RequestBody ChatListDto chatUser) throws Exception{
            log.info("chatControll chatlist save");
            return new ResponseEntity<>(chatService.save(chatUser), HttpStatus.OK);
    }

    //채팅 유저 리스트 삭제 = 유저 퇴장
    @ResponseBody
    @DeleteMapping("/chatuser/delete/{userCode}")
    public void chatUserDelete(@PathVariable Long userCode){
        System.out.println("딜리트 컨트롤러");
       chatService.chatUserListDelete(userCode);
    }

    //유저 채팅 리스트 출력 = 공통 emotion & 현재 입장중인 유저 리스트 출력
    @GetMapping("/chatuser/list")
    public List<ChatListDto> chatUserList() {

        return chatService.chatUserList();
    }


    @MessageMapping("/chat/message")
    public void chat(ChatDto chatDto) {
        if (ChatDto.ChatType.ENTER.equals(chatDto.getType())) {
            chatDto.setChat(chatDto.getSender() + "님이 입장했습니다.");
        }
        sendingOperations.convertAndSend("/sub/chat/room/" + chatDto.getRoomId(), chatDto);
    }

//
//    @PostMapping
//    public ChatRoom createRoom(@RequestParam String name) { //채팅방 생성
//        //name is Summoner Name : 소환사명
//        return chatService.createRoom(name);
//    }
//
//    @GetMapping
//    public List<ChatRoom> findAllRoom() {
//        return chatService.findAllRoom();
//    }
}
