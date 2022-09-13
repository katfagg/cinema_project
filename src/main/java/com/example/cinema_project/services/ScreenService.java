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
    MovieRepository movieRepository;

    @Autowired
    ScreenRepository screenRepository;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    ScreeningService screeningService;

    @Autowired
    ScreeningRepository screeningRepository;





    public Screen addScreeningToScreen(long screenId, long screeningId){
        Screen screen = screenRepository.findById(screenId).get();
        Optional<Screening> screening = screeningService.getScreeningById(screeningId);
        List<Screening> screenings = screen.getScreenings();
        screenings.add(screening.get());
        screen.setScreenings(screenings);
        screenRepository.save(screen);
        return screen;
    }

    public void removeScreeningFromScreen(long screenId, long screeningId){
        Screen screen = screenRepository.findById(screenId).get();
        Optional<Screening> screening = screeningService.getScreeningById(screeningId);
        List<Screening> screenings = screen.getScreenings();
        screenings.remove(screening.get());
        screen.setScreenings(screenings);
        screenRepository.save(screen);
    }




    public List<Screen> getAllScreens(){
        return screenRepository.findAll();
    }


    public Optional<Screen> getScreenById(long id){
        return screenRepository.findById(id);
    }

    public Screen addNewScreen(Screen screen){
        screenRepository.save(screen);
        return screen;
    }

    public void removeScreen(long id){
        screenRepository.deleteById(id);
    }

    }





