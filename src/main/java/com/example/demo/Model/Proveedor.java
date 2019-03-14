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
	public Proveedor(Long codigoIdentificacionFiscal,String nombre, String codigoPostal, String email,
			String telefono) {
		this.codigoIdentificacionFiscal=codigoIdentificacionFiscal;
		this.nombre = nombre;
		this.codigoPostal = codigoPostal;
		this.email = email;
		this.telefono = telefono;
	}
	public Long getCodigoIdentificacionFiscal() {
		return codigoIdentificacionFiscal;
	}
	public void setCodigoIdentificacionFiscal(Long codigoIdentificacionFiscal) {
		this.codigoIdentificacionFiscal = codigoIdentificacionFiscal;
	}
	public String getNombre() {
		return nombre;
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
