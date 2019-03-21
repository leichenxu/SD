package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Moneda;
import com.example.demo.Model.Proveedor;
import com.example.demo.Repository.RepositorioMoneda;

import java.util.ArrayList;
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

    @RequestMapping(value = "/monedaAniadir")
    public String monedaAniadir(Model model, Moneda moneda) {
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
}
