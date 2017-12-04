package com.rodrigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ejemplo2")
public class Ejemplo2Controller {
	
	private  static  final String vista2 = "ejemplo2";
	
	//localhost:8080/ejemplo2/request1?nm=rodrigo
	//localhost:8080/ejemplo2/request1?nm=daniel
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(value="nm", required=false, defaultValue=", Bienvenido seas") String nombre) {
		ModelAndView mav = new ModelAndView(vista2);
		mav.addObject("nm_in_model",nombre);
		System.out.println(nombre);
		return mav;
	}
	
	//localhost:8080/ejemplo2/request2/Rodrigo
	//localhost:8080/ejemplo2/request2/Daniel
	
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String nombre) {
		ModelAndView mav = new ModelAndView(vista2);
		mav.addObject("nm_in_model",nombre);
		return mav;
		
	}

}
