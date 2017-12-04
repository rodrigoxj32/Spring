package com.rodrigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejemplo4")
public class Ejemplo4Controller {
	
	@GetMapping("/error")
	public String ejemploString() {
		
		return "404";
		
	}
	
	@GetMapping("/errorServer")
	public String ejemploString2() {
		
		return "500";
		
	}

}
