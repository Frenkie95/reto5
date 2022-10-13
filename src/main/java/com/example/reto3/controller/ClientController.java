package com.example.reto3.controller;



import com.example.reto3.entities.Client;

import com.example.reto3.service.ClientService;
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
@RequestMapping("/api/Client")

public class ClientController {

    @Autowired
    private ClientService clientService ;

    @GetMapping("/all")
    public List<Client>getClient(){
        return  clientService.getAll();

    }

    @GetMapping("/{id}")
    public Optional<Client>getClient (@PathVariable("id") int Id ){
        return  clientService.getClient(Id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return  clientService.save(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){
        return  clientService.update(client);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id ){
        return  clientService.delete(id);
    }

}
