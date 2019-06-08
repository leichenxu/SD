package com.example.demo.Controller;

import com.example.demo.Repository.RepositorioEjemplar;
import com.example.demo.Repository.RepositorioMoneda;
import com.example.demo.Repository.RepositorioProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute("Monedas", repM.findAll());
        model.addAttribute("Ejemplares", repE.findAll());
        model.addAttribute("Proveedores", repP.findAll());
        return "index";
    }

    @GetMapping("/PaginaEjemplar")
    public String paginaEjemplar(Model model) {
        model.addAttribute("Monedas", repM.findAll());
        model.addAttribute("Ejemplares", repE.findAll());
        model.addAttribute("Proveedores", repP.findAll());
        return "PaginaTodosLosEjemplares";
    }

    @GetMapping("/PaginaProveedor")
    public String paginaProveedor(Model model) {
        model.addAttribute("Monedas", repM.findAll());
        model.addAttribute("Ejemplares", repE.findAll());
        model.addAttribute("Proveedores", repP.findAll());
        return "PaginaTodosLosProveedores";
    }

    @GetMapping("/paginaAddMoneda")
    public String paginaAddMoneda(Model model) {
        return "PaginaEditMoneda";
    }

    @GetMapping("/paginaAddEjemplar")
    public String paginaAddEjemplar(Model model) {
        model.addAttribute("Monedas", repM.findAll());
        model.addAttribute("Proveedores", repP.findAll());
        return "PaginaEditEjemplar";
    }

    @GetMapping("/paginaAddProveedor")
    public String paginaAddProveedor(Model model) {
        return "PaginaEditProveedor";
    }

    @GetMapping("/paginaSearchMoneda")
    public String paginaSearchMoneda(Model model) {
        return "search_moneda";
    }

    @GetMapping("/paginaSearchEjemplar")
    public String paginaSearchEjemplar(Model model) {
        return "search_ejemplar";
    }

    @GetMapping("/paginaSearchProveedor")
    public String paginaSearchProveedor(Model model) {
        return "search_proveedor";
    }

}
