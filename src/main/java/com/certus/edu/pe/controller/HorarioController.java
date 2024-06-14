package com.certus.edu.pe.controller;

import com.certus.edu.pe.modelo.horarios;
import com.certus.edu.pe.servicios.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping("/")
    public List<horarios> findAll() {
        return horarioService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<horarios> findById(@PathVariable Integer id) {
        return horarioService.findById(id);
    }

    @PostMapping("/")
    public horarios save(@RequestBody horarios horario) {
        return horarioService.save(horario);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        horarioService.deleteById(id);
    }
}
