package com.rodrigo.converter;

import org.springframework.stereotype.Component;

import com.rodrigo.entity.Curso;
import com.rodrigo.model.CursoModel;

@Component("cursoConverter")
public class CursoConverter {
	
	//Convertir de una entity a model
	public CursoModel entityAmodel(Curso curso) {
		CursoModel cursoModel = new CursoModel();
		cursoModel.setNombre(curso.getNombre());
		cursoModel.setDescripcion(curso.getDescripcion());
		cursoModel.setHoras(curso.getHoras());
		cursoModel.setPrecio(curso.getPrecio());
		
		
		return cursoModel;
	}
	
	
	
	//Convertir de model a entity
	public Curso modelAentity(CursoModel cursoModel) {
		Curso curso = new Curso();
		curso.setNombre(cursoModel.getNombre());
		curso.setDescripcion(cursoModel.getDescripcion());
		curso.setHoras(cursoModel.getHoras());
		curso.setPrecio(cursoModel.getPrecio());
		
		return curso;
	}
}
