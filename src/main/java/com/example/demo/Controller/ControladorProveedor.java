package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.Model.Ejemplar;
import com.example.demo.Model.Moneda;
import com.example.demo.Repository.RepositorioEjemplar;
import com.example.demo.Repository.RepositorioMoneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.Model.Proveedor;
import com.example.demo.Repository.RepositorioProveedor;

@Controller
@RequestMapping("proveedor")
public class ControladorProveedor {
	@Autowired
	private RepositorioMoneda repM;

	@Autowired
	private RepositorioEjemplar repE;

	@Autowired
	private RepositorioProveedor repP;

	@RequestMapping("/{ejemplar}")
	public String proveedorDeUnEjemplar(@PathVariable Ejemplar ejemplar, Model model) {
		model.addAttribute("Proveedor", ejemplar.getProveedor());
		model.addAttribute("Ejemplar", ejemplar);
		return "ProveedorDeUnEjemplar";
	}

	@RequestMapping(value = "/proveedorAniadir", method = RequestMethod.POST)
	public RedirectView proveedor(@RequestParam("id") String id,
			@RequestParam("codigoIdentificacionFiscal") String codigoIdentificacionFiscal,
			@RequestParam("nombre") String nombre, @RequestParam("codigoPostal") String codigoPostal,
			@RequestParam("email") String email, @RequestParam("telefono") String telefono, Model model) {
		if (id.equals("")) {
			Proveedor proveedor = new Proveedor(codigoIdentificacionFiscal, nombre, codigoPostal, email, telefono);
			repP.save(proveedor);
		} else {
			
			Proveedor p=this.repP.findById(Long.parseLong(id)).get();
			p.modificarProveedor(codigoIdentificacionFiscal, nombre, codigoPostal, email, telefono);
			this.repP.save(p);
		}
		return new RedirectView("/PaginaProveedor");
	}

	@RequestMapping(value = "/edit/{id}")
	public String proveedorModificar(@PathVariable long id, Model model) {
		model.addAttribute("proveedor", this.repP.findById(id).get());
		return "PaginaEditProveedor";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteProveedor(@PathVariable Long id, Model model) {
		this.repP.deleteById(id);
		return "redirect:/PaginaProveedor";
	}
	/*
	 * @DeleteMapping("/delete/{proveedor}") public ResponseEntity<?>
	 * removeEjemplar(@PathVariable Proveedor proveedor) {
	 * this.repP.delete(proveedor); return ResponseEntity.noContent().build(); }
	 */

	private boolean CIFAscDes = false;

	@RequestMapping(value = "/CIF")
	public String provResultCIF(Model model) {
		if (!CIFAscDes) {
			CIFAscDes = true;
			model.addAttribute("Proveedor", this.repP.findAllByOrderByCodigoIdentificacionFiscalAsc());
		} else {
			CIFAscDes = false;
			model.addAttribute("Proveedor", this.repP.findAllByOrderByCodigoIdentificacionFiscalDesc());
		}
		return "search_result_proveedor";
	}

	private boolean nomb = false;

	@RequestMapping(value = "nombre")
	public String provResultNombre(Model model) {
		if (!nomb) {
			nomb = true;
			model.addAttribute("Proveedor", this.repP.findAllByOrderByNombreAsc());
		} else {
			nomb = false;
			model.addAttribute("Proveedor", this.repP.findAllByOrderByNombreDesc());
		}
		return "search_result_proveedor";

	}

	private boolean codigoP = false;

	@RequestMapping(value = "/codigoPostal")
	public String codPAsc(Model model) {
		if (!codigoP) {
			codigoP = true;
			model.addAttribute("Proveedor", this.repP.findAllByOrderByCodigoPostalAsc());
		} else {
			codigoP = false;
			model.addAttribute("Proveedor", this.repP.findAllByOrderByCodigoPostalDesc());
		}
		return "search_result_proveedor";
	}

	private boolean email = false;

	@RequestMapping(value = "/email")
	public String emailAsc(Model model) {
		if (!email) {
			email = true;
			model.addAttribute("Proveedor", this.repP.findAllByOrderByEmailAsc());
		} else {
			email = false;
			model.addAttribute("Proveedor", this.repP.findAllByOrderByEmailDesc());
		}
		return "search_result_proveedor";
	}

	private boolean telefono = false;

	@RequestMapping(value = "/telefono")
	public String telefAsc(Model model) {
		if (!telefono) {
			telefono = true;
			model.addAttribute("Proveedor", this.repP.findAllByOrderByTelefonoAsc());
		} else {
			telefono = false;
			model.addAttribute("Proveedor", this.repP.findAllByOrderByTelefonoDesc());
		}
		return "search_result_proveedor";
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
