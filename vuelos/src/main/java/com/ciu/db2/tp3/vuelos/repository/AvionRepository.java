package com.ciu.db2.tp3.vuelos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciu.db2.tp3.vuelos.model.Avion;
@Repository
public interface AvionRepository extends JpaRepository<Avion, UUID>{

}
