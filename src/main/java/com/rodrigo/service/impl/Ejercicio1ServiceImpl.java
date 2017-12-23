package com.rodrigo.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;


import com.rodrigo.service.Ejercicio1Service;

@Service("ejercicio1Service")
public class Ejercicio1ServiceImpl implements Ejercicio1Service{
	
	private static final Log LOGGER = LogFactory.getLog(Ejercicio1ServiceImpl.class);

	@Override
	public String imprimir() {
		String mensaje = "Hola mundo desde un servicio";
		
		LOGGER.info("Entro al metodo imprimir ");
		
		return mensaje;
	}
	
	

}
