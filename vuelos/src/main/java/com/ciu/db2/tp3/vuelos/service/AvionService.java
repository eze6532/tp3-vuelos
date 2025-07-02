package com.ciu.db2.tp3.vuelos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;

import com.ciu.db2.tp3.vuelos.model.Avion;
import com.ciu.db2.tp3.vuelos.repository.AvionRepository;


import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;


@Service
public class AvionService {

    private final AvionRepository repo;

    public AvionService(AvionRepository repo) {
        this.repo = repo;
    }


    @Cacheable(value = "avionCache", key = "#id.toString()", cacheManager = "redisCacheManager")
    public Optional<Avion> findById(UUID id) {
        return this.repo.findById(id);
    }

    @CachePut(value = "avionCache", key = "#avion.numeroSerieAvion.toString()", cacheManager = "redisCacheManager")
    public Avion add(Avion avion) {
        return this.repo.save(avion);
    }
   
    public List<Avion> findAll() {
        try {
            return this.repo.findAll();
        } catch (Exception e) {
        	
        	System.err.println("Error al buscar aviones: " + e);

           throw e;
        }
    }

}
