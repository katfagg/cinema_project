package com.example.cinema_project.repositories;

import com.example.cinema_project.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
