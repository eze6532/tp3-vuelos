package com.ciu.db2.tp3.vuelos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciu.db2.tp3.vuelos.model.Avion;

public interface AvionRepository extends JpaRepository<Avion, UUID>{

}
