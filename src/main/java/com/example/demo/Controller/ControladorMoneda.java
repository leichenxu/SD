package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Moneda;
import com.example.demo.Repository.RepositorioMoneda;

@Controller
public class ControladorMoneda {
	@Autowired
	private RepositorioMoneda repM;

	@RequestMapping(value = "/moneda")
	public String moneda(Model model, Moneda moneda) {
		repM.save(moneda);
		return "index";
	}
}
