package com.example.cinema_project.services;


import com.example.cinema_project.repositories.MovieRepository;
import com.example.cinema_project.repositories.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ScreenRepository screenRepository;


}
