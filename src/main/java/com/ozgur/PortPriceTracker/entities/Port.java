package com.ozgur.PortPriceTracker.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "ports")
public class Port {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "unlocode")
    private String unLoCode;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "city_id")
    @JsonBackReference
    private City city;

    public Port() {
    }

    public Port(long id, String name, String unLoCode, City city) {
        this.id = id;
        this.name = name;
        this.unLoCode = unLoCode;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnLoCode() {
        return unLoCode;
    }

    public void setUnLoCode(String unLoCode) {
        this.unLoCode = unLoCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
