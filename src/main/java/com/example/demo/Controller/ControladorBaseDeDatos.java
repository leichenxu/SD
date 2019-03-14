package com.example.demo.Controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.Model.*;
import com.example.demo.Repository.*;

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
        Proveedor p = repP.save(new Proveedor("CIF", "nombre", "cp", "email", "telefono"));
        Moneda mone = repM.save(new Moneda(0, "peseta", 0, 0, new ArrayList<String>(), "descripcion", 0));
        repE.save(new Ejemplar(new Date(1998, 10, 1), "ciudad", new Date(1998, 8, 7), "conservacion", p, mone));
    }
}
