package com.example.cinema_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@Entity(name = "cinema")
public class Cinema {

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
        @ManyToMany
        @JoinTable(
                name = "screenings",
                joinColumns = {@JoinColumn(name = "movie_id", nullable = false)},
                inverseJoinColumns = {@JoinColumn(name = "screen_id", nullable = false)}
        )
        @JsonIgnoreProperties({"movies"})
        private List<Screen> screens;

        public Movie(String title, int length, int releaseDate, String genre) {
            this.title = title;
            this.length = length;
            this.releaseDate = releaseDate;
            this.genre = genre;
        }
}
