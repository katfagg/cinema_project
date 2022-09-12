package com.example.cinema_project.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customers")
public class Customer {

    @Column
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(
            name = "screenings_customers",
            joinColumns = {@JoinColumn(name = "customer_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "screening_id", nullable = false)}
    )
    private List<Screening> screenings;

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
