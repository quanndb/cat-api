package com.catgpt.catgpt.controllers;

import com.catgpt.catgpt.models.chat_data;
import com.catgpt.catgpt.models.data;
import com.catgpt.catgpt.repositories.ChatRepository;
import com.catgpt.catgpt.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/chat")
@CrossOrigin(origins = "https://quanndb.github.io/")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ChatService chatService;


    @PostMapping("/newchat")
    public ResponseEntity<String> newChat(@RequestBody data data){
        chat_data newdata = new chat_data("anonimus",data.getData(),(new Date()).toString());
        ResponseEntity<String> response = null;
        try{
            chat_data chatData = chatService.sendNewMessage(newdata);
            if(chatData.getId()>0){
                response = ResponseEntity.status(HttpStatus.OK).body("ok ngon");
            }
        }
        catch(Exception e){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("lol");
        }
        return response;
    }

    @GetMapping("/getallchats")
    private List<chat_data> getAllChats(){
        return (List<chat_data>) chatRepository.findAll();
    }

    @DeleteMapping("/delall")
    private String delAllChat(){
        try{
            chatRepository.deleteAll();
            return "ok";
        }
        catch (Exception e){
            return "lol";
        }
    }
}
