package com.example.demo.Controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Ejemplar;
import com.example.demo.Model.Moneda;
import com.example.demo.Model.Proveedor;
import com.example.demo.Repository.RepositorioEjemplar;
import com.example.demo.Repository.RepositorioMoneda;
import com.example.demo.Repository.RepositorioProveedor;

@Controller
public class ControladorEjemplar {
	@Autowired
	private RepositorioEjemplar repE;
	@Autowired
	private RepositorioMoneda repM;
	@Autowired
	private RepositorioProveedor repP;
	@RequestMapping(value="/ejemplar")
	public String ejemplarDeUnaMoneda(@RequestParam Long id,Model model) {
		Moneda m=repM.findById(id).get();
		List<Ejemplar> e=repE.findByMoneda(m);
		model.addAttribute("Ejemplares",e);
		return "Ejemplares";
	}
	@RequestMapping(value="/ejemplarAniadir")
	public String ejemplarAniadir(Model model, Ejemplar ejemplar,Moneda moneda) {
		ejemplar.setMoneda(moneda);
		repE.save(ejemplar);
		return "index";
	}

	@RequestMapping(value = "/ejemplarConsultar")
	public String ejemplaConsultar(Model model, Ejemplar ejemplar) {
		List<Ejemplar> e = repE.findByAnioAndCiudadAndFechaAdquisicionAndConservacionAndProveedorAndMoneda(ejemplar.getAnio(),ejemplar.getCiudad(),
				ejemplar.getFechaAdquisicion(),ejemplar.getConservacion(),
				ejemplar.getProveedor(),
				ejemplar.getMoneda());
		if(!e.isEmpty()) {
			model.addAttribute("ejemplar",e.get(0));
		}
		return "";
	}
	@RequestMapping(value = "/ejemplarModificar")
	public String ejemplaModificar(Model model, Ejemplar ejemplar,Ejemplar ejemplarNuevo) {
		List<Ejemplar> e = repE.findByAnioAndCiudadAndFechaAdquisicionAndConservacionAndProveedorAndMoneda(
				ejemplar.getAnio(),ejemplar.getCiudad(),
				ejemplar.getFechaAdquisicion(),ejemplar.getConservacion(),
				ejemplar.getProveedor(),
				ejemplar.getMoneda());
		if(!e.isEmpty()) {
			repE.delete(e.get(0));
			repE.save(ejemplarNuevo);
		}
		return "";
	}
	
}
