package com.example.cinema_project.components;

import com.example.cinema_project.CinemaProjectApplication;
import com.example.cinema_project.models.Customer;
import com.example.cinema_project.models.Movie;
import com.example.cinema_project.models.Screening;
import com.example.cinema_project.repositories.CustomerRepository;
import com.example.cinema_project.repositories.MovieRepository;
import com.example.cinema_project.repositories.ScreenRepository;
import com.example.cinema_project.repositories.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class Dataloader implements CinemaProjectApplication {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    ScreenRepository screenRepository;




    public void run(ApplicationArguments args) throws Exception {

        Customer customer = new Customer("Tariq");
        Customer customer = new Customer("Yongran");
        Customer customer = new Customer("Kat");
        Customer customer = new Customer("Guy");

        // List<String> customersList = Arrays.asList(

        //        "Tariq",
        //      "Yongran",
        //       "Kat",
        //       "Guy"

        //);

        // for (String customerName : customersList) {
        //      Customer customer = new Customer(customerName);
        //     customerRepository.save(customer);
        // }

        Movie movie = new Movie("Movie1", 100, 2000, "Action");
        Movie movie = new Movie("Movie1", 100, 2000, "Action");
        Movie movie = new Movie("Movie1", 100, 2000, "Action");
        Movie movie = new Movie("Movie1", 100, 2000, "Action");







    }




}
