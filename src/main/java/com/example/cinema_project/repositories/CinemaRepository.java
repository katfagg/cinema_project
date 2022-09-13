package com.example.cinema_project.repositories;

import com.example.cinema_project.models.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
