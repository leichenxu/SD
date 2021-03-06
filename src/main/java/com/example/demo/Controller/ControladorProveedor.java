package com.example.demo.Controller;

import com.example.demo.Model.Ejemplar;
import com.example.demo.Model.Proveedor;
import com.example.demo.Repository.RepositorioEjemplar;
import com.example.demo.Repository.RepositorioMoneda;
import com.example.demo.Repository.RepositorioProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

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
    public RedirectView proveedor(@RequestParam("id") String id,
                                  @RequestParam("codigoIdentificacionFiscal") String codigoIdentificacionFiscal,
                                  @RequestParam("nombre") String nombre,
                                  @RequestParam("codigoPostal") int codigoPostal,
                                  @RequestParam("email") String email,
                                  @RequestParam("telefono") String telefono,
                                  Model model) {
        // Añadir proveedor
        if (id.equals("")) {
            // CIF no existente, añadir proveedor
            if (this.repP.findByCodigoIdentificacionFiscal(codigoIdentificacionFiscal) == null) {
                Proveedor proveedor = new Proveedor(codigoIdentificacionFiscal, nombre, codigoPostal, email, telefono);
                repP.save(proveedor);
                // CIF existente, modificar proveedor
            } else {
                Proveedor p = this.repP.findByCodigoIdentificacionFiscal(codigoIdentificacionFiscal);
                p.modificarProveedor(codigoIdentificacionFiscal, nombre, codigoPostal, email, telefono);
                this.repP.save(p);
            }
        // Editar proveedor
        } else {
            Proveedor p = this.repP.findById(Long.parseLong(id)).get();
            p.modificarProveedor(codigoIdentificacionFiscal, nombre, codigoPostal, email, telefono);
            this.repP.save(p);
        }
        return new RedirectView("/PaginaProveedor");
    }

    @RequestMapping(value = "/edit/{id}")
    public String proveedorModificar(@PathVariable long id, Model model) {
        model.addAttribute("proveedor", this.repP.findById(id).get());
        return "PaginaEditProveedor";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteProveedor(@PathVariable Long id, Model model) {
        this.repP.deleteById(id);
        return "redirect:/PaginaProveedor";
    }
    /*
     * @DeleteMapping("/delete/{proveedor}") public ResponseEntity<?>
     * removeEjemplar(@PathVariable Proveedor proveedor) {
     * this.repP.delete(proveedor); return ResponseEntity.noContent().build(); }
     */

    private boolean CIFAscDes = false;

    @RequestMapping(value = "/CIF")
    public String provResultCIF(Model model) {
        if (!CIFAscDes) {
            CIFAscDes = true;
            model.addAttribute("Proveedores", this.repP.findAllByOrderByCodigoIdentificacionFiscalAsc());
        } else {
            CIFAscDes = false;
            model.addAttribute("Proveedores", this.repP.findAllByOrderByCodigoIdentificacionFiscalDesc());
        }
        return "PaginaTodosLosProveedores";
    }

    private boolean nomb = false;

    @RequestMapping(value = "nombre")
    public String provResultNombre(Model model) {
        if (!nomb) {
            nomb = true;
            model.addAttribute("Proveedores", this.repP.findAllByOrderByNombreAsc());
        } else {
            nomb = false;
            model.addAttribute("Proveedores", this.repP.findAllByOrderByNombreDesc());
        }
        return "PaginaTodosLosProveedores";
    }

    private boolean codigoP = false;

    @RequestMapping(value = "/codigoPostal")
    public String codPAsc(Model model) {
        if (!codigoP) {
            codigoP = true;
            model.addAttribute("Proveedores", this.repP.findAllByOrderByCodigoPostalAsc());
        } else {
            codigoP = false;
            model.addAttribute("Proveedores", this.repP.findAllByOrderByCodigoPostalDesc());
        }
        return "PaginaTodosLosProveedores";
    }

    private boolean email = false;

    @RequestMapping(value = "/email")
    public String emailAsc(Model model) {
        if (!email) {
            email = true;
            model.addAttribute("Proveedores", this.repP.findAllByOrderByEmailAsc());
        } else {
            email = false;
            model.addAttribute("Proveedores", this.repP.findAllByOrderByEmailDesc());
        }
        return "PaginaTodosLosProveedores";
    }

    private boolean telefono = false;

    @RequestMapping(value = "/telefono")
    public String telefAsc(Model model) {
        if (!telefono) {
            telefono = true;
            model.addAttribute("Proveedores", this.repP.findAllByOrderByTelefonoAsc());
        } else {
            telefono = false;
            model.addAttribute("Proveedores", this.repP.findAllByOrderByTelefonoDesc());
        }
        return "PaginaTodosLosProveedores";
    }

    private void defecto(Model model, boolean a, boolean b, boolean c) {
        if (a)
            model.addAttribute("Monedas", repM.findAll());
        if (b)
            model.addAttribute("Ejemplares", repE.findAll());
        if (c)
            model.addAttribute("Proveedores", repP.findAll());
    }

    @RequestMapping("/searchProveedor")
    public String buscarProveedor(String opcion, String valor, Model model) {
        List<Proveedor> proveedores = null;
        switch (opcion) {
            case "CIF":
                proveedores = this.repP.findAllByCodigoIdentificacionFiscal(valor);
                break;
            case "nombre":
                proveedores = this.repP.findAllByNombre(valor);
                break;
            case "CP":
                proveedores = this.repP.findAllByCodigoPostal(Integer.parseInt(valor));
                break;
        }
        model.addAttribute("Proveedores", proveedores);
        return "search_result_proveedor";
    }

}
