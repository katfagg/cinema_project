package com.example.cinema_project.controllers;

import com.example.cinema_project.models.Screen;
import com.example.cinema_project.models.Screening;
import com.example.cinema_project.repositories.CustomerRepository;
import com.example.cinema_project.services.ScreenService;
import com.example.cinema_project.services.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/screens")
public class ScreenController {

    @Autowired
    ScreenService screenService;

    @Autowired
    ScreeningService screeningService;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreens(){
        List<Screen> screens = screenService.getAllScreens();
        return new ResponseEntity<>(screens, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Long id){
        Optional<Screen> screen = screenService.getScreenById(id);
        if(screen.isPresent()){
            return new ResponseEntity<>(screen.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/screenings")
    public ResponseEntity<List<Screening>> getAllScreenings(){
        List<Screening> screenings = screeningService.getAllScreenings();
        return new ResponseEntity<>(screenings, HttpStatus.OK);
    }

    @GetMapping("/{screenId}/screenings/{id}")
    public ResponseEntity<Screening> getScreeningById(@PathVariable Long screenId, @PathVariable Long id){
        Screening screening = screeningService.getScreeningById(id, screenId);
        if(screening != null){
            return new ResponseEntity<>(screening, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Screen> addNewScreen(@RequestBody Screen screen){
        Screen savedScreen = screenService.addNewScreen(screen);
        return new ResponseEntity<>(savedScreen, HttpStatus.CREATED);
    }


    @PostMapping(value = "/{screenId}")
    public ResponseEntity<Screen> addScreeningToScreen(@PathVariable long screenId, @RequestParam long screeningId){
        Screen screen = screenService.addScreeningToScreen(screenId, screeningId);
        return new ResponseEntity<>(screen, HttpStatus.CREATED);
    }

    @PostMapping(value = "/{screenId}/screenings/{screeningId}")
    public ResponseEntity<Screening> addMultiParamToScreening(
            @PathVariable long screeningId,
            @PathVariable long screenId,
            @RequestParam Optional<Long> cinemaId,
            @RequestParam Optional<Long> customerId,
            @RequestParam Optional<Long> movieId
    ) {
        Screening screening = screeningService.getScreeningById(screeningId, screenId);
        if(screening != null){
            Screening updatedScreening;
            if(customerId.isPresent()){
                updatedScreening = screeningService.addCustomerToScreening(customerId.get(), screeningId);
                return new ResponseEntity<>(updatedScreening, HttpStatus.CREATED);
            }else if(movieId.isPresent()){
                updatedScreening = screeningService.addMovieToScreening(movieId.get(),screeningId, screenId,cinemaId.get());
                if (updatedScreening == null){
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(updatedScreening, HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{screenId}")
    public ResponseEntity removeScreeningOrMovieFromScreen(
            @PathVariable long screenId,
            @RequestParam long cinemaId,
            @RequestParam long screeningId,
            @RequestParam Optional<Long> movieId
    ){
        if(movieId.isPresent()){
            screeningService.removeMovieFromScreening(movieId.get(),screeningId,screenId,cinemaId);
        }else{
            screenService.removeScreeningFromScreen(screenId, screeningId);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
