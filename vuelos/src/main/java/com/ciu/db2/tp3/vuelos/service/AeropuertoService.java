package com.ciu.db2.tp3.vuelos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ciu.db2.tp3.vuelos.model.Aeropuerto;
import com.ciu.db2.tp3.vuelos.repository.AeropuertoRepository;


import org.springframework.transaction.annotation.Transactional;

@Service
public class AeropuertoService {

    private final AeropuertoRepository aeropuertoRepository;

    public AeropuertoService(AeropuertoRepository aeropuertoRepository) {
        this.aeropuertoRepository = aeropuertoRepository;
    }

    public List<Aeropuerto> findAll() {
        return aeropuertoRepository.findAll();
    }
    @Transactional
    @Cacheable(value = "aeropuertoStore", key = "#id", cacheManager = "ehCacheManager")
    public Optional<Aeropuerto> findById(UUID id) {
    	System.out.println("Accediendo al servicio EhCache.");
    	return aeropuertoRepository.findById(id);
    }


    @Transactional
    public Aeropuerto agregarAeropuerto(Aeropuerto aeropuerto) {
        Optional<Aeropuerto> existente = aeropuertoRepository
            .findByNombreAeropuertoAndCiudadAndPais(
                aeropuerto.getNombreAeropuerto(),
                aeropuerto.getCiudad(),
                aeropuerto.getPais()
            );

        if (existente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un aeropuerto con esa información.");
        }

        aeropuerto.setId(UUID.randomUUID());
        return aeropuertoRepository.save(aeropuerto);
    }


}

