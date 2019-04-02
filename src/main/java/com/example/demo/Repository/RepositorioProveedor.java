package com.example.demo.Repository;

import com.example.demo.Model.Ejemplar;
import com.example.demo.Model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioProveedor extends JpaRepository<Proveedor,Long> {
    Proveedor findAllByNombre(String name);
    List<Proveedor> findAllByOrderByCodigoIdentificacionFiscalAsc();
    List<Proveedor> findAllByOrderByCodigoIdentificacionFiscalDesc();
    //List<Proveedor> findAllByOrderByCodigoPostalAsc();
    List<Proveedor> findAllByOrderByEjemplarAsc();
    List<Proveedor> findAllByOrderByNombreAsc();

}
