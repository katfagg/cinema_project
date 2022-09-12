package com.example.cinema_project.services;

import com.example.cinema_project.models.Customer;
import com.example.cinema_project.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(long id){
        return customerRepository.findById(id);
    }

    public Customer addCustomer(Customer customer){
        customerRepository.save(customer);
        return customer;
    }
}
