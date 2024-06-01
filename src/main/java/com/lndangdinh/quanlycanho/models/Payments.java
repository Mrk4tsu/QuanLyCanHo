package com.lndangdinh.quanlycanho.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "payments")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "payment_date")
    private Date payment_date;
    @Column(name = "amount")
    private double amount;
    @Column(name = "payment_method")
    private String payment_method;

    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "id")
    private Employees employees;

    @ManyToOne
    @JoinColumn(name = "reservationId", referencedColumnName = "id")
    private Reservations reservations;

    public Payments() {
    }
    public Payments(int id, Date payment_date, double amount, String payment_method, Employees employees, Reservations reservations) {
        this.id = id;
        this.payment_date = payment_date;
        this.amount = amount;
        this.payment_method = payment_method;
        this.employees = employees;
        this.reservations = reservations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Reservations getReservations() {
        return reservations;
    }

    public void setReservations(Reservations reservations) {
        this.reservations = reservations;
    }
}

