package com.example.reto3.service;


import com.example.reto3.entities.Cinema;
import com.example.reto3.entities.Client;
import com.example.reto3.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAll(){
        return cinemaRepository.getAll();

    }
    public Optional<Cinema>getCinema(int id){
        return  cinemaRepository.getCinema(id);
    }

    public Cinema save(Cinema c) {
        if (c.getId() == null) {
            return cinemaRepository.save(c);
        } else {
            Optional<Cinema> e = cinemaRepository.getCinema(c.getId());
            if (e.isPresent()){
                return c;
            }else {
                return cinemaRepository.save(c);
            }

        }


    }

    public Cinema update(Cinema cinema) {
        if (cinema.getId() != null) {
            Optional<Cinema> e = cinemaRepository.getCinema(cinema.getId());
            if (e.isPresent()) {
                if (cinema.getName() != null) {
                    e.get().setName(cinema.getName());
                }
                if (cinema.getOwner() != null){
                    e.get().setOwner(cinema.getOwner());
                }
                if (cinema.getCapacity() != null) {
                    e.get().setCapacity(cinema.getCapacity());
                }
                if (cinema.getDescription() != null) {
                    e.get().setDescription(cinema.getDescription());
                }
                if (cinema.getCategory() != null) {
                    e.get().setCategory(cinema.getCategory());
                }
                cinemaRepository.save(e.get());
                return e.get();
            } else {
                return cinema;
            }
        }else{
            return cinema;
        }

    }



    public boolean delete (int id ){
        boolean d = getCinema(id).map(cinema -> {
            cinemaRepository.delete(cinema);
            return true;
        }).orElse(false);
        return d;


    }

}