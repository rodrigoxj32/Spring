package com.rodrigo.service;

import java.util.List;

import com.rodrigo.entity.Curso;
import com.rodrigo.model.CursoModel;

public interface CursoService {

	public abstract List<Curso> obtenerTodosLosCursos();
	
	public abstract Curso agregarCurso(CursoModel curso);
	
	public abstract int eliminarCurso(int id);
	
	public abstract Curso modificarCurso(Curso curso);
	
	public abstract Curso buscarCurso(int id);
	
}
