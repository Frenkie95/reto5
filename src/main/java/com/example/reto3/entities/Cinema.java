package com.example.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cinema")

public class Cinema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String owner;

    private Integer capacity;
    private String description;


    @ManyToOne
    @JoinColumn(name = "categoryID")
    @JsonIgnoreProperties("cinemas")
    private Category category;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cinema")
    @JsonIgnoreProperties({"cinema","client"})
    private List<Message> messages;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cinema")
    @JsonIgnoreProperties({"cinema","messages"})
    private List<Reservation>reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}

