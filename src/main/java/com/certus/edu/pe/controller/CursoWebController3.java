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

import com.certus.edu.pe.modelo.Curso;
import com.certus.edu.pe.servicios.CursoServicio;

@Controller
@RequestMapping("/curso")
public class CursoWebController {

    @Autowired
    private CursoServicio servicio;

    @RequestMapping("/listarTodo")
    public String listarCurso(Model model) {
        List<Curso> listaCurso = servicio.buscarTodo();
        model.addAttribute("listaCurso", listaCurso);
        return "moduloProfesor/listarTodoCurso"; // Corregida la ruta
    }

    @RequestMapping("/nuevo")
    public String nuevoCurso(Model model) {
        Curso curso = new Curso();
        model.addAttribute("curso", curso);
        return "moduloProfesor/nuevoCurso"; // Corregida la ruta
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearCurso(@ModelAttribute("curso") Curso curso) {
        servicio.crear(curso);
        return "redirect:/curso/listarTodo";
    }

    @RequestMapping(value = "/actualizar/{id}")
    public ModelAndView editarCurso(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("moduloProfesor/editarCurso"); // Corregida la ruta
        Curso curso = servicio.buscarPorId(id);
        mav.addObject("curso", curso);
        return mav;
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminarCurso(@PathVariable(name = "id") int id) {
        servicio.borrarPorId(id);
        return "redirect:/curso/listarTodo";
    }
}
