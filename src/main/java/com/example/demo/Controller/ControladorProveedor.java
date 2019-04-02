package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.Model.Ejemplar;
import com.example.demo.Model.Moneda;
import com.example.demo.Repository.RepositorioEjemplar;
import com.example.demo.Repository.RepositorioMoneda;
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
    private RepositorioMoneda repM;

    @Autowired
    private RepositorioEjemplar repE;

    @Autowired
    private RepositorioProveedor repP;

    @RequestMapping("/{ejemplar}")
    public String proveedorDeUnEjemplar(@PathVariable Ejemplar ejemplar, Model model) {
        model.addAttribute("Proveedor", ejemplar.getProveedor());
        model.addAttribute("Ejemplar", ejemplar);
        return "ProveedorDeUnEjemplar";
    }

    @RequestMapping(value = "/proveedorAniadir", method = RequestMethod.POST)
    public String proveedor(@RequestParam("codigoIdentificacionFiscal") String codigoIdentificacionFiscal,
                            @RequestParam("nombre") String nombre,
                            @RequestParam("codigoPostal") String codigoPostal,
                            @RequestParam("email") String email,
                            @RequestParam("telefono") String telefono,
                            Model model) {
        Proveedor proveedor = new Proveedor(codigoIdentificacionFiscal, nombre, codigoPostal, email, telefono);
        repP.save(proveedor);
        return "index";
    }

    @DeleteMapping("/delete/{proveedor}")
    public ResponseEntity<?> removeEjemplar(@PathVariable Proveedor proveedor) {
        this.repP.delete(proveedor);
        return ResponseEntity.noContent().build();
    }

    private boolean CIFAscDes = false;

    @RequestMapping(value = "/CIF")
    public String provResultCIF(Model model) {
        if (!CIFAscDes) {
            CIFAscDes = true;
            model.addAttribute("Proveedor", this.repP.findAllByOrderByCodigoIdentificacionFiscalAsc());
        } else {
            CIFAscDes = false;
            model.addAttribute("Proveedor", this.repP.findAllByOrderByCodigoIdentificacionFiscalDesc());
        }
        this.defecto(model, true, true, false);
        return "index";
    }

    @RequestMapping(value = "nombre")
    public String provResultNombre(Model model) {
        model.addAttribute("Proveedor", repP.findAllByOrderByNombreAsc());
        return "search_result_proveedor";
    }

    private void defecto(Model model, boolean a, boolean b, boolean c) {
        if (a)
            model.addAttribute("Monedas", repM.findAll());
        if (b)
            model.addAttribute("Ejemplares", repE.findAll());
        if (c)
            model.addAttribute("Proveedores", repP.findAll());
    }
}
