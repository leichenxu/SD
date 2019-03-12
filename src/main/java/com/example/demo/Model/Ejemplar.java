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
    private Proveedor proveedor;
    public Ejemplar(){
        
    }
}
