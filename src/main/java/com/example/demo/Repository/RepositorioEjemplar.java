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

    List<Ejemplar> findByMonedaOrderByAnioAsc(Moneda moneda);

    List<Ejemplar> findByMonedaOrderByAnioDesc(Moneda moneda);

    List<Ejemplar> findByIdOrderByAnioAsc(Long id);

    List<Ejemplar> findByIdOrderByAnioDesc(Long id);

    List<Ejemplar> findByMonedaOrderByCiudadAsc(Moneda moneda);

    List<Ejemplar> findByMonedaOrderByCiudadDesc(Moneda moneda);

    List<Ejemplar> findByMonedaOrderByFechaAdquisicionAsc(Moneda moneda);

    List<Ejemplar> findByMonedaOrderByFechaAdquisicionDesc(Moneda moneda);

    List<Ejemplar> findByMonedaOrderByProveedorAsc(Moneda moneda);

    List<Ejemplar> findByMonedaOrderByProveedorDesc(Moneda moneda);

    List<Ejemplar> findByProveedorOrderByAnioAsc(Proveedor proveedor);

    List<Ejemplar> findByProveedorOrderByAnioDesc(Proveedor proveedor);

    List<Ejemplar> findByProveedorOrderByCiudadAsc(Proveedor proveedor);

    List<Ejemplar> findByProveedorOrderByCiudadDesc(Proveedor proveedor);

    List<Ejemplar> findByProveedorOrderByFechaAdquisicionAsc(Proveedor proveedor);

    List<Ejemplar> findByProveedorOrderByFechaAdquisicionDesc(Proveedor proveedor);

}
