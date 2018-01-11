package com.rodrigo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.entity.Curso;

@Repository("cursoJpaRepository")
public interface CursoJpaRepository extends JpaRepository<Curso, Serializable>{

	/* Todas son consultas el findBy ya es reservado y detecta automaticamente los atributos de la clase
	public abstract Curso findByPrecio(int precio);
	
	public abstract Curso findByPrecioAndNombre(int precio, String nombre);
	
	public abstract List<Curso> findByNombreOrderByHoras(String nombre);
	
	public abstract Curso findByNombreOrPrecio(String nombre, int precio);*/
	
	
	public abstract Curso findById(int id);
	
}
