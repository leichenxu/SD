package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Ejemplar;
import com.example.demo.Repository.RepositorioEjemplar;

@Controller
public class ControladorEjemplar {
	@Autowired
	private RepositorioEjemplar repE;
	
	@RequestMapping(value="/ejemplarAniadir")
	public String ejemplarAniadir(Model model,Ejemplar ejemplar) {
		repE.save(ejemplar);
		return "index";
	}
	@RequestMapping(value="/ejemplarConsultar")
	public String ejemplaConsultar(Model model,Ejemplar ejemplar) {
		repE.save(ejemplar);
		return "index";
	}
}
