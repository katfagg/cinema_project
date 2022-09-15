package com.example.cinema_project.services;

import com.example.cinema_project.models.Cinema;
import com.example.cinema_project.models.Movie;
import com.example.cinema_project.models.Screen;
import com.example.cinema_project.repositories.CinemaRepository;
import com.example.cinema_project.repositories.MovieRepository;
import com.example.cinema_project.repositories.ScreenRepository;
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

    @Autowired
    ScreenRepository screenRepository;

    public List<Movie> getAllMovies(long cinemaId){
        Cinema cinema= cinemaRepository.findById(cinemaId).get();
        return cinema.getMovies();
    }

    public Cinema addNewMovieToCinema(Movie movie, long cinemaId){
        Cinema cinema= cinemaRepository.findById(cinemaId).get();
        List<Movie> movies = cinema.getMovies();
        movies.add(movie);
        cinema.setMovies(movies);
        movie.setCinema(cinema);
        movieRepository.save(movie);
        cinemaRepository.save(cinema);
        return cinema;
    }

    public Cinema addScreenToCinema(Screen screen, long cinemaId){
        Cinema cinema = cinemaRepository.findById(cinemaId). get();
        List<Screen> screens = cinema.getScreens();
        screens.add(screen);
        cinema.setScreens(screens);
        screen.setCinema(cinema);
        screenRepository.save(screen);
        cinemaRepository.save(cinema);
        return cinema;
    }

    public void cancelMovie(long id, long cinemaId){
        movieRepository.deleteById(id);
    }
    
    public Movie getMovieById(long id, long cinemaId){
        Cinema cinema = cinemaRepository.findById(cinemaId).get();
        List<Movie> movies = cinema.getMovies();
        for(Movie movie : movies){
            if(movie.getId() == id){
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getMovieByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> getMovieByTitle(String title){
        return movieRepository.findByTitle(title);
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
