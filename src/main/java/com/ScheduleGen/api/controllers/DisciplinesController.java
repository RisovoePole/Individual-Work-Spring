package com.ScheduleGen.api.controllers;


import com.ScheduleGen.infrastructure.persistence.repos.DisciplineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplines")
public class DisciplinesController {

    @Autowired
    private DisciplineRepo disciplineRepo;

    @GetMapping
    public ResponseEntity<String> list(){
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(disciplineRepo.findAll().toString());
    }
}
