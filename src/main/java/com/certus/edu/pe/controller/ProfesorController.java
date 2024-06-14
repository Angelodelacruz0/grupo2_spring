package com.certus.edu.pe.controller;

import com.certus.edu.pe.modelo.Profesor;
import com.certus.edu.pe.servicios.ProfesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping("/")
    public List<Profesor> findAll() {
        return profesorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Profesor> findById(@PathVariable Integer id) {
        return profesorService.findById(id);
    }

    @PostMapping("/")
    public Profesor save(@RequestBody Profesor profesor) {
        return profesorService.save(profesor);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        profesorService.deleteById(id);
    }
}
