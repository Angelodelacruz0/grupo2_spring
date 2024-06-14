package com.certus.edu.pe.controller;

import com.certus.edu.pe.modelo.Estudiante;
import com.certus.edu.pe.servicios.EstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/")
    public List<Estudiante> findAll() {
        return estudianteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Estudiante> findById(@PathVariable Integer id) {
        return estudianteService.findById(id);
    }

    @PostMapping("/")
    public Estudiante save(@RequestBody Estudiante estudiante) {
        return estudianteService.save(estudiante);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        estudianteService.deleteById(id);
    }
}
