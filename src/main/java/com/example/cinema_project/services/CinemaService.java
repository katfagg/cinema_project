package com.example.cinema_project.services;

import com.example.cinema_project.models.Cinema;
import com.example.cinema_project.models.Movie;
import com.example.cinema_project.models.Screen;
import com.example.cinema_project.repositories.CinemaRepository;
import com.example.cinema_project.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Cinema addNewMovieToCinema(Movie movie, long cinemaId){
        Cinema cinema= cinemaRepository.findById(cinemaId).get();
        List<Movie> movies = cinema.getMovies();
        movies.add(movie);
        cinema.setMovies(movies);
        cinemaRepository.save(cinema);
        //movieRepository.save(movie);
        return cinema;
    }

    public Cinema addScreenToCinema(Screen screen, long cinemaId){
        Cinema cinema = cinemaRepository.findById(cinemaId). get();
        List<Screen> screens = cinema.getScreens();
        screens.add(screen);
        cinema.setScreens(screens);
        cinemaRepository.save(cinema);
        return cinema;
    }

    public void cancelMovie(long id){
        movieRepository.deleteById(id);
    }
    
    public Optional<Movie> getMovieById(Long id){
        return movieRepository.findById(id);
    } 

    public List<Cinema> getAllCinemas(){
        return cinemaRepository.findAll();
    }

    public Optional<Cinema> getCinemaById(Long id){
        return cinemaRepository.findById(id);
    }

    public Cinema addNewCinema(Cinema cinema){
        cinemaRepository.save(cinema);
        return cinema;
    }
}
