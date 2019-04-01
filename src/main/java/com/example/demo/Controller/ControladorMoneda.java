package com.example.demo.Controller;

import com.example.demo.Model.Ejemplar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Moneda;
import com.example.demo.Model.Proveedor;
import com.example.demo.Repository.RepositorioMoneda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("moneda")
public class ControladorMoneda {
    @Autowired
    private RepositorioMoneda repM;

    @PostMapping
    public ResponseEntity<?> addMoneda (@ModelAttribute Moneda moneda){
        this.repM.save(moneda);
        return ResponseEntity.noContent().build();
    }
    
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

    @RequestMapping(value = "/monedaModificar")
    public String monedaModificar(Model model, Moneda moneda) {
        return "index";
    }

    @RequestMapping(value = "/monedaConsultar")
    public String monedaConsultar(Model model, Moneda moneda) {
        Optional<Moneda> m = repM.findById(moneda.getId());
        if (m.isPresent()) {
            model.addAttribute("moneda", m.get());
        }
        return "";
    }

    @DeleteMapping("/delete/{moneda}")
    public ResponseEntity<?> deleteMoneda (@PathVariable Moneda moneda){
        this.repM.delete(moneda);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/remove/{moneda}/{ejemplar}")
    public ResponseEntity<?> removeRequest (@PathVariable Moneda moneda, @PathVariable Ejemplar ejemplar){
        moneda.removeEjemplar(ejemplar);
        this.repM.save(moneda);
        return ResponseEntity.noContent().build();
    }
}
