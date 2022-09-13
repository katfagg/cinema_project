package com.example.cinema_project.controllers;


import com.example.cinema_project.models.Customer;
import com.example.cinema_project.models.Movie;
import com.example.cinema_project.models.Screen;
import com.example.cinema_project.models.Screening;
import com.example.cinema_project.services.CinemaService;
import com.example.cinema_project.services.CustomerService;
import com.example.cinema_project.services.ScreeningService;
import org.apache.catalina.Service;
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

    @Autowired
    ScreeningService screeningService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = cinemaService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelMovie(@PathVariable long id) {
        cinemaService.cancelMovie(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/screenings/{id}")
    public ResponseEntity<Screening> addCustomerToScreening(@PathVariable  long id, @RequestBody Screening screening) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        if(customer.isPresent()){
            Screening updatedScreening = screeningService.addCustomerToScreening(customer.get(), screening.getId());
            return new ResponseEntity<>(updatedScreening, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
//        screening = ScreeningService.addCustomerToScreening(screening);
//        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @PostMapping(value = "/cinema")
    public ResponseEntity<Screen> createScreen(@RequestBody Screen newScreen) {
        Screen screen = cinemaService.addNewScreen(newScreen);
        return new ResponseEntity<>(newScreen, HttpStatus.CREATED);


    }
}