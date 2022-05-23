package com.desafiolatam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafiolatam.models.Alumno;
import com.desafiolatam.models.Direccion;
import com.desafiolatam.service.AlumnoService;
import com.desafiolatam.service.DireccionService;

@Controller
public class AlumnoController {

	@Autowired
	DireccionService direccionService;
	
	@Autowired
	AlumnoService alumnoService;
	
	@RequestMapping("/alumno")
	public String formularioAlumno(@ModelAttribute("alumno") Alumno alumno,Direccion direccion, Model model) {
		
		List<Direccion> listaDirecciones=direccionService.findAll();
		model.addAttribute("listaDirecciones",listaDirecciones);
		return "alumno.jsp";
		
	}
	
	@PostMapping("/alumno/agregar")
	public String agregarAlumno(@ModelAttribute("alumno") Alumno alumno, RedirectAttributes redirectAttributes) {
		
		if(alumno.getRut()!=null && !alumno.getRut().equals("") && alumno.getNombre()!=null && !alumno.getNombre().equals("")
				&& alumno.getApellido()!=null && !alumno.getApellido().equals("") && alumno.getEmail()!=null && !alumno.getEmail().equals("")
				&& alumno.getEdad()!=null && !alumno.getEdad().equals("") && alumno.getFechaIngreso()!=null && alumno.getDireccion()!=null) {
			alumnoService.save(alumno);
			redirectAttributes.addFlashAttribute("Correcto","Alumno ingresado con éxito");
			return "redirect:/alumno";
		}else {
			redirectAttributes.addFlashAttribute("Error","Datos faltantes. Ingrese nuevamente al alumno");
			return "redirect:/alumno";
		}
	}
	
	@RequestMapping("/alumno/listar")
	public String listarAlumnos(Model model) {
		
		List<Alumno> listaAlumnos=alumnoService.findAll();
		model.addAttribute("listaAlumnos",listaAlumnos);
		return "listaAlumno.jsp";
		
	}
	
	
}
