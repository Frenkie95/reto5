package com.example.reto3.controller;


import com.example.reto3.entities.Score;
import com.example.reto3.service.ScoreService;
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
@RequestMapping("/api/Score")

public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score>getScore(){
        return  scoreService.getAll();

    }

    @GetMapping("/{id}")
    public Optional<Score>getScore (@PathVariable("id") int Id ){
        return  scoreService.getScore(Id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score){
        return  scoreService.save(score);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score){
        return  scoreService.update(score);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id ){
        return  scoreService.delete(id);
    }

}
