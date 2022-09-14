package com.example.cinema_project.services;

import com.example.cinema_project.models.Customer;
import com.example.cinema_project.models.Movie;
import com.example.cinema_project.models.Screen;
import com.example.cinema_project.models.Screening;
import com.example.cinema_project.repositories.MovieRepository;
import com.example.cinema_project.repositories.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreeningService {

    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    ScreenService screenService;

    @Autowired
    CinemaService cinemaService;

    public List<Screening> getAllScreenings(){
        return screeningRepository.findAll();
    }

    public Screening getScreeningById(Long screeningId, Long screenId){
        Optional<Screen> screen = screenService.getScreenById(screenId);
        if(!screen.isPresent()) return null;
        List<Screening> screenings = screen.get().getScreenings();
        for(Screening screening : screenings){
            if(screening.getId() == screeningId){
                return screening;
            }
        }
        return null;
    }

    public Screening addNewScreening(Screening screening){
        screeningRepository.save(screening);
        return screening;
    }

    public Screening addCustomerToScreening(long customerId, Long screeningId){
        Screening screening = screeningRepository.findById(screeningId).get();
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        if(customer.isPresent()){
            List<Customer> customers = screening.getCustomers();
            customers.add(customer.get());
            screening.setCustomers(customers);
            screeningRepository.save(screening);
        }
        return screening;
    }


    public Screening addMovieToScreening(long movieId, long screeningId, long screenId, long cinemaId){
        Optional<Screening> screening = screeningRepository.findById(screeningId);
        Movie movie = cinemaService.getMovieById(movieId, cinemaId);
        Optional<Screen> screen = screenService.getScreenById(screenId);
        if (!screen.isPresent()){
            return null;
        }
        if(screening.isPresent()){
            if(movie != null){
                screening.get().setMovie(movie);
                movie.getScreenings().add(screening.get());
                List<Screening> screenings = movie.getScreenings();
                screenings.add(screening.get());
                movie.setScreenings(screenings);
                movieRepository.save(movie);
                screeningRepository.save(screening.get());
                screenService.addScreeningToScreen(screenId, screeningId);
            }
            return screening.get();
        }else{
            return null;
                }
            }




    public Screening removeMovieFromScreening(long movieId, long screeningId, long screenId, long cinemaId){
        Optional<Screening> screening = screeningRepository.findById(screeningId);
        Movie movie = cinemaService.getMovieById(movieId, cinemaId);
        if(screening.isPresent()){
            if(movie != null){
                screening.get().setMovie(null);
                screeningRepository.save(screening.get());
                screenService.addScreeningToScreen(screenId, screeningId);
            }
            return screening.get();
        }else{
            return null;
        }
    }
}
