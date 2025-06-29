package com.ciu.db2.tp3.vuelos.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciu.db2.tp3.vuelos.dto.TipoDeAvionDto;
import com.ciu.db2.tp3.vuelos.model.TipoDeAvion;
import com.ciu.db2.tp3.vuelos.service.TipoDeAvionService;

@RestController
@RequestMapping("tipoDeAvion")
public class TipoDeAvionContriller {
	private final TipoDeAvionService service;
	
	public TipoDeAvionContriller(TipoDeAvionService service) {
		this.service= service;
	}
	
	@GetMapping("/tipoDeAvion")
	public List<TipoDeAvionDto> findAllTipoDeAvion() {
	    List<TipoDeAvion> tiposDeAvion = this.service.findAllTipoDeAvion();
	    List<TipoDeAvionDto> tiposDeAvionDto =tiposDeAvion.stream()
		                       .map(t->toDto(t))
		                       .collect(Collectors.toList());
	    return tiposDeAvionDto;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoDeAvionDto> findById(@PathVariable String id) {
	    Optional<TipoDeAvion> tipoDeAvionOp = this.service.findById(id);
	    
	    if (tipoDeAvionOp.isPresent()) {
	        TipoDeAvionDto tipoDeAvionDto = this.toDto(tipoDeAvionOp.get());
	        return ResponseEntity.ok(tipoDeAvionDto);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	
	public TipoDeAvionDto toDto(TipoDeAvion tipo) {
	    return new TipoDeAvionDto(
	        tipo.getNombreTipoDeAvion(),
	        tipo.getCantMaxDeAsientos(),
	        tipo.getEmpresa()
	    );
	}

}
