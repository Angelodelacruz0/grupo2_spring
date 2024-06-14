package com.certus.edu.pe.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certus.edu.pe.modelo.Profesor;
import com.certus.edu.pe.repositorio.ProfesorRepositorio;

@Service
@Transactional
public class ProfesorServicio {

    @Autowired // Inyeccion de dependecia
    private ProfesorRepositorio repositorio;

    public ProfesorServicio() {

    }

    public List<Profesor> buscarTodo() {
        return (List<Profesor>) repositorio.findAll();
    }

    public Profesor crear(Profesor profesor) {
        return repositorio.save(profesor);
    }

    public Profesor actualizar(Profesor profesorActualizar) {
        Profesor profesorActual = repositorio.findById(profesorActualizar.getIdProfesor()).orElse(null);
        if (profesorActual != null) {
            profesorActual.setProfesor_dni(profesorActualizar.getProfesor_dni());
            profesorActual.setPrimer_nombre(profesorActualizar.getPrimer_nombre());
            profesorActual.setSegundo_nombre(profesorActualizar.getSegundo_nombre());
            profesorActual.setApellido_paterno(profesorActualizar.getApellido_paterno());
            profesorActual.setApellido_materno(profesorActualizar.getApellido_materno());
            profesorActual.setTelefono(profesorActualizar.getTelefono());
            profesorActual.setCorreo(profesorActualizar.getCorreo());

            return repositorio.save(profesorActual);
        } else {
            return null;
        }
    }

    public Profesor buscarPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    public void borrarPorId(Integer id) {
        repositorio.deleteById(id);
    }
}
