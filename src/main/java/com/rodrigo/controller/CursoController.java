package com.rodrigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rodrigo.entity.Curso;
import com.rodrigo.service.CursoService;


@Controller
@RequestMapping("/cursos")
public class CursoController {
	
	private static final String ListaCursos = "listaCursos";
	private static final String AgregarCurso = "agregarCurso";
	
	@Autowired
	@Qualifier("cursoServiceImpl")
	private CursoService cursoService;
	
	@GetMapping("/listaCursos")
	public ModelAndView listarTodosLosCursos() {
		ModelAndView mav = new ModelAndView(ListaCursos);
		
		mav.addObject("cursos",cursoService.obtenerTodosLosCursos());
		
		return mav;		
	}
	
	
	@PostMapping("/agregarCurso")
	public String agregarCurso(@ModelAttribute("curso") Curso curso) {
		
		cursoService.agregarCurso(curso);
				
		return "redirect:/cursos/listaCursos";
	}
	
}
