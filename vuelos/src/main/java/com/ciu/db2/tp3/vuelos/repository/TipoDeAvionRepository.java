package com.ciu.db2.tp3.vuelos.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ciu.db2.tp3.vuelos.model.TipoDeAvion;

public interface TipoDeAvionRepository  extends JpaRepository<TipoDeAvion, String>{

}
