package com.lndangdinh.quanlycanho.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "reservations")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Rooms rooms;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customers customers;
    @Column(name = "check_in")
    private Date check_in;
    @Column(name = "check_out")
    private Date check_out;
    @Column(name = "total_price")
    private double total_price;
    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "reservations")
    private Set<Payments> payments;
    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "id")
    private Employees employees;
    public Reservations() {
    }

    public Reservations(int id, Rooms rooms, Customers customers, Date check_in, Date check_out, double total_price, String status, Set<Payments> payments, Employees employees) {
        this.id = id;
        this.rooms = rooms;
        this.customers = customers;
        this.check_in = check_in;
        this.check_out = check_out;
        this.total_price = total_price;
        this.status = status;
        this.payments = payments;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Payments> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payments> payments) {
        this.payments = payments;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
