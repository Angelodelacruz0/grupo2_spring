package com.certus.edu.pe.repositorio;

import com.certus.edu.pe.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cursoRepositorio extends JpaRepository<Curso, Integer> {
}
