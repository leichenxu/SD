package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.Ejemplar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Proveedor;
import com.example.demo.Repository.RepositorioProveedor;

@Controller
@RequestMapping("proveedor")
public class ControladorProveedor {
	@Autowired
	private RepositorioProveedor repP;

	@RequestMapping("/{ejemplar}")
	public String proveedorDeUnEjemplar(@PathVariable Ejemplar ejemplar, Model model) {
		model.addAttribute("Proveedor",ejemplar.getProveedor());
		model.addAttribute("Ejemplar",ejemplar);
		return "ProveedorDeUnEjemplar";
	}
	@RequestMapping(value = "/proveedorAniadir")
	public String proveedor(Model model, Proveedor proveedor) {
		repP.save(proveedor);
		return "index";
	}
}
