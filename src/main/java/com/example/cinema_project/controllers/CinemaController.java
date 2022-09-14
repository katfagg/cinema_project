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
@RequestMapping(value = "/cinemas")
public class CinemaController {
    

    @Autowired
    CinemaService cinemaService;

    @GetMapping
    public ResponseEntity<List<Cinema>> getAllCinemas() {
        List<Cinema> cinemas = cinemaService.getAllCinemas();
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cinema> getCinemaById(@PathVariable long id){
        Optional<Cinema> cinema = cinemaService.getCinemaById(id);
        if(cinema.isPresent()){
            return new ResponseEntity<>(cinema.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/movies")
    public ResponseEntity<List<Movie>> getAllMovies(@PathVariable long id) {
        List<Movie> movies = cinemaService.getAllMovies(id);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}/movies/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id, @PathVariable long movieId){
        Movie movie = cinemaService.getMovieById(movieId, id);
        if(movie != null){
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelMovie(@PathVariable long id) {
        cinemaService.cancelMovie(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }
    
    @PostMapping(value = "/{id}/movies")
    public ResponseEntity<Cinema> addMovieToCinema(@RequestBody Movie movie, @PathVariable long id){
        Cinema newMovie = cinemaService.addNewMovieToCinema(movie, id);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    @PostMapping(value = "/{id}/screens")
    public ResponseEntity<Cinema> addScreenToCinema(@RequestParam Screen screen, @PathVariable long id){
        Cinema newScreen = cinemaService.addScreenToCinema(screen, id);
        return new ResponseEntity<>(newScreen, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Cinema> createCinema(@RequestBody Cinema cinema) {
        Cinema savedCinema = cinemaService.addNewCinema(cinema);
        return new ResponseEntity<>(savedCinema, HttpStatus.CREATED);
    }


//    todo: remove screen from cinema
//    @DeleteMapping
//    public ResponseEntity deleteScreen(long id){
//        screenService.removeScreen(id);
//        return new ResponseEntity<>(null. HttpStatus.NO_CONTENT);
//    }

}