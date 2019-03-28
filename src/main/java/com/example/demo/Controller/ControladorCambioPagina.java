package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Repository.RepositorioEjemplar;
import com.example.demo.Repository.RepositorioMoneda;
import com.example.demo.Repository.RepositorioProveedor;

@Controller
public class ControladorCambioPagina {
	@Autowired
	private RepositorioProveedor repP;

    @Autowired
    private RepositorioMoneda repM;

	@Autowired
	private RepositorioEjemplar repE;
//	@RequestMapping(value="/PaginaEjemplar")
//	public String ejemplar(Model model) {
//		model.addAttribute("Ejemplares",repE.findAll());
//		return "Ejemplares";
//	}
	@RequestMapping(value="/")
	public String moneda(Model model) {
		model.addAttribute("Monedas",repM.findAll());
		model.addAttribute("Ejemplares",repE.findAll());
		model.addAttribute("Proveedores",repP.findAll());
		return "index";
	}
//	@RequestMapping(value="/PaginaProveedor")
//	public String proveedor(Model model) {
//		model.addAttribute("Proveedores",repP.findAll());
//		return "Proveedor";
//	}
}
