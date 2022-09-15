package com.example.cinema_project.repositories;

import com.example.cinema_project.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);

    List<Movie> findByTitle(String title);
}
