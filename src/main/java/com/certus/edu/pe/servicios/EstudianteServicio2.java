package com.certus.edu.pe.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certus.edu.pe.modelo.Estudiante;
import com.certus.edu.pe.repositorio.EstudianteRepositorio;

@Service
@Transactional
public class EstudianteServicio2 {

    @Autowired // Inyeccion de dependecia
    private EstudianteRepositorio repositorio;

    public EstudianteServicio2() {

    }

    public List<Estudiante> buscarTodo() {
        return (List<Estudiante>) repositorio.findAll();
    }

    public Estudiante crear(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    public Estudiante actualizar(Estudiante estudianteActualizar) {
        Estudiante estudianteActual = repositorio.findById(estudianteActualizar.getIdEstudiante()).orElse(null);
        if (estudianteActual != null) {
            estudianteActual.setEstudiante_dni(estudianteActualizar.getEstudiante_dni());
            estudianteActual.setPrimer_nombre(estudianteActualizar.getPrimer_nombre());
            estudianteActual.setSegundo_nombre(estudianteActualizar.getSegundo_nombre());
            estudianteActual.setApellido_paterno(estudianteActualizar.getApellido_paterno());
            estudianteActual.setApellido_materno(estudianteActualizar.getApellido_materno());
            estudianteActual.setFecha_nacimiento(estudianteActualizar.getFecha_nacimiento());
            estudianteActual.setDireccion(estudianteActualizar.getDireccion());

            return repositorio.save(estudianteActual);
        } else {
            return null;
        }
    }

    public Estudiante buscarPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    public void borrarPorId(Integer id) {
        repositorio.deleteById(id);
    }
}
