package com.example.demo;

import java.util.List;

public class ModeloMoneda {

    private double valorFacial;
    private String unidadMonetaria;
    private float diametro;
    private float peso;
    private List<String> metales;
    private String descripcion;

    public ModeloMoneda(double valorFacial, String unidadMonetaria, float diametro,
                        float peso, List<String> metales, String descripcion) {
        this.valorFacial = valorFacial;
        this.unidadMonetaria = unidadMonetaria;
        this.diametro = diametro;
        this.peso = peso;
        this.metales = metales;
        this.descripcion = descripcion;
    }

    public double getValorFacial() {
        return valorFacial;
    }

    public float getDiametro() {
        return diametro;
    }

    public float getPeso() {
        return peso;
    }

    public List<String> getMetales() {
        return metales;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUnidadMonetaria() {
        return unidadMonetaria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDiametro(float diametro) {
        this.diametro = diametro;
    }

    public void setMetales(List<String> metales) {
        this.metales = metales;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setUnidadMonetaria(String unidadMonetaria) {
        this.unidadMonetaria = unidadMonetaria;
    }

    public void setValorFacial(double valorFacial) {
        this.valorFacial = valorFacial;
    }

}
