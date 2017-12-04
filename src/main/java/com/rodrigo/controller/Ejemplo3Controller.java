package com.rodrigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.rodrigo.model.Persona;

@Controller
@RequestMapping("/ejemplo3")
public class Ejemplo3Controller {

	public static final String formulario1 = "formulario1";
	public static final String resultado1 = "resultado1";
	
	
	//Redireccionando forma 1
	/*
	@GetMapping("/")
	public String redireccionar() {
		
		return "redirect:/ejemplo3/formulario1";
	}*/
	
	
	//Redireccionando forma 2
	@GetMapping("/")
	public RedirectView redireccionar2() {
		System.out.println("Entro a redireccionar 2");
		
		return new RedirectView(formulario1);
	}
	
	
	//Metodo para mostrar formulario
	@GetMapping("/formulario1")
	public String showForm(Model model) {
		
		model.addAttribute("persona",new Persona()); 
		
		return formulario1;
		
	}
	
	//Metodo que recibe los valores de un formulario
	@PostMapping("/agregarPersona")
	public ModelAndView agregarP(@ModelAttribute("persona") Persona persona){
		
		ModelAndView mav = new ModelAndView(resultado1);
		mav.addObject("persona", persona);
		return mav;
		
	}
	
}
