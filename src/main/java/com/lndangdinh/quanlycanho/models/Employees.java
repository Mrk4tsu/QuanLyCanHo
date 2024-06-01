package com.lndangdinh.quanlycanho.models;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "position")
    private String position;
    @OneToMany(mappedBy = "employees")
    private Set<Payments> payments;

    @OneToMany(mappedBy = "employees")
    private Set<Reservations> reservations;

    public Employees() {
    }

    public Employees(int id, String first_name, String last_name, String email, String phone, String address, String position, Set<Payments> payments, Set<Reservations> reservations) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.position = position;
        this.payments = payments;
        this.reservations = reservations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Payments> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payments> payments) {
        this.payments = payments;
    }

    public Set<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservations> reservations) {
        this.reservations = reservations;
    }
}
