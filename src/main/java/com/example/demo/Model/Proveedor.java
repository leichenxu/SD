package com.example.demo.Model;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Proveedor {
    @Id
    private long id;
    private String codigoIdentificacionFiscal;
    private String nombre;
    private String codigoPostal;
    private String email;
    private String telefono;
    @OneToOne
    private Ejemplar ejemplar;

    public Proveedor() {

    }

    public Proveedor(String codigoIdentificacionFiscal, String nombre, String codigoPostal, String email,
                     String telefono) {
        this.codigoIdentificacionFiscal = codigoIdentificacionFiscal;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.telefono = telefono;
        this.id = (long) codigoIdentificacionFiscal.hashCode();
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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
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
