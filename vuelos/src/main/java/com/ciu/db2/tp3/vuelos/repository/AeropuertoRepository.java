package com.ciu.db2.tp3.vuelos.repository;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciu.db2.tp3.vuelos.model.Aeropuerto;

@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, UUID> {

}

