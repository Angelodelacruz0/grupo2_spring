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

import com.certus.edu.pe.modelo.Profesor;
import com.certus.edu.pe.servicios.ProfesorServicio;



@Controller
@RequestMapping("/profesor")
public class ProfesorWebController {

	@Autowired
	private ProfesorServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarProfesor(Model model) {
		
		List<Profesor> listaProfesor = servicio.buscarTodo();
		
		model.addAttribute("listaProfesor", listaProfesor);
		return "/moduloProfesor/listarTodoProfesor";
	}
	
	@RequestMapping("/nuevo")
	public String nuevaProfesor(Model model) {
		Profesor profesor = new Profesor();
		model.addAttribute("profesor",profesor);
		return "/moduloProfesor/nuevaProfesor";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearProfesor(@ModelAttribute("profesor") Profesor profesor) {
		servicio.crear(profesor);
		return "redirect:/profesor/listarTodo";
		
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarProfesor(@PathVariable(name= "id") int id) {
		ModelAndView mav= new ModelAndView("/moduloProfesor/editarProfesor");
		Profesor profesor = servicio.buscarPorId(id);
		mav.addObject("profesor", profesor);
		return mav;

	}
	
	@RequestMapping(value="/eliminar/{id}")
	public  String eliminarProfesor(@PathVariable(name = "id") int id) {
		servicio.borrarPorId(id);
		return "redirect:/profesor/listarTodo";
	}
	
	
}