package com.example.demo.Repository;

import com.example.demo.Model.Ejemplar;
import com.example.demo.Model.Moneda;
import com.example.demo.Model.Proveedor;

import java.sql.Date;
import java.util.List;

import javax.persistence.OneToOne;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEjemplar extends JpaRepository<Ejemplar,Long> {
	List<Ejemplar> findByAnioAndCiudadAndFechaAdquisicionAndConservacionAndProveedorAndMoneda
	(int i,String ciudad,String string,String conservacion,Proveedor proveedor,
			Moneda moneda);
	List<Ejemplar> findByMoneda(Moneda moneda);
}
