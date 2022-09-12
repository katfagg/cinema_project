package com.example.cinema_project.repositories;

import com.example.cinema_project.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
}
