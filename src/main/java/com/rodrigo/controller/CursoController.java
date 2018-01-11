package com.rodrigo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rodrigo.converter.CursoConverter;
import com.rodrigo.entity.Curso;
import com.rodrigo.model.CursoModel;
import com.rodrigo.service.CursoService;


@Controller
@RequestMapping("/cursos")
public class CursoController {
	
	private static final String ListaCursos = "listaCursos";
	private static final String EditarCurso = "editarCurso";
	
	private static final Log LOG = LogFactory.getLog(CursoController.class);
	
	@Autowired
	@Qualifier("cursoServiceImpl")
	private CursoService cursoService;
	
	@Autowired
	@Qualifier("cursoConverter")
	private CursoConverter cursoConverter;
	
	@GetMapping("/listaCursos")
	public ModelAndView listarTodosLosCursos() {
		LOG.info("Llamada: listarTodosLosCursos()");
		
		ModelAndView mav = new ModelAndView(ListaCursos);
		
		mav.addObject("curso",new CursoModel());
		mav.addObject("cursos",cursoService.obtenerTodosLosCursos());
		
		return mav;		
	}
	
	
	@PostMapping("/agregarCurso")
	public String agregarCurso(@ModelAttribute("curso") CursoModel curso) {
		LOG.info("Llamada: agregarCurso( " + curso.toString() + " )");
		
		cursoService.agregarCurso(curso);
				
		return "redirect:/cursos/listaCursos";
	}
	
	
	@GetMapping("/borrarCurso")
	public String borrarCurso(@RequestParam(value="id", required=false) String id) {
		System.out.println("entro al metodo borrar"+id);
		LOG.info("Llamada: borrarCurso( " + id + " )");
		
		cursoService.eliminarCurso(Integer.parseInt(id));
				
		return "redirect:/cursos/listaCursos";
	}
	
	
		
	@GetMapping("/editarCurso")
	public ModelAndView editarCurso(@RequestParam(value="id", required=false) String id) {
		LOG.info("Llamada: editarCurso( " +id +" )");
		
		ModelAndView mav = new ModelAndView(EditarCurso);
		
		//addObject("curso2",new Curso());
		mav.addObject("curso",cursoService.buscarCurso(Integer.parseInt(id)));
		
		System.out.println(cursoService.buscarCurso(Integer.parseInt(id)));
		
		return mav;		
	}
	
	
	@PostMapping("/actualizarCurso")
	public String actualizarCurso(@ModelAttribute("curso") Curso curso) {
		LOG.info("Llamada: actualizarCurso( " + curso.toString() + " )");
		
		cursoService.modificarCurso(curso);
				
		return "redirect:/cursos/listaCursos";
	}
	
	
	
}
