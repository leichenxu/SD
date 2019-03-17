package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Moneda;
import com.example.demo.Model.Proveedor;
import com.example.demo.Repository.RepositorioMoneda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ControladorMoneda {
    @Autowired
    private RepositorioMoneda repM;

	public static List<Moneda> lM=new ArrayList<Moneda>();

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
