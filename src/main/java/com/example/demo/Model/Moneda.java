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
    private List<String> metales;
    private String descripcion;
    public Moneda(){

    }
}
