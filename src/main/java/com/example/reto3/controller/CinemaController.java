package com.example.reto3.controller;




import com.example.reto3.entities.Cinema;
import com.example.reto3.service.CinemaService;
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
@RequestMapping("/api/Cinema")

public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/all")
    public List<Cinema>getCinema(){
        return cinemaService.getAll();

    }

    @GetMapping("/{id}")
    public Optional<Cinema>getCinema (@PathVariable("id") int Id ){
        return  cinemaService.getCinema(Id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save(@RequestBody Cinema cinema){
        return  cinemaService.save(cinema);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema update(@RequestBody Cinema cinema){

        return  cinemaService.update(cinema);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id ){
        return  cinemaService.delete(id);
    }

}
