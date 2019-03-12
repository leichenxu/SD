package com.example.demo.Repository;

import com.example.demo.Model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProveedor extends JpaRepository<Proveedor,Long> {
}
