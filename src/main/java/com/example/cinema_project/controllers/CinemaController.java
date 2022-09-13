package com.example.cinema_project.controllers;


import com.example.cinema_project.models.Movie;
import com.example.cinema_project.models.Screen;
import com.example.cinema_project.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies and screens")
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

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
        Movie savedMovie = cinemaService.addCustomerToMovie(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PostMapping(value="/cinema")
    public ResponseEntity<Screen> createScreen(@RequestBody Screen newScreen){
        Screen screen = cinemaService.addNewScreen(newScreen);
        return new ResponseEntity<>(newScreen, HttpStatus.CREATED);



