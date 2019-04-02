package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.Model.Ejemplar;
import com.example.demo.Model.Moneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
	@RequestMapping(value = "/proveedorAniadir",method = RequestMethod.POST)
	public String proveedor(@RequestParam("codigoIdentificacionFiscal") String codigoIdentificacionFiscal,
							@RequestParam("nombre") String nombre,
							@RequestParam("codigoPostal") String codigoPostal,
							@RequestParam("email") String email,
							@RequestParam("telefono") String telefono,
							Model model) {
		Proveedor proveedor = new Proveedor(codigoIdentificacionFiscal,nombre,codigoPostal,email,telefono);
		repP.save(proveedor);
		return "index";
	}

	@RequestMapping(value = "/monedaAniadir",method= RequestMethod.POST)
	public String monedaAniadir(@RequestParam("valorFacial") String valorFacial,
								@RequestParam("unidadMonetaria") String unidadMonetaria,
								@RequestParam("diametro") String diametro,@RequestParam("peso") String peso,
								@RequestParam("metales") String metales,@RequestParam("descripcion") String descripcion
			,Model model) {
		Moneda moneda=new Moneda(Double.valueOf(valorFacial),unidadMonetaria,Float.valueOf(diametro),
				Float.valueOf(peso), Arrays.asList(metales.split(",")),descripcion);

		return "index";
	}

	@DeleteMapping("/delete/{proveedor}")
	public ResponseEntity<?> removeEjemplar (@PathVariable Proveedor proveedor){
		this.repP.delete(proveedor);
		return ResponseEntity.noContent().build();
	}
}
