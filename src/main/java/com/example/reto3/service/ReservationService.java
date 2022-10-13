package com.example.reto3.service;



import com.example.reto3.entities.DTOs.CompletedAndCancelled;
import com.example.reto3.entities.DTOs.TotalAndClient;
import com.example.reto3.entities.Reservation;
import com.example.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository  reservationRepository;

    public List<Reservation> getAll(){
        return  reservationRepository.getAll();

    }
    public Optional<Reservation>getReservation(int id){
        return reservationRepository.getReservation(id);

    }

    public Reservation update(Reservation c) {
        if (c.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReservation(c.getIdReservation());
            if (e.isPresent()) {
                if (c.getStartDate() != null) {
                    e.get().setStartDate(c.getStartDate());
                }
            }
            if (c.getDevolutionDate() != null) {
                e.get().setDevolutionDate(c.getDevolutionDate());
            }
            if (c.getStatus() != null) {
                e.get().setStatus(c.getStatus());
            }
             reservationRepository.save(e.get());
            return e.get();
        }else{
            return c;
        }

    }

    public Reservation save(Reservation c) {
        if (c.getIdReservation() == null) {
            return reservationRepository.save(c);
        } else {
            Optional<Reservation> e =  reservationRepository.getReservation(c.getIdReservation());
            if (e.isPresent()){
                return c;
            }else {
                return reservationRepository.save(c);
            }

        }


    }


    public boolean delete (int id ){
        boolean d = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;


    }



    public  List<Reservation> getReservationBetweenDatesReport(String fechaA , String fechaB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(fechaA);
            b = parser.parse(fechaB);
        }catch (ParseException exception){
            exception.printStackTrace();

        }
        if(a.before(b)){
            return reservationRepository.getReservationsBetweenDates(a,b);
        }else {
            return  new ArrayList<>();
        }

    }

    public CompletedAndCancelled getReservationStatusReport(){
    List<Reservation> completed = reservationRepository.getReservationsByStatus("completed");
    List<Reservation> cancelled = reservationRepository.getReservationsByStatus("cancelled");

    int cantidadCompletadas = completed.size();
    int cantidadCanceladas = cancelled.size();

    return  new CompletedAndCancelled ((long) cantidadCompletadas, (long) cantidadCanceladas);

    }


    public List<TotalAndClient> getTopClientsReport(){
        return reservationRepository.getTopClients();
}



}
