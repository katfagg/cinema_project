package com.example.cinema_project.services;


import com.example.cinema_project.models.Customer;
import com.example.cinema_project.models.Screen;
import com.example.cinema_project.repositories.CustomerRepository;
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
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;


    public Screen addCustomerToScreen( long customerId, long screenId){
        Screen screen = screenRepository.findById(screenId).get();
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        List<Customer> customers = screen.getCustomers();
        customers.add(customer);
        screen.setCustomers(customer);
        screenRepository.save(screen);
        return screen;
    }


}
