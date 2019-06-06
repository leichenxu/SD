package com.example.demo.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.Model.Ejemplar;
import com.example.demo.Model.Moneda;
import com.example.demo.Model.Proveedor;
import com.example.demo.Repository.RepositorioEjemplar;
import com.example.demo.Repository.RepositorioMoneda;
import com.example.demo.Repository.RepositorioProveedor;

@Controller
@RequestMapping(value = "ejemplar")
public class ControladorEjemplar {
	@Autowired
	private RepositorioEjemplar repE;
	@Autowired
	private RepositorioMoneda repM;
	@Autowired
	private RepositorioProveedor repP;

	@RequestMapping("/{moneda}")
	public String ejemplarDeUnaMoneda(@PathVariable Moneda moneda, Model model) {
		List<Ejemplar> e = repE.findByMoneda(moneda);
		model.addAttribute("Ejemplares", e);
		model.addAttribute("Moneda", moneda);
		return "Ejemplares";
	}

	@RequestMapping("/proveedor/{proveedor}")
	public String ejemplaresDelProveedor(@PathVariable Proveedor proveedor, Model model) {
		List<Ejemplar> e = repE.findByProveedor(proveedor);
		model.addAttribute("Ejemplares", e);
		model.addAttribute("Proveedor", proveedor);
		return "Ejemplares";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteEjemplar(@PathVariable Long id, Model model) {
		this.repE.deleteById(id);
		return "redirect:/PaginaEjemplar";
	}

	@RequestMapping(value = "/edit/{id}")
	public String ejemplarModificar(@PathVariable long id, Model model) {
		model.addAttribute("ejemplar", this.repE.findById(id).get());
		model.addAttribute("Monedas", this.repM.findAll());
		model.addAttribute("Proveedores", this.repP.findAll());
		return "PaginaEditEjemplar";
	}

	private boolean acun = false;

	@RequestMapping(value = "/acun")
	public String EjemplarAsc(Model model) {
		if (!acun) {
			acun = true;
			model.addAttribute("Ejemplares", this.repE.findAllByOrderByAnioAsc());
		} else {
			acun = false;
			model.addAttribute("Ejemplares", this.repE.findAllByOrderByAnioDesc());
		}
		this.defecto(model, true, false, true);
		return "search_result_ejemplar";
	}

	private boolean ciud = false;

	@RequestMapping(value = "/ciud")
	public String ejemplarCiu(Model model) {
		if (!ciud) {
			ciud = true;
			model.addAttribute("Ejemplares", this.repE.findAllByOrderByCiudadAsc());
		} else {
			ciud = false;
			model.addAttribute("Ejemplares", this.repE.findAllByOrderByCiudadDesc());
		}
		this.defecto(model, true, false, true);
		return "search_result_ejemplar";
	}

	private boolean prov = false;

	@RequestMapping(value = "/prov")
	public String ejemplarProv(Model model) {
		if (!prov) {
			prov = true;
			model.addAttribute("Ejemplares", this.repE.findAllByOrderByProveedorAsc());
		} else {
			prov = false;
			model.addAttribute("Ejemplares", this.repE.findAllByOrderByProveedorDesc());
		}
		this.defecto(model, true, false, true);
		return "search_result_ejemplar";
	}

	private boolean fechaAd = false;

	@RequestMapping(value = "/fechaAd")
	public String ejemplarFecha(Model model) {
		if (!fechaAd) {
			fechaAd = true;
			model.addAttribute("Ejemplares", this.repE.findAllByOrderByFechaAdquisicionAsc());
		} else {
			fechaAd = false;
			model.addAttribute("Ejemplares", this.repE.findAllByOrderByFechaAdquisicionDesc());
		}
		this.defecto(model, true, false, true);
		return "search_result_ejemplar";
	}

	@RequestMapping(value = "/ejemplarAniadir", method = RequestMethod.POST)
	public RedirectView ejemplarAniadir(@RequestParam("id") String id, @RequestParam("anio") String anio,
			@RequestParam("ciudad") String ciudad, @RequestParam("fechaAdquisicion") Date fechaA,
			@RequestParam("conservacion") String conservacion, @RequestParam("proveedor") long idProveedor,
			@RequestParam("moneda") long idMoneda, Model model) {
		if (id.equals("")) {
			Ejemplar e = new Ejemplar(Integer.valueOf(anio), ciudad, fechaA, conservacion,
					repP.findById(idProveedor).get(), repM.findById(idMoneda).get());
			repE.save(e);
		} else {
			Ejemplar e=repE.findById(Long.parseLong(id)).get();
			e.modificarEjemplar(Integer.valueOf(anio), ciudad, fechaA, conservacion,
					repP.findById(idProveedor).get(), repM.findById(idMoneda).get());
			repE.save(e);
		}
		return new RedirectView("/PaginaEjemplar");

	}

	private void defecto(Model model, boolean a, boolean b, boolean c) {
		if (a)
			model.addAttribute("Monedas", repM.findAll());
		if (b)
			model.addAttribute("Ejemplares", repE.findAll());
		if (c)
			model.addAttribute("Proveedores", repP.findAll());
	}
}
