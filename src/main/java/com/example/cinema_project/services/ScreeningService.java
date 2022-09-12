package com.example.cinema_project.services;

import com.example.cinema_project.models.Customer;
import com.example.cinema_project.models.Screening;
import com.example.cinema_project.repositories.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ScreeningService {

    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    CustomerService customerService;

    public Screening addCustomerToScreening(Long customerId, Long screeningId){
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
}
