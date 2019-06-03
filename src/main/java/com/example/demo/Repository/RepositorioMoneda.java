package com.example.demo.Repository;


import com.example.demo.Model.Moneda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMoneda extends JpaRepository<Moneda,Long> {
	List<Moneda> findAllByOrderByIdAsc();
	List<Moneda> findAllByOrderByIdDesc();
	List<Moneda> findAllByOrderByValorFacialAsc();
	List<Moneda> findAllByOrderByValorFacialDesc();
	List<Moneda> findAllByOrderByUnidadMonetariaAsc();
	List<Moneda> findAllByOrderByUnidadMonetariaDesc();
	List<Moneda> findAllByOrderByDiametroAsc();
	List<Moneda> findAllByOrderByDiametroDesc();
	List<Moneda> findAllByOrderByPesoAsc();
	List<Moneda> findAllByOrderByPesoDesc();	
}
