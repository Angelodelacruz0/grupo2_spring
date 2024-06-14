package com.certus.edu.pe.servicios;

import com.certus.edu.pe.modelo.Curso;
import com.certus.edu.pe.repositorio.cursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private cursoRepositorio cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> findById(Integer id) {
        return cursoRepository.findById(id);
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void deleteById(Integer id) {
        cursoRepository.deleteById(id);
    }
}
