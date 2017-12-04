package com.rodrigo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
	
	public static final String error500 ="error/500";
	
	
	@ExceptionHandler(Exception.class)
	public String mostrarInternalServerError() {
		
		 return error500;
	}
	
}
