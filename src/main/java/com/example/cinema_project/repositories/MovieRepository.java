package com.example.cinema_project.repositories;

import com.example.cinema_project.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
