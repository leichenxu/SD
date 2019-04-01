package com.example.demo.Model;

import javax.persistence.*;

import java.util.ArrayList;
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
    @OneToMany(mappedBy = "moneda", cascade = CascadeType.ALL)
    private List<Ejemplar> listaEjemplares=new ArrayList<Ejemplar>();

    public Moneda() {

    }

    public Moneda(double valorFacial, String unidadMonetaria, float diametro, float peso, List<String> metales,
                  String descripcion,List<Ejemplar> l) {
        this.valorFacial = valorFacial;
        this.unidadMonetaria = unidadMonetaria;
        this.diametro = diametro;
        this.peso = peso;
        this.metales = metales;
        this.descripcion = descripcion;
        this.id = (long) (this.valorFacial * 100 * this.unidadMonetaria.hashCode() * this.diametro * this.peso *
				this.metales.hashCode());
		this.listaEjemplares = l;
	}

	public Moneda(double valorFacial, String unidadMonetaria, float diametro, float peso, List<String> metales,
			String descripcion) {
		this.valorFacial = valorFacial;
		this.unidadMonetaria = unidadMonetaria;
		this.diametro = diametro;
		this.peso = peso;
		this.metales = metales;
		this.descripcion = descripcion;
		this.id = (long) (this.valorFacial * 100 * this.unidadMonetaria.hashCode() * this.diametro * this.peso
				* this.metales.hashCode());
	}

	@Override
	public String toString() {
		return this.unidadMonetaria;
	}

    public Long getId() {
        return id;
    }

    public String getUnidadMonetaria() {
        return unidadMonetaria;
    }

    public float getPeso() {
        return peso;
    }

    public List<Ejemplar> getListaEjemplares() {
		return listaEjemplares;
	}

	public void setListaEjemplares(List<Ejemplar> listaEjemplares) {
		this.listaEjemplares = listaEjemplares;
	}

	public float getDiametro() {
        return diametro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<String> getMetales() {
        return metales;
    }

    public double getValorFacial() {
        return valorFacial;
    }

    public void removeEjemplar(Ejemplar ejemplar){
        this.listaEjemplares.remove(ejemplar);
    }
}
