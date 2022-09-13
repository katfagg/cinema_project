package com.example.cinema_project.services;

import com.example.cinema_project.models.Movie;
import com.example.cinema_project.models.Screen;
import com.example.cinema_project.repositories.MovieRepository;
import com.example.cinema_project.repositories.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ScreenRepository screenRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public List<Movie> addNewMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    public List<Movie> cancelMovie(long id){
        movieRepository.deleteById(id);
    }

    public List<Screen> addNewScreen(Screen screen){
        screenRepository.save(screen);
        return screen;
    }

    public Screen addMovieToScreen(long screenId, long movieId){
        Screen screen = screenRepository.findById(screenId).get();
        Movie movie = movieService.getMovieById(movieId);
        List<Movies> movies = screen.getMovies();
        movies.add(movie);
        screen.setMovies(movies);
        screenRepository.save(movie);
        return screen;
    }



    public List<Screen> removeScreen(long id){
        screenRepository.deleteById(id);
    }


}
