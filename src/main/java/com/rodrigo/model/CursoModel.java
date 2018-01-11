package com.rodrigo.model;

public class CursoModel {
	
	private String nombre;
	private String descripcion;
	private int precio;
	private int horas;
	
	public CursoModel() {
		
	}
	
	public CursoModel(String nombre, String descripcion, int precio, int horas) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.horas = horas;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public int getHoras() {
		return horas;
	}
	
	public void setHoras(int horas) {
		this.horas = horas;
	}

	@Override
	public String toString() {
		return "CursoModel [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", horas="
				+ horas + "]";
	}
	
	
	
}
