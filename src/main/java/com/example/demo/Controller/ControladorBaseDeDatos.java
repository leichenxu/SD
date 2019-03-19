package com.example.demo.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
        Proveedor p = repP.save(new Proveedor("B0000000A", "Calderilla",
        		"47001", "calderilla@correo", "000000000"));
        List<String> l=new ArrayList<String>();
        l.add("oro");
        Moneda mone = repM.save(new Moneda(-1, "Doblón español de oro",
        		-1, 6.77f, l, "Ninguna descripción", 1));
        repE.save(new Ejemplar(new java.sql.Date(1634,1,1), "Valladolid", new java.sql.Date(2000, 1, 1), 
        		"Sin datos", p, mone));
    }
}
