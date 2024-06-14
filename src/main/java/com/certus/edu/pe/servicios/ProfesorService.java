package com.certus.edu.pe.servicios;

import com.certus.edu.pe.modelo.Profesor;
import com.certus.edu.pe.repositorio.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepositorio profesorRepository;

    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> findById(Integer id) {
        return profesorRepository.findById(id);
    }

    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public void deleteById(Integer id) {
        profesorRepository.deleteById(id);
    }
}
