package com.example.reto3.controller;


import com.example.reto3.entities.DTOs.CompletedAndCancelled;
import com.example.reto3.entities.DTOs.TotalAndClient;
import com.example.reto3.entities.Reservation;
import com.example.reto3.service.ReservationService;
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
@RequestMapping("/api/Reservation")

public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation>getReservation(){
        return  reservationService.getAll();

    }

    @GetMapping("/{id}")
    public Optional<Reservation>getReservation (@PathVariable("id") int Id ){
        return  reservationService.getReservation(Id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return  reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return  reservationService.update(reservation);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id ) {
        return  reservationService.delete(id);
    }


    @GetMapping("/report-dates/{fecha1}/{fecha2}")
    public  List<Reservation> getReservationsBetweenDatesReport(@PathVariable ("fecha1")String fecha1,@PathVariable("fecha2")String fecha2){
        return reservationService.getReservationBetweenDatesReport(fecha1 , fecha2);

    }

    @GetMapping("/report-status")
    public CompletedAndCancelled getReservationsStatusReport(){
        return reservationService.getReservationStatusReport();
    }

    @GetMapping("/report-clients")
    public List<TotalAndClient> getTopClientsReport(){
        return  reservationService.getTopClientsReport();
    }

}

