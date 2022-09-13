package com.example.cinema_project.services;

import com.example.cinema_project.models.Movie;
import com.example.cinema_project.models.Screen;
import com.example.cinema_project.models.Screening;
import com.example.cinema_project.repositories.MovieRepository;
import com.example.cinema_project.repositories.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {
    @Autowired
    static
    MovieRepository movieRepository;
    @Autowired
    ScreenRepository screenRepository;
    @Autowired
    ScreenService screenService;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie addNewMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    public void cancelMovie(long id){
        movieRepository.deleteById(id);
    }

//    public Screen addNewScreen(Screen screen){
//        screenRepository.save(screen);
//        return screen;
//    }

//    public Screen addMovieToScreen(long screenId, long movieId){
//        Screen screen = screenRepository.findById(screenId).get();
//        Movie movie = movieService.getMovieById(movieId);
//        List<Movies> movies = screen.getMovies();
//        movies.add(movie);
//        screen.setMovies(movies);
//        screenRepository.save(movie);
//        return screen;
//    }



    public void removeScreen(long id){
        screenRepository.deleteById(id);
    }

    public List<Screen> getAllScreens(){
        return screenRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id){
        return movieRepository.findById(id);
    } 


}
