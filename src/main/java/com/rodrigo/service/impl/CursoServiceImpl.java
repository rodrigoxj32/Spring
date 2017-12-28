package com.rodrigo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rodrigo.entity.Curso;
import com.rodrigo.repository.CursoJpaRepository;
import com.rodrigo.service.CursoService;

@Service("cursoServiceImpl")
public class CursoServiceImpl implements CursoService{

	@Autowired
	@Qualifier("cursoJpaRepository")
	private CursoJpaRepository cursoJpaRepository;
	
	@Override
	public List<Curso> obtenerTodosLosCursos() {
		
		return cursoJpaRepository.findAll();
		
		
	}

	@Override
	public Curso agregarCurso(Curso curso) {
		
		return cursoJpaRepository.save(curso);
		
	}

	@Override
	public int eliminarCurso(int id) {
		
		cursoJpaRepository.delete(id);
		
		return 0;
	}

	@Override
	public Curso modificarCurso(Curso curso) {
		
		return cursoJpaRepository.save(curso);
		
		
	}
	
	

}
