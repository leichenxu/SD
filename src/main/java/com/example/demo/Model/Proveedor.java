package com.example.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Proveedor {
    @Id
    @GeneratedValue
    private long id;

    private String codigoIdentificacionFiscal;
    private String nombre;
    private int codigoPostal;
    private String email;
    private String telefono;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<Ejemplar> ejemplares;

    public Proveedor() {

    }

    public Proveedor(String codigoIdentificacionFiscal, String nombre, int codigoPostal, String email,
                     String telefono) {
        this.codigoIdentificacionFiscal = codigoIdentificacionFiscal;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.telefono = telefono;
    }

    public void modificarProveedor(String codigoIdentificacionFiscal, String nombre, int codigoPostal, String email,
                                   String telefono) {
        this.codigoIdentificacionFiscal = codigoIdentificacionFiscal;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.telefono = telefono;
    }

    public String getCodigoIdentificacionFiscal() {
        return codigoIdentificacionFiscal;
    }

    public void setCodigoIdentificacionFiscal(String codigoIdentificacionFiscal) {
        this.codigoIdentificacionFiscal = codigoIdentificacionFiscal;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public long getId() {
        return this.id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
