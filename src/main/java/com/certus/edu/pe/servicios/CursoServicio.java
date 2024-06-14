package com.certus.edu.pe.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certus.edu.pe.modelo.Curso;
import com.certus.edu.pe.repositorio.CursoRepositorio;

@Service
@Transactional
public class CursoServicio {

    @Autowired // Inyección de dependencia
    private CursoRepositorio repositorio;

    public CursoServicio() {

    }

    public List<Curso> buscarTodo() {
        return (List<Curso>) repositorio.findAll();
    }

    public Curso crear(Curso curso) {
        return repositorio.save(curso);
    }

    public Curso actualizar(Curso cursoActualizar) {
        Curso cursoActual = repositorio.findById(cursoActualizar.getIdCurso()).orElse(null);
        if (cursoActual != null) {
            cursoActual.setNombre(cursoActualizar.getNombre());
            cursoActual.setDescripcion(cursoActualizar.getDescripcion());
            cursoActual.setDuracion(cursoActualizar.getDuracion());

            return repositorio.save(cursoActual);
        } else {
            return null;
        }
    }

    public Curso buscarPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    public void borrarPorId(Integer id) {
        repositorio.deleteById(id);
    }
}
