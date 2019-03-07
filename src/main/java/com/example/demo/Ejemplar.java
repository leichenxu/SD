package com.example.demo;

import java.sql.Date;

public class Ejemplar {
	private String modelo;
	private Date anio;
	private String ciudad;
	private Date fechaAdquisicion;
	private String conservacion;
	private Proveedor proveedor;
	public Ejemplar(String modelo,Date anio, String ciudad,Date fechaAdquisicion,String conservacion,
			Proveedor proveedor) {
		this.modelo=modelo;
		this.anio=anio;
		this.ciudad=ciudad;
		this.fechaAdquisicion=fechaAdquisicion;
		this.conservacion=conservacion;
		this.proveedor=proveedor;
	}
	public String getModelo() {
		return this.modelo;
	}
	public void setModelo(String modelo) {
		this.modelo=modelo;
	}
	public int getAnio() {
		return this.anio.getYear();
	}
	public void setAnio(int year) {
		this.anio.setYear(year);
	}
	public String getCiudad() {
		return this.ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad=ciudad;
	}
}
