package com.example.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Moneda {
    @Id
    @GeneratedValue
    private Long id;
    private double valorFacial;
    private String unidadMonetaria;
    private float diametro;
    private float peso;
    @ElementCollection
    private List<String> metales;
    private String descripcion;
    private int numeroEjemplares;
    public Moneda(){

    }
	public Moneda(double valorFacial, String unidadMonetaria, float diametro, float peso, List<String> metales,
			String descripcion,int numeroEjemplares) {
		this.valorFacial = valorFacial;
		this.unidadMonetaria = unidadMonetaria;
		this.diametro = diametro;
		this.peso = peso;
		this.metales = metales;
		this.descripcion = descripcion;
		this.numeroEjemplares=numeroEjemplares;		
		this.id=(long)(this.valorFacial*100*this.unidadMonetaria.hashCode()*this.diametro*this.peso*
				this.metales.hashCode());
	}
	
    
}
