package com.example.demo.Model;

import com.example.demo.Model.Proveedor;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Ejemplar {
    @Id
    @GeneratedValue
    private Long id;
    private Date anio;
    private String ciudad;
    private Date fechaAdquisicion;
    private String conservacion;
    @OneToOne
    private Proveedor proveedor;
    @OneToOne
    private Moneda moneda;
    public Ejemplar(){

    }
	public Ejemplar(Date anio, String ciudad, Date fechaAdquisicion, String conservacion,
			Proveedor proveedor,Moneda moneda) {
		this.anio = anio;
		this.ciudad = ciudad;
		this.fechaAdquisicion = fechaAdquisicion;
		this.conservacion = conservacion;
		this.proveedor = proveedor;
		this.moneda=moneda;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getAnio() {
		return anio;
	}
	public void setAnio(Date anio) {
		this.anio = anio;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}
	public String getConservacion() {
		return conservacion;
	}
	public void setConservacion(String conservacion) {
		this.conservacion = conservacion;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Moneda getMoneda() {
		return moneda;
	}
	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	
}
