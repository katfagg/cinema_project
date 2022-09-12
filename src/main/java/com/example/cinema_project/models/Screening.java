package com.example.cinema_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "screenings")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "screen_id")
    @JsonIgnoreProperties({"screenings"})
    private Screen screen;

    @ManyToMany
    @JoinTable(
            name = "screenings_customers",
            joinColumns = {@JoinColumn(name = "screening_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "customer_id", nullable = false)}
    )
    @JsonIgnoreProperties({"screenings"})
    private List<Customer> customers;

    public Screening(Movie movie, Screen screen) {
        this.movie = movie;
        this.screen = screen;
        this.customers = new ArrayList<>();
    }

    public Screening(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
