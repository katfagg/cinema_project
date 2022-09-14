package com.example.cinema_project.services;


import com.example.cinema_project.models.Movie;
import com.example.cinema_project.models.Screen;
import com.example.cinema_project.models.Screening;
import com.example.cinema_project.repositories.MovieRepository;
import com.example.cinema_project.repositories.ScreenRepository;
import com.example.cinema_project.repositories.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenService {

    @Autowired
    ScreenRepository screenRepository;
    @Autowired
    ScreeningRepository screeningRepository;

    public Screen addScreeningToScreen(long screenId, long screeningId){
        Optional<Screen> screen = screenRepository.findById(screenId);
        Optional<Screening> screening = screeningRepository.findById(screeningId);
        if(!screen.isPresent()) return null;
        if(screening.isPresent()) {
            List<Screening> screenings = screen.get().getScreenings();
            screenings.add(screening.get());
            screen.get().setScreenings(screenings);
            screenRepository.save(screen.get());

        }
        return screen.get();
    }

    public void removeScreeningFromScreen(long screenId, long screeningId){
        Optional<Screen> screen = screenRepository.findById(screenId);
        Optional<Screening> screening = screeningRepository.findById(screeningId);
        if(!screen.isPresent()) return;
        if(screening.isPresent()) {
            List<Screening> screenings = screen.get().getScreenings();
            screenings.remove(screening.get());
            screen.get().setScreenings(screenings);
            screenRepository.save(screen.get());
        }
    }

    public List<Screen> getAllScreens(){
        return screenRepository.findAll();
    }


    public Optional<Screen> getScreenById(long id){
        return screenRepository.findById(id);
    }

//    todo: whether we need it here for screenController or addScreenToCinema in cinemaService would be fine?
    public Screen addNewScreen(Screen screen){
        screenRepository.save(screen);
        return screen;
    }

//    todo: remove screen from cinema: similar logic to addMovieToCinema? probably need to be in cinemaService?
    public void removeScreen(long id){
        screenRepository.deleteById(id);
    }

    }





