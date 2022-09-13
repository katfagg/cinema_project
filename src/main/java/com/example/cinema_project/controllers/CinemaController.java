package com.example.cinema_project.controllers;


import com.example.cinema_project.models.Movie;
import com.example.cinema_project.models.Screen;
import com.example.cinema_project.services.CinemaService;
import com.example.cinema_project.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies and screens")
public class CinemaController {

    @Autowired
    CinemaService cinemaService;
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = cinemaService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelMovie(@PathVariable long id){
        CinemaService.cancelMovie(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Movie> addCustomerToMovie(@RequestBody Movie movie){
        Movie savedMovie = customerService.addCustomerToMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @PostMapping(value="/cinema")
    public ResponseEntity<Screen> createScreen(@RequestBody Screen newScreen){
        List<Screen> screen = cinemaService.addNewScreen(newScreen);
        return new ResponseEntity<>(newScreen, HttpStatus.CREATED);



