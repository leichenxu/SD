package com.example.demo.Repository;


import com.example.demo.Model.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMoneda extends JpaRepository<Moneda,Long> {
}
