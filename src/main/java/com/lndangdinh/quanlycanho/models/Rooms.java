package com.lndangdinh.quanlycanho.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "room_number")
    private String room_number;
    @Column(name = "capacity")
    private int capital;
    @Column(name = "price")
    private double price;
    @Column(name = "status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "room_type_id", referencedColumnName = "id")
    private RoomType roomType;
    @OneToMany(mappedBy = "rooms", fetch = FetchType.EAGER)
    private Set<Reservations> reservations;

    public Rooms() {
    }
    public Rooms(int id, String room_number, int capital, double price, boolean status, RoomType roomType, Set<Reservations> reservations) {
        this.id = id;
        this.room_number = room_number;
        this.capital = capital;
        this.price = price;
        this.status = status;
        this.roomType = roomType;
        this.reservations = reservations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Set<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservations> reservations) {
        this.reservations = reservations;
    }
}
