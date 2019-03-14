package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Proveedor;
import com.example.demo.Repository.RepositorioProveedor;

@Controller
public class ControladorProveedor {
	@Autowired
	private RepositorioProveedor repP;

	@RequestMapping(value = "/proveedorAniadir")
	public String proveedor(Model model, Proveedor proveedor) {
		repP.save(proveedor);
		return "index";
	}
}
