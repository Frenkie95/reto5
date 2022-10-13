package com.example.reto3.controller;



import com.example.reto3.entities.Message;
import com.example.reto3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="*" , methods = {RequestMethod.GET , RequestMethod.DELETE,RequestMethod.POST ,RequestMethod.PUT})
@RestController
@RequestMapping("/api/Message")

public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message>getMessage(){
        return  messageService.getAll();

    }

    @GetMapping("/{id}")
    public Optional<Message>getMessage (@PathVariable("id") int Id ){
        return  messageService.getMessage(Id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message){
        return  messageService.save(message);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message){
        return  messageService.update(message);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id ){
        return  messageService.delete(id);
    }

}
