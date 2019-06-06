package com.example.demo.Controller;

import com.example.demo.Model.Ejemplar;
import com.example.demo.Model.Moneda;
import com.example.demo.Model.Proveedor;
import com.example.demo.Repository.RepositorioEjemplar;
import com.example.demo.Repository.RepositorioMoneda;
import com.example.demo.Repository.RepositorioProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

@Controller
public class ControladorBaseDeDatos {
    @Autowired
    private RepositorioEjemplar repE;
    @Autowired
    private RepositorioMoneda repM;
    @Autowired
    private RepositorioProveedor repP;

    @PostConstruct
    public void init() {
        Proveedor p = repP.save(new Proveedor("B0000000A", "Calderilla",
                "47001", "calderilla@correo", "000000000"));
        Moneda mone = repM.save(new Moneda(1, "Doblón español de oro",
                1, 6.77f, "Oro", "Ninguna descripción"));
        Ejemplar e = repE.save(new Ejemplar(1634, "Valladolid", Date.valueOf(LocalDate.of(2000, Month.JANUARY, 1)),
                "Sin datos", p, mone));
        mone.getListaEjemplares().add(e);
        e.setProveedor(p);
        e = repE.save(e);
    }
}
