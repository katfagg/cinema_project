package com.example.cinema_project.models;

import java.util.ArrayList;
import java.util.List;

public class Screening {

    private Long id;

    private Movie movie;

    private Screen screen;

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
