package com.crud.btt.chat.controller;

import com.crud.btt.chat.model.dto.ChatRoom;
import com.crud.btt.chat.model.dto.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {   //websocket 통신 외 채팅 화면 view구성을 위한 controller

    private final ChatRoomRepository chatRoomRepository;

    //전체 채팅방 목록 리스트
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> rooms(){
        return chatRoomRepository.findAllRoom();
    }

    //채팅방 생성
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        return chatRoomRepository.createChatRoom(name);
    }

    //특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        return chatRoomRepository.findRoomById(roomId);
    }

}
