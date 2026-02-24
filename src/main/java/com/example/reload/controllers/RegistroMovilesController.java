package com.example.reload.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.reload.models.RegistroMoviles;
import com.example.reload.repositories.RegistroMovilesRepository;

@RestController
@CrossOrigin(origins = "*")
public class RegistroMovilesController {

    private final RegistroMovilesRepository registroMovilesRepository;

    public RegistroMovilesController(RegistroMovilesRepository repository) {
        this.registroMovilesRepository = repository;
    }

    @PostMapping("/saveRegistroMovil")
    public RegistroMoviles save(@RequestBody RegistroMoviles b) {
        return this.registroMovilesRepository.save(b);
    }

    @GetMapping("/findAllRegistroMovil")
    public Iterable<RegistroMoviles> findAllRegistroMoviles() {
        return this.registroMovilesRepository.findAll();
    }

    @DeleteMapping("/deleteRegistroMovil/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        registroMovilesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}