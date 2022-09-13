package com.example.cinema_project.controllers;


import com.example.cinema_project.models.*;
import com.example.cinema_project.services.CinemaService;
import com.example.cinema_project.services.CustomerService;
import com.example.cinema_project.services.ScreenService;
import com.example.cinema_project.services.ScreeningService;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    CinemaService cinemaService;
    @Autowired
    CustomerService customerService;

    @Autowired
    ScreenService screenService;
    @Autowired
    ScreeningService screeningService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = cinemaService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id){
        Optional<Movie> movie = cinemaService.getMovieById(id);
        if(movie.isPresent()){
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelMovie(@PathVariable long id) {
        cinemaService.cancelMovie(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

//    @PatchMapping(value = "/screenings/{id}")
//    public ResponseEntity<Screening> addCustomerToScreening(@PathVariable long screeningId, @RequestParam long customerId) {
//        Screening updatedScreening = screeningService.addCustomerToScreening(customerId, screeningId);
//        return new ResponseEntity<>(updatedScreening, HttpStatus.OK);
////        screening = ScreeningService.addCustomerToScreening(screening);
////        return new ResponseEntity<>(movie, HttpStatus.CREATED);
//    }

//    @PatchMapping(value = "/screenings/{id}")
//    public ResponseEntity<Screening> addMultiParamsToScreening(
//            @PathVariable long screeningId,
//            @RequestParam Optional<Long> customerId,
//            @RequestParam Optional<Long> screenId,
//            @RequestParam Optional<Long> movieId
//    ) {
//        Optional<Screening> screening = screeningService.getScreeningById(screeningId);
//        if(screening.isPresent()){
//            Screening updatedScreening;
//            if(customerId.isPresent()){
//                updatedScreening = screeningService.addCustomerToScreening(customerId.get(), screeningId);
//                return new ResponseEntity<>(updatedScreening, HttpStatus.OK);
//            }else if(screenId.isPresent() && movieId.isPresent()){
//                updatedScreening = screeningService.addMovieToScreening(movieId.get(),screeningId, screenId.get());
//                return new ResponseEntity<>(updatedScreening, HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }

    @PatchMapping
    public ResponseEntity<Screen> addScreen(@RequestBody Screen newScreen) {
        Screen screen = screenService.addNewScreen(newScreen);
        return new ResponseEntity<>(screen, HttpStatus.OK);
    }

    @PatchMapping(value = "/movie")
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie){
        Movie savedMovie = cinemaService.addNewMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cinema> createCinema(@RequestBody String branch) {
        Cinema cinema = new Cinema(branch);
        return new ResponseEntity<>(cinema, HttpStatus.CREATED);
    }

//    @DeleteMapping
//    public ResponseEntity deleteScreen(long id){
//        screenService.removeScreen(id);
//        return new ResponseEntity<>(null. HttpStatus.NO_CONTENT);
//    }

}