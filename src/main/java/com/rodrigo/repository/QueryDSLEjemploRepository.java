package com.rodrigo.repository;

//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.rodrigo.entity.Curso;
import com.rodrigo.entity.QCurso;

@Repository("queryDSLEjemploRespository")
public class QueryDSLEjemploRepository {
	
	private QCurso qCurso =  QCurso.curso;
	
	@PersistenceContext	
	private EntityManager em;
	
	public Curso find(boolean exist) {
		JPAQuery<Curso> query = new JPAQuery<Curso>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCurso.descripcion.endsWith("OP"));
		
			
		if(exist) {
			Predicate predicate2= qCurso.id.eq(23);
			predicateBuilder.and(predicate2);
		}else {
			Predicate predicate3= qCurso.nombre.endsWith("OP");
			predicateBuilder.or(predicate3);
		}
				
		Curso curso1 = query.select(qCurso).from(qCurso).where(predicateBuilder).fetchOne();
		
		//List<Curso> cursos = query.select(qCurso).from(qCurso).where(qCurso.horas.between(20, 50)).fetch();
		
		return curso1;
	}

}
