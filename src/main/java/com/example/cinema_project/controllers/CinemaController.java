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
@RequestMapping("/cinemas")
public class CinemaController {

//    1. cinemaRepo (done)
//    2. cinemaService => addMovie => add movie to cinema movie List (tariq)
//    3. cinemaService => addScreenToCinema => add to list (kat)
//    4. cinemaController => PostMapping(/{id}/screens) (kat)
//    5. cinemaService => getAllCinemas/id/add
//    6. cinemaController => getAllCinemas...

    @Autowired
    CinemaService cinemaService;

    @Autowired
    ScreenService screenService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = cinemaService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/movies/{id}")
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

    @PostMapping(value = "/{id}/movies")
    public ResponseEntity<Cinema> addMovieToCinema(@RequestBody Movie movie, @PathVariable long id){
        Cinema newMovie = cinemaService.addNewMovieToCinema(movie, id);
        return new ResponseEntity<>(newMovie, HttpStatus.OK);
    }

    @PostMapping("/{id}/screens")
    public ResponseEntity<Cinema> addScreenToCinema(@RequestBody Screen screen, @PathVariable long id){
        Cinema newScreen = cinemaService.addScreenToCinema(screen, id);
        return new ResponseEntity<>(newScreen, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cinema> createCinema(@RequestBody Cinema cinema) {
        Cinema savedCinema = cinemaService.addNewCinema(cinema);
        return new ResponseEntity<>(savedCinema, HttpStatus.CREATED);
    }

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



//    @DeleteMapping
//    public ResponseEntity deleteScreen(long id){
//        screenService.removeScreen(id);
//        return new ResponseEntity<>(null. HttpStatus.NO_CONTENT);
//    }

}