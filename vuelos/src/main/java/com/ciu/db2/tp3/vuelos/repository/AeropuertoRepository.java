package com.ciu.db2.tp3.vuelos.repository;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ciu.db2.tp3.vuelos.model.Aeropuerto;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, UUID> {

    @Modifying
    @Query(value = "SELECT upsert_aeropuerto(:id, :nombre, :ciudad, :pais)", nativeQuery = true)
    void upsertAeropuerto(@Param("id") UUID id,
                          @Param("nombre") String nombre,
                          @Param("ciudad") String ciudad,
                          @Param("pais") String pais);
}

