package com.ciu.db2.tp3.vuelos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciu.db2.tp3.vuelos.model.TipoDeAvion;
@Repository
public interface TipoDeAvionRepository  extends JpaRepository<TipoDeAvion, String>{

}
