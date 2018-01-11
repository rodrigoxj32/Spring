package com.rodrigo.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rodrigo.converter.CursoConverter;
import com.rodrigo.entity.Curso;
import com.rodrigo.model.CursoModel;
import com.rodrigo.repository.CursoJpaRepository;
import com.rodrigo.service.CursoService;

@Service("cursoServiceImpl")
public class CursoServiceImpl implements CursoService{
	
	private static final Log LOG = LogFactory.getLog(CursoServiceImpl.class);

	@Autowired
	@Qualifier("cursoJpaRepository")
	private CursoJpaRepository cursoJpaRepository;
	
	@Autowired
	@Qualifier("cursoConverter")
	private CursoConverter cursoConverter;
	
	@Override
	public List<Curso> obtenerTodosLosCursos() {
		LOG.info("Llamada: obtenerTodosLosCursos()");
		
		return cursoJpaRepository.findAll();
		
		
	}

	@Override
	public Curso agregarCurso(CursoModel curso) {
		LOG.info("Llamada: agregarCurso()");
		
		
		return cursoJpaRepository.save(cursoConverter.modelAentity(curso));
		
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
