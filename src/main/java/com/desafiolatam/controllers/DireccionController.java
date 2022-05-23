package com.desafiolatam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafiolatam.models.Direccion;
import com.desafiolatam.models.TipoDireccionEnum.TipoDireccion;
import com.desafiolatam.service.DireccionService;

@Controller
public class DireccionController {

	@Autowired
	DireccionService direccionService;
	
	@RequestMapping("/direccion")
	public String formularioDireccion(@ModelAttribute("direccion") Direccion direccion,Model model) {
		model.addAttribute("tipoCasa", TipoDireccion.Casa.toString());
		model.addAttribute("tipoTrabajo", TipoDireccion.Trabajo.toString());
		model.addAttribute("tipoOtro", TipoDireccion.Otro.toString());
		return "direccion.jsp";
		
	}
	
	@PostMapping("/direccion/agregar")
	public String agregarDireccion(@ModelAttribute("direccion") Direccion direccion, RedirectAttributes redirectAttributes) {
		
		if(!direccion.getCalle().equals("") && direccion.getCalle()!=null && !direccion.getNumero().equals("") && direccion.getNumero()!=null
				&& !direccion.getCiudad().equals("") && direccion.getCiudad()!=null && direccion.getTipoDireccionEnum()!=null
				&& !direccion.getTipoDireccionEnum().equals("")) {
			direccionService.save(direccion);
			redirectAttributes.addFlashAttribute("Correcto","Dirección ingresada correctamente");
			return "redirect:/direccion";
		}else {
			redirectAttributes.addFlashAttribute("Error","Datos faltantes");
			return "redirect:/direccion";
		}
	}
	
	@RequestMapping("/direccion/listar")
	public String listarDirecciones(Model model) {
		
		List<Direccion> listaDirecciones=direccionService.findAll();
		model.addAttribute("listaDirecciones",listaDirecciones);
		return "listaDirecciones.jsp";
	}
	
}
