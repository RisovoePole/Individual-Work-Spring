package com.ScheduleGen.controllers;

import com.ScheduleGen.api.dtos.CreateRequestDTOs.CreateDisciplineDTO;
import com.ScheduleGen.api.dtos.PatchRequestDTOs.PatchDisciplineDTO;
import com.ScheduleGen.api.dtos.ResponseDTOs.DisciplineDTO;
import com.ScheduleGen.api.dtos.UpdateRequestDTOs.UpdateDisciplineDTO;
import com.ScheduleGen.model.services.DisciplineService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
public class DisciplinesController {

    private final DisciplineService service;

    public DisciplinesController(DisciplineService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DisciplineDTO> create(@Valid @RequestBody CreateDisciplineDTO discipline){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(discipline));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineDTO> get(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(service.getDiscipline(id));
    }

    @GetMapping
    public ResponseEntity<List<DisciplineDTO>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAll());
    }

    @PatchMapping
    public ResponseEntity<DisciplineDTO> patch(@Valid @RequestBody PatchDisciplineDTO discipline){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.patch(discipline));
    }

    @PutMapping
    public ResponseEntity<DisciplineDTO> update(@Valid @RequestBody UpdateDisciplineDTO discipline){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.update(discipline));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DisciplineDTO> delete(@NotNull @Positive @PathVariable Integer id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.deleteById(id));
    }
}
