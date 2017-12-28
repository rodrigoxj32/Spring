package com.rodrigo.service;

import java.util.List;

import com.rodrigo.entity.Curso;

public interface CursoService {

	public abstract List<Curso> obtenerTodosLosCursos();
	
	public abstract Curso agregarCurso(Curso curso);
	
	public abstract int eliminarCurso(int id);
	
	public abstract Curso modificarCurso(Curso curso);
	
	
	
}
