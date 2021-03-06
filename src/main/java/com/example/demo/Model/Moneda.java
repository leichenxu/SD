package com.example.demo.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Moneda {
    @Id
    private Long id;

    private double valorFacial;
    private String unidadMonetaria;
    private float diametro;
    private float peso;
    private String metales;
    private String descripcion;

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "moneda", cascade = CascadeType.ALL)
    private List<Ejemplar> listaEjemplares = new ArrayList<>();

    public Moneda() {

    }

    public Moneda(double valorFacial, String unidadMonetaria, float diametro, float peso, String metales,
                  String descripcion, List<Ejemplar> l) {
        this.valorFacial = valorFacial;
        this.unidadMonetaria = unidadMonetaria;
        this.diametro = diametro;
        this.peso = peso;
        this.metales = metales;
        this.descripcion = descripcion;
        this.id = (long) Math.abs(this.valorFacial * 10 + this.unidadMonetaria.hashCode() + this.diametro + this.peso
                + this.metales.hashCode());
        this.listaEjemplares = l;
    }

    public Moneda(double valorFacial, String unidadMonetaria, float diametro, float peso, String metales,
                  String descripcion) {
        this.valorFacial = valorFacial;
        this.unidadMonetaria = unidadMonetaria;
        this.diametro = diametro;
        this.peso = peso;
        this.metales = metales;
        this.descripcion = descripcion;
        this.id = (long) Math.abs(this.valorFacial * 10 + this.unidadMonetaria.hashCode() + this.diametro + this.peso
                + this.metales.hashCode());
    }

    public Moneda(Long id, double valorFacial, String unidadMonetaria, float diametro, float peso, String metales,
                  String descripcion) {
        this.valorFacial = valorFacial;
        this.unidadMonetaria = unidadMonetaria;
        this.diametro = diametro;
        this.peso = peso;
        this.metales = metales;
        this.descripcion = descripcion;
        this.id = id;
    }

    public void modificarMoneda(double valorFacial, String unidadMonetaria, float diametro, float peso, String metales,
                                String descripcion) {
        this.valorFacial = valorFacial;
        this.unidadMonetaria = unidadMonetaria;
        this.diametro = diametro;
        this.peso = peso;
        this.metales = metales;
        this.descripcion = descripcion;
    }

    public void setValorFacial(double valorFacial) {
        this.valorFacial = valorFacial;
    }

    public void setUnidadMonetaria(String unidadMonetaria) {
        this.unidadMonetaria = unidadMonetaria;
    }

    public void setDiametro(float diametro) {
        this.diametro = diametro;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setMetales(String metales) {
        this.metales = metales;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getMetales() {
        return metales;
    }

    public double getValorFacial() {
        return valorFacial;
    }

    public void removeEjemplar(Ejemplar ejemplar) {
        this.listaEjemplares.remove(ejemplar);
    }

}
