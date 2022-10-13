package com.example.reto3.service;


import com.example.reto3.entities.Client;
import com.example.reto3.entities.Message;
import com.example.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();

    }
    public Optional<Message>getMessage(int id){
        return  messageRepository.getMessage(id);
    }

    public Message save(Message c) {
        if (c.getIdMessage() == null) {
            return messageRepository.save(c);
        } else {
            Optional<Message> e = messageRepository.getMessage(c.getIdMessage());
            if (e.isPresent()){
                return c;
            }else {
                return messageRepository.save(c);
            }

        }

    }


    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if (e.isPresent()) {
                if (message.getMessageText() != null) {
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(e.get());
                return e.get();
            } else {
                return message;
            }
        }else{
            return message;
        }

    }





    public boolean delete (int id ){
        boolean d = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return d;


    }

}