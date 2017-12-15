package com.rodrigo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rodrigo.model.Persona;
import com.rodrigo.service.EjemploService;

@Service("ejemploService")
public class ejemploServiceImpl implements EjemploService{

	@Override
	public List<Persona> obtenerPersonas() {
		
		List<Persona> personas = new ArrayList<>();
		
		personas.add(new Persona("Rodrigo",35));
		personas.add(new Persona("Daniel",35));
		personas.add(new Persona("Segovia",35));
		personas.add(new Persona("Romero",35));
		
		return personas;
		
	}

}
