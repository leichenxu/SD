package com.example.demo.Model;

import com.example.demo.Model.Proveedor;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Ejemplar {
    @Id
    @GeneratedValue
    private Long id;
    private String modelo;
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
	public Ejemplar(String modelo, Date anio, String ciudad, Date fechaAdquisicion, String conservacion,
			Proveedor proveedor,Moneda moneda) {
		this.modelo = modelo;
		this.anio = anio;
		this.ciudad = ciudad;
		this.fechaAdquisicion = fechaAdquisicion;
		this.conservacion = conservacion;
		this.proveedor = proveedor;
		this.moneda=moneda;
	}
}
