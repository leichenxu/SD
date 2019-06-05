package com.example.demo.Repository;

import com.example.demo.Model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioProveedor extends JpaRepository<Proveedor, Long> {
    Proveedor findAllByNombre(String name);

    List<Proveedor> findAllByOrderByCodigoIdentificacionFiscalAsc();

    List<Proveedor> findAllByOrderByCodigoIdentificacionFiscalDesc();

    List<Proveedor> findAllByOrderByNombreAsc();

    List<Proveedor> findAllByOrderByNombreDesc();

    List<Proveedor> findAllByOrderByCodigoPostalAsc();

    List<Proveedor> findAllByOrderByCodigoPostalDesc();

    List<Proveedor> findAllByOrderByEmailAsc();

    List<Proveedor> findAllByOrderByEmailDesc();

    List<Proveedor> findAllByOrderByTelefonoAsc();

    List<Proveedor> findAllByOrderByTelefonoDesc();

    Proveedor findByNombre(String nombre);

    Proveedor findByCodigoIdentificacionFiscal(String CIF);
}
