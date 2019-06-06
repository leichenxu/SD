package com.example.demo.Controller;

import com.example.demo.Model.Moneda;
import com.example.demo.Repository.RepositorioEjemplar;
import com.example.demo.Repository.RepositorioMoneda;
import com.example.demo.Repository.RepositorioProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("moneda")
public class ControladorMoneda {
    @Autowired
    private RepositorioProveedor repP;

    @Autowired
    private RepositorioMoneda repM;

    @Autowired
    private RepositorioEjemplar repE;

    @RequestMapping(value = "/monedaAniadir", method = RequestMethod.POST)
    public String monedaAniadir(@RequestParam("id") String id,
                                @RequestParam("valorFacial") Double valorFacial,
                                @RequestParam("unidadMonetaria") String unidadMonetaria,
                                @RequestParam("diametro") float diametro,
                                @RequestParam("peso") float peso,
                                @RequestParam("metales") String metales,
                                @RequestParam("descripcion") String descripcion,
                                Model model) {
        if (id.equals("")) {
            Moneda moneda = new Moneda(valorFacial, unidadMonetaria, diametro,
                    peso, metales, descripcion);
            repM.save(moneda);
        } else {
            Moneda m = this.repM.findById(Long.parseLong(id)).get();
            m.modificarMoneda(valorFacial, unidadMonetaria, diametro,
                    peso, metales, descripcion);
            this.repM.save(m);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}")
    public String monedaModificar(@PathVariable long id, Model model) {
        model.addAttribute("moneda", this.repM.findById(id).get());
        return "PaginaEditMoneda";
    }

    private boolean asc = false;

    @RequestMapping(value = "/ascDes")
    public String modenaAsc(Model model) {
        if (!asc) {
            asc = true;
            model.addAttribute("Monedas", this.repM.findAllByOrderByIdAsc());
        } else {
            asc = false;
            model.addAttribute("Monedas", this.repM.findAllByOrderByIdDesc());
        }
        this.defecto(model, false, true, true);
        return "search_result_moneda";
    }

    private boolean val = false;

    @RequestMapping(value = "/val")
    public String modenaVal(Model model) {
        if (!val) {
            val = true;
            model.addAttribute("Monedas", this.repM.findAllByOrderByValorFacialAsc());
        } else {
            val = false;
            model.addAttribute("Monedas", this.repM.findAllByOrderByValorFacialDesc());
        }
        this.defecto(model, false, true, true);
        return "search_result_moneda";
    }

    private boolean uni = false;

    @RequestMapping(value = "/uni")
    public String modenaUni(Model model) {
        if (!uni) {
            uni = true;
            model.addAttribute("Monedas", this.repM.findAllByOrderByUnidadMonetariaAsc());
        } else {
            uni = false;
            model.addAttribute("Monedas", this.repM.findAllByOrderByUnidadMonetariaDesc());
        }
        this.defecto(model, false, true, true);
        return "search_result_moneda";
    }

    private boolean diam = false;

    @RequestMapping(value = "/diam")
    public String modenaDiam(Model model) {
        if (!diam) {
            diam = true;
            model.addAttribute("Monedas", this.repM.findAllByOrderByDiametroAsc());
        } else {
            diam = false;
            model.addAttribute("Monedas", this.repM.findAllByOrderByDiametroDesc());
        }
        this.defecto(model, false, true, true);
        return "search_result_moneda";
    }

    @PostMapping(value = "/BusquedadV")
    public String valorFacial(Model model) {
        model.addAttribute("Monedas", repM.findAllByOrderByValorFacialAsc());
        return "search_result_moneda";
    }

    private boolean peso = false;

    @RequestMapping(value = "/peso")
    public String modenaPeso(Model model) {
        if (!peso) {
            peso = true;
            model.addAttribute("Monedas", this.repM.findAllByOrderByPesoAsc());
        } else {
            peso = false;
            model.addAttribute("Monedas", this.repM.findAllByOrderByPesoDesc());
        }
        this.defecto(model, false, true, true);
        return "search_result_moneda";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteMoneda(@PathVariable Long id, Model model) {
        this.repM.deleteById(id);
        return "redirect:/";
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
