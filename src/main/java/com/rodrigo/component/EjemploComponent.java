package com.rodrigo.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.rodrigo.repository.CursoJpaRepository;

@Component("ejemploComponent")
public class EjemploComponent {

	private static final Log LOG = LogFactory.getLog(EjemploComponent.class);
	
	@Autowired
	@Qualifier("cursoJpaRepository")
	private CursoJpaRepository cursoJpaRepository;
	
	
	public void hola() {

		LOG.info("Hola ejemplo component");
	}
}
