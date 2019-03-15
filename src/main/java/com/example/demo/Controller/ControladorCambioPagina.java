package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorCambioPagina {
	@RequestMapping(value="/PaginaEjemplar")
	public String ejemplar(Model model) {
		return "Ejemplares";
	}
	@RequestMapping(value="/PaginaMoneda")
	public String moneda(Model model) {
		return "index";
	}
	@RequestMapping(value="/PaginaProveedor")
	public String proveedor(Model model) {
		return "Proveedores";
	}
}
