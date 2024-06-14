package com.certus.edu.pe.controller;

import com.certus.edu.pe.modelo.Curso;
import com.certus.edu.pe.servicios.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/")
    public List<Curso> findAll() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Curso> findById(@PathVariable Integer id) {
        return cursoService.findById(id);
    }

    @PostMapping("/")
    public Curso save(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        cursoService.deleteById(id);
    }
}
