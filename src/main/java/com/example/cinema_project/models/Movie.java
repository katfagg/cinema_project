package com.example.cinema_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String title;
    @Column
    private int length;
    @Column
    private int releaseDate;
    @Column
    private String genre;
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    @JsonIgnoreProperties({"movies"})
    private Cinema cinema;

    @OneToMany(mappedBy = "movie")
    @JsonIgnoreProperties({"movie"})
    private List<Screening> screenings;

    public Movie(String title, int length, int releaseDate, String genre, Cinema cinema) {
        this.title = title;
        this.length = length;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.screenings = new ArrayList<>();
        this.cinema = cinema;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
