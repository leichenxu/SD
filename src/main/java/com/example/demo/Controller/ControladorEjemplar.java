package com.example.demo.Controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Ejemplar;
import com.example.demo.Model.Moneda;
import com.example.demo.Model.Proveedor;
import com.example.demo.Repository.RepositorioEjemplar;
import com.example.demo.Repository.RepositorioMoneda;
import com.example.demo.Repository.RepositorioProveedor;

@Controller
@RequestMapping(value="ejemplar")
public class ControladorEjemplar {
	@Autowired
	private RepositorioEjemplar repE;
	@Autowired
	private RepositorioMoneda repM;
	@Autowired
	private RepositorioProveedor repP;
	@RequestMapping(value="/")
	public String ejemplarDeUnaMoneda(@RequestParam Long id,Model model) {
		Moneda m=repM.findById(id).get();
		List<Ejemplar> e=repE.findByMoneda(m);
		model.addAttribute("Ejemplares",e);
		model.addAttribute("Moneda",m);
		return "Ejemplares";
	}
	@RequestMapping(value="/ejemplarAniadir")
	public String ejemplarAniadir(Model model, Ejemplar ejemplar,Moneda moneda) {
		ejemplar.setMoneda(moneda);
		repE.save(ejemplar);
		return "index";
	}

	@RequestMapping(value = "/ejemplarModificar")
	public String ejemplaModificar(Model model, Ejemplar ejemplar,Ejemplar ejemplarNuevo) {
		List<Ejemplar> e = repE.findByAnioAndCiudadAndFechaAdquisicionAndConservacionAndProveedorAndMoneda(
				ejemplar.getAnio(),ejemplar.getCiudad(),
				ejemplar.getFechaAdquisicion(),ejemplar.getConservacion(),
				ejemplar.getProveedor(),
				ejemplar.getMoneda());
		if(!e.isEmpty()) {
			repE.delete(e.get(0));
			repE.save(ejemplarNuevo);
		}
		return "";
	}

	private boolean acun=false;
    @RequestMapping(value="/acun")
    public String EjemplarAsc(Model model) {
    	if(!acun) {
    		acun=true;
    		model.addAttribute("Ejemplares",this.repE.findAllByOrderByAnioAsc());
    	}else {
    		acun=false;
    		model.addAttribute("Ejemplares",this.repE.findAllByOrderByAnioDesc());
    	}
        this.defecto(model,true,false,true);
    	return "index";
    }

    private boolean ciud=false;
    @RequestMapping(value="/ciud")
    public String ejemplarCiu(Model model) {
    	if(!ciud) {
    		ciud=true;
    		model.addAttribute("Ejemplares",this.repE.findAllByOrderByCiudadAsc());
    	}else {
    		ciud=false;
    		model.addAttribute("Ejemplares",this.repE.findAllByOrderByCiudadDesc());
    	}
        this.defecto(model,true,false,true);
    	return "index";
    }
    private boolean prov=false;
    @RequestMapping(value="/prov")
    public String ejemplarProv(Model model) {
    	if(!prov) {
    		prov=true;
    		model.addAttribute("Ejemplares",this.repE.findAllByOrderByProveedorAsc());
    	}else {
    		prov=false;
    		model.addAttribute("Ejemplares",this.repE.findAllByOrderByProveedorDesc());
    	}
        this.defecto(model,true,false,true);
    	return "index";
    }

    private boolean fechaAd=false;
    @RequestMapping(value="/fechaAd")
    public String ejemplarFecha(Model model) {
    	if(!fechaAd) {
    		fechaAd=true;
    		model.addAttribute("Ejemplares",this.repE.findAllByOrderByFechaAdquisicionAsc());
    	}else {
    		fechaAd=false;
    		model.addAttribute("Ejemplares",this.repE.findAllByOrderByFechaAdquisicionDesc());
    	}
        this.defecto(model,true,false,true);
    	return "index";
    }


    @RequestMapping(value = "/ejemplarAniadir",method=RequestMethod.POST)
    public String ejemplarAniadir(@RequestParam("anio") String anio,
    		@RequestParam("ciudad") String ciudad,
    		@RequestParam("fechaAdquicicion") Date fechaA,@RequestParam("conservacion") String conservacion,
    		@RequestParam("proveedor") String prov,
    		@RequestParam("moneda") Moneda m,Model model) {
    	Ejemplar e=new Ejemplar(new java.sql.Date(Integer.valueOf(anio),1,1), ciudad, fechaA, conservacion,
                 repP.findById((long) prov.hashCode()).get(), m);
        repE.save(e);
        return "index";
    }

    private void defecto(Model model,boolean a,boolean b,boolean c) {
    	if (a)
    	model.addAttribute("Monedas",repM.findAll());
    	if(b)
		model.addAttribute("Ejemplares",repE.findAll());
    	if(c)
		model.addAttribute("Proveedores",repP.findAll());
    }
}
