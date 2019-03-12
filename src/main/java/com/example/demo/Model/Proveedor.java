package com.example.demo.Model;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Proveedor {
    @Id
    @GeneratedValue
    private Long codigoIdentificacionFiscal;
    private String nombre;
    private String codigoPostal;
    private String email;
    private String telefono;
    public Proveedor(){

    }

}
