package com.example.cinema_project.controllers;

import com.example.cinema_project.models.Screen;
import com.example.cinema_project.models.Screening;
import com.example.cinema_project.services.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/screens")
public class ScreenController {

    @Autowired
    ScreenService screenService;

    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreens(){
        List<Screen> screens = screenService.getAllScreens();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Long id){
        Optional<Screen> screen = screenService.getScreenById(id);
        if(screen.isPresent()){
            return new ResponseEntity<>(screen.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Screen> addNewScreen(@RequestBody Screen screen){
        Screen savedScreen = screenService.addNewScreen(screen);
        return new ResponseEntity<>(savedScreen, HttpStatus.CREATED);
    }
}
