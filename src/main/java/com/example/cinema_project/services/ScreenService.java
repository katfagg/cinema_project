package com.example.cinema_project.services;


import com.example.cinema_project.models.Movie;
import com.example.cinema_project.models.Screen;
import com.example.cinema_project.repositories.MovieRepository;
import com.example.cinema_project.repositories.ScreenRepository;
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


    public Screen addMovieToScreen(long movieId, long screenId){
        Screen screen = screenRepository.findById(screenId).get();
        Optional<Movie> movie = cinemaService.getMovieById(movieId);
        List<Movie> movies = screen.getMovies();
        movies.add(movie);
        screen.setMovies(movie);
        screenRepository.save(movie);
        return screen;
    }


}
