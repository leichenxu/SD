package com.example.demo.Controller;

import com.example.demo.Model.Moneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("Monedas",repM.findAll());
		model.addAttribute("Ejemplares",repE.findAll());
		model.addAttribute("Proveedores",repP.findAll());
		return "index";
	}

}
