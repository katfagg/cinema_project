package com.example.cinema_project.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity(name = "screens")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "capacity")
    private int capacity;

//    @Column
//    private List<Movie> movies;

    @OneToMany(mappedBy = "screen")
    @JsonIgnoreProperties({"screen"})
    List<Screening> screenings;

    public Screen(int capacity) {
        this.capacity = capacity;
        this.screenings = new ArrayList<>();
    }

    public Screen(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

//    public List<Movie> getMovies() {
//        return movies;
//    }
//
//    public void setMovies(List<Movie> movies) {
//        this.movies = movies;
//    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }
}