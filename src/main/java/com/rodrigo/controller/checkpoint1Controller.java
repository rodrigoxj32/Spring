package com.rodrigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rodrigo.service.Ejercicio1Service;



@Controller
@RequestMapping("/ejercicio")
public class checkpoint1Controller {
	
	@Autowired
	@Qualifier("ejercicio1Service")
	private Ejercicio1Service checkpoint1;
	
	
	@GetMapping("/")
	public String redireccionar() {
		
		return "redirect:/ejercicio/servicio";
	}
	
	
	@GetMapping("/servicio")
	public ModelAndView ejercicio1() {
		ModelAndView mav = new ModelAndView("checkpoint1");
				
			
		mav.addObject("mensaje", checkpoint1.imprimir());
		
		return mav;
	}
	
		
	
}
