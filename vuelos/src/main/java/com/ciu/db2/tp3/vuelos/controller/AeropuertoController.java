package com.ciu.db2.tp3.vuelos.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ciu.db2.tp3.vuelos.service.AeropuertoService;


@RestController
@RequestMapping("/aeropuertos")
public class AeropuertoController {

    private final AeropuertoService servicio;

    public AeropuertoController(AeropuertoService servicio) {
        this.servicio = servicio;
    }

   
}
