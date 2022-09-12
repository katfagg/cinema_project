package com.example.cinema_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class Cinema {

        private long id;
        private String branch;
        private List<Movie> movies;
        private List<Screen> screens;

    public Cinema(String branch) {
        this.branch = branch;
        this.movies = new ArrayList<>();
        this.screens = new ArrayList<>();
    }

    public Cinema() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
