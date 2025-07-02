package com.ciu.db2.tp3.vuelos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ciu.db2.tp3.vuelos.model.TipoDeAvion;
import com.ciu.db2.tp3.vuelos.repository.TipoDeAvionRepository;
@Service
public class TipoDeAvionService {
	private final TipoDeAvionRepository repo;
	
	public TipoDeAvionService(TipoDeAvionRepository repo) {
		this.repo = repo;
		
	}

	public List<TipoDeAvion> findAllTipoDeAvion() {
	    return this.repo.findAll();
	}

	public Optional<TipoDeAvion> findById(String id) {
		return this.repo.findById(id);
	}


}
