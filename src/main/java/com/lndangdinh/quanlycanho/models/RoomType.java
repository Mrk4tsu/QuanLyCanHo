package com.lndangdinh.quanlycanho.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "room_types")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "roomType")
    private Set<Rooms> products;

    public RoomType(int id, String name, Set<Rooms> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public RoomType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Set<Rooms> getProducts() {
        return products;
    }

    public void setProducts(Set<Rooms> products) {
        this.products = products;
    }

}
