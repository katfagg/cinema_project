package com.example.cinema_project.repositories;

import com.example.cinema_project.models.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}
