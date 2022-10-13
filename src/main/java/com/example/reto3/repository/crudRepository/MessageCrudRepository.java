package com.example.reto3.repository.crudRepository;


import com.example.reto3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {

}
