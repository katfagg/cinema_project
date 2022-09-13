package com.example.cinema_project.services;

import com.example.cinema_project.models.Customer;
import com.example.cinema_project.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(long id){
        return customerRepository.findById(id);
    }

    public Customer addNewCustomer(Customer customer){
        customerRepository.save(customer);
        return customer;
    }
}
