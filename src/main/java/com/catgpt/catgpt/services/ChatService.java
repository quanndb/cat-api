package com.catgpt.catgpt.services;

import com.catgpt.catgpt.models.chat_data;
import com.catgpt.catgpt.repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public chat_data sendNewMessage(chat_data data){
        return chatRepository.save(data);
    }
}
