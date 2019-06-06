package com.example.demo.Repository;

import com.example.demo.Model.Ejemplar;
import com.example.demo.Model.Moneda;
import com.example.demo.Model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface RepositorioEjemplar extends JpaRepository<Ejemplar, Long> {
    List<Ejemplar> findByAnioAndCiudadAndFechaAdquisicionAndConservacionAndProveedorAndMoneda
            (int i, String ciudad, Date date, String conservacion, Proveedor proveedor,
             Moneda moneda);

    List<Ejemplar> findByMoneda(Moneda moneda);

    List<Ejemplar> findByProveedor(Proveedor proveedor);

    List<Ejemplar> findAllByOrderByAnioAsc();

    List<Ejemplar> findAllByOrderByAnioDesc();

    List<Ejemplar> findAllByOrderByCiudadAsc();

    List<Ejemplar> findAllByOrderByCiudadDesc();

    List<Ejemplar> findAllByOrderByFechaAdquisicionAsc();

    List<Ejemplar> findAllByOrderByFechaAdquisicionDesc();

    List<Ejemplar> findAllByOrderByProveedorAsc();

    List<Ejemplar> findAllByOrderByProveedorDesc();
}
