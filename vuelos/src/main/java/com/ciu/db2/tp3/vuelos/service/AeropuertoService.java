package com.ciu.db2.tp3.vuelos.service;

import org.springframework.stereotype.Service;

import com.ciu.db2.tp3.vuelos.repository.AeropuertoRepository;

@Service
public class AeropuertoService {

    private final AeropuertoRepository aeropuertoRepository;

    public AeropuertoService(AeropuertoRepository aeropuertoRepository) {
        this.aeropuertoRepository = aeropuertoRepository;
    }

    
    
}
