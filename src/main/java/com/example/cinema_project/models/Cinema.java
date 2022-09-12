package com.example.cinema_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
public class Cinema {

        private long id;
        private String branch;


        public Movie(String title, int length, int releaseDate, String genre) {
            this.title = title;
            this.length = length;
            this.releaseDate = releaseDate;
            this.genre = genre;
        }
}
