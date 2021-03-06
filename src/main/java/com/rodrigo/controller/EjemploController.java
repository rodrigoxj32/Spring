package com.rodrigo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.rodrigo.component.EjemploComponent;
import com.rodrigo.model.Persona;
import com.rodrigo.service.EjemploService;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/ejemplo")
public class EjemploController {
	
	public static String vista1 = "ejemplo";
	
	@Autowired
	@Qualifier("ejemploComponent")
	private EjemploComponent ejemploComponent1;
	
	@Autowired
	@Qualifier("ejemploService")
	private EjemploService ejemploService1;
	
	//Forma 1
	//@RequestMapping(value="/ejemploString",method = RequestMethod.GET)
	@GetMapping("/ejemploString")
	public String ejemploString(Model model) {
		
		//ejemploComponent1.hola();
		
		model.addAttribute("variable","Rodrigo");
		return vista1;
		//return "ejemplo";
	}
	
	//Forma 2
	@RequestMapping(value="/ejemploModelAndView",method = RequestMethod.GET)
	public ModelAndView ejemploModelAndView() {
		ModelAndView mav = new ModelAndView("ejemplo");
		mav.addObject("variable","Daniel");
		
		return mav; 
		
		//return new ModelAndView("ejemplo");
	}
	
	//retornando datos complejos con ModelAndView
	@GetMapping("/datosComplejos")
	public ModelAndView ejemploDatosComplejos() {
		ModelAndView mav = new ModelAndView("persona");
		Persona humano = new Persona("Rodrigo",24);
		
		mav.addObject("individuo",humano);
		return mav;
	}
	
	/*@GetMapping("/listaDatosComplejos")
	public ModelAndView ejemploListaDatosComplejos() {
		ModelAndView mav = new ModelAndView("persona");
				
		mav.addObject("individuo",getPersonas());
		return mav;
	}*/
	
	
	/*
	private List<Persona> getPersonas(){
		List<Persona> personas = new ArrayList<>();
		
		personas.add(new Persona("Rodrigo",35));
		personas.add(new Persona("Daniel",35));
		personas.add(new Persona("Segovia",35));
		personas.add(new Persona("Romero",35));
		
		return personas;
	}*/
	
	@GetMapping("/listaDatosComplejos")
	public ModelAndView ejemploListaDatosComplejos() {
		ModelAndView mav = new ModelAndView("persona");
				
		mav.addObject("individuo",ejemploService1.obtenerPersonas());
		return mav;
	}
	
	
}
