package com.example.cinema_project.repositories;

import org.springframework.stereotype.Repository;
import com.example.cinema_project.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {

    }


