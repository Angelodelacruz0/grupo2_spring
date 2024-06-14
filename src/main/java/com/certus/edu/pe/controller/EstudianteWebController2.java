package com.certus.edu.pe.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.certus.edu.pe.modelo.Estudiante;
import com.certus.edu.pe.servicios.EstudianteServicio2;

@Controller
@RequestMapping("/estudiante")
public class EstudianteWebController2 {

    @Autowired
    private EstudianteServicio2 servicio;

    @RequestMapping("/listarTodo")
    public String listarEstudiante(Model model) {
        List<Estudiante> listaEstudiante = servicio.buscarTodo();
        model.addAttribute("listaEstudiante", listaEstudiante);
        return "moduloProfesor/listarTodoEstudiante"; // Corregida la ruta
    }

    @RequestMapping("/nuevo")
    public String nuevoEstudiante(Model model) {
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);
        return "moduloProfesor/nuevaEstudiante"; // Corregida la ruta
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        servicio.crear(estudiante);
        return "redirect:/estudiante/listarTodo";
    }

    @RequestMapping(value = "/actualizar/{id}")
    public ModelAndView editarEstudiante(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("moduloProfesor/editarEstudiante"); // Corregida la ruta
        Estudiante estudiante = servicio.buscarPorId(id);
        mav.addObject("estudiante", estudiante);
        return mav;
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable(name = "id") int id) {
        servicio.borrarPorId(id);
        return "redirect:/estudiante/listarTodo";
    }
}
