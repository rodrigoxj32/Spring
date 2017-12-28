package com.rodrigo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
	private static final Log LOG = LogFactory.getLog(CursoController.class);
	
	@Autowired
	@Qualifier("cursoServiceImpl")
	private CursoService cursoService;
	
	@GetMapping("/listaCursos")
	public ModelAndView listarTodosLosCursos() {
		LOG.info("Llamada: listarTodosLosCursos()");
		
		ModelAndView mav = new ModelAndView(ListaCursos);
		
		//System.out.println(cursoService.obtenerTodosLosCursos());
		
		mav.addObject("cursos",cursoService.obtenerTodosLosCursos());
		
		return mav;		
	}
	
	
	@PostMapping("/agregarCurso")
	public String agregarCurso(@ModelAttribute("curso") Curso curso) {
		LOG.info("Llamada: agregarCurso( " + curso.toString() + " )");
		
		cursoService.agregarCurso(curso);
				
		return "redirect:/cursos/listaCursos";
	}
	
}
