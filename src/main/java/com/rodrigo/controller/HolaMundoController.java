package com.rodrigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/")
public class HolaMundoController {
		
	@GetMapping("helloworld")
	public String helloWorld() {
		return "holaMundo"; 
	}
	
	@GetMapping("nuevaprueba")
	public String error() {
		return "4044"; 
	}
}
