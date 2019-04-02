package com.example.demo.Controller;

import com.example.demo.Model.Ejemplar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Moneda;
import com.example.demo.Model.Proveedor;
import com.example.demo.Repository.RepositorioEjemplar;
import com.example.demo.Repository.RepositorioMoneda;
import com.example.demo.Repository.RepositorioProveedor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("moneda")
public class ControladorMoneda {
	@Autowired
	private RepositorioProveedor repP;

    @Autowired
    private RepositorioMoneda repM;

	@Autowired
	private RepositorioEjemplar repE;

    @RequestMapping(value = "/monedaAniadir",method=RequestMethod.POST)
    public String monedaAniadir(@RequestParam("valorFacial") String valorFacial,
    		@RequestParam("unidadMonetaria") String unidadMonetaria,
    		@RequestParam("diametro") String diametro,@RequestParam("peso") String peso,
    		@RequestParam("metales") String metales,@RequestParam("descripcion") String descripcion
    		,Model model) {
    	Moneda moneda=new Moneda(Double.valueOf(valorFacial),unidadMonetaria,Float.valueOf(diametro),
    			Float.valueOf(peso),Arrays.asList(metales.split(",")),descripcion);
        repM.save(moneda);
        return "index";
    }

//    @RequestMapping(value = "/monedaModificar")
//    public String monedaModificar(Model model, Moneda moneda) {
//        return "index";
//    }
//    private boolean asc=false;
//    @RequestMapping(value="/ascDes")
//    public String modenaAsc(Model model) {
//    	if(!asc) {
//    		asc=true;
//    		model.addAttribute("Monedas",this.repM.findAllByOrderByIdAsc());
//    	}else {
//    		asc=false;
//    		model.addAttribute("Monedas",this.repM.findAllByOrderByIdDesc());
//    	}
//        this.defecto(model,false,true,true);
//    	return "index";
//    }
//
//    private boolean val=false;
//    @RequestMapping(value="/val")
//    public String modenaVal(Model model) {
//    	if(!val) {
//    		val=true;
//    		model.addAttribute("Monedas",this.repM.findAllByOrderByValorFacialAsc());
//    	}else {
//    		val=false;
//    		model.addAttribute("Monedas",this.repM.findAllByOrderByValorFacialDesc());
//    	}
//    	this.defecto(model,false,true,true);
//    	return "index";
//    }
//    private boolean uni=false;
//    @RequestMapping(value="/uni")
//    public String modenaUni(Model model) {
//    	if(!uni) {
//    		uni=true;
//    		model.addAttribute("Monedas",this.repM.findAllByOrderByUnidadMonetariaAsc());
//    	}else {
//    		uni=false;
//    		model.addAttribute("Monedas",this.repM.findAllByOrderByUnidadMonetariaDesc());
//    	}
//    	this.defecto(model,false,true,true);
//    	return "index";
//    }
//
//    private boolean diam=false;
//    @RequestMapping(value="/diam")
//    public String modenaDiam(Model model) {
//    	if(!diam) {
//    		diam=true;
//    		model.addAttribute("Monedas",this.repM.findAllByOrderByDiametroAsc());
//    	}else {
//    		diam=false;
//    		model.addAttribute("Monedas",this.repM.findAllByOrderByDiametroDesc());
//    	}
//    	this.defecto(model,false,true,true);
//    	return "index";
//    }
//    private boolean peso=false;
//    @RequestMapping(value="/peso")
//    public String modenaPeso(Model model) {
//    	if(!peso) {
//    		peso=true;
//    		model.addAttribute("Monedas",this.repM.findAllByOrderByPesoAsc());
//    	}else {
//    		peso=false;
//    		model.addAttribute("Monedas",this.repM.findAllByOrderByPesoDesc());
//    	}
//    	this.defecto(model,false,true,true);
//    	return "index";
//    }

    @DeleteMapping("/delete/{moneda}")
    public ResponseEntity<?> deleteMoneda (@PathVariable Moneda moneda){
        this.repM.delete(moneda);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/remove/{moneda}/{ejemplar}")
    public ResponseEntity<?> removeEjemplar (@PathVariable Moneda moneda, @PathVariable Ejemplar ejemplar){
        moneda.removeEjemplar(ejemplar);
        this.repE.delete(ejemplar);
        this.repM.save(moneda);
        return ResponseEntity.noContent().build();
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
