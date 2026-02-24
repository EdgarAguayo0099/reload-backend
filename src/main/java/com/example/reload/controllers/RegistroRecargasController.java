package com.example.reload.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.reload.models.RegistroRecargas;
import com.example.reload.repositories.RegistroRecargasRepository;

@RestController
@CrossOrigin("*") // 👈 IMPORTANTE para Flutter Web
public class RegistroRecargasController {

    private final RegistroRecargasRepository registroRecargasRepository;

    public RegistroRecargasController(RegistroRecargasRepository repository) {
        this.registroRecargasRepository = repository;
    }

    // ================= GUARDAR =================
    @PostMapping("/saveRegistroRecargas")
    public RegistroRecargas save(@RequestBody RegistroRecargas b) {
        return this.registroRecargasRepository.save(b);
    }

    // ================= LISTAR =================
    @GetMapping("/findAllRegistroRecargas")
    public Iterable<RegistroRecargas> findAllRegistroRecargas() {
        return this.registroRecargasRepository.findAll();
    }

    // ================= ELIMINAR =================
    @DeleteMapping("/deleteRegistroRecargas/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        if (!registroRecargasRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        registroRecargasRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

