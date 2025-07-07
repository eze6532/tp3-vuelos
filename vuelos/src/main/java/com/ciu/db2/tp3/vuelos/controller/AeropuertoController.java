package com.ciu.db2.tp3.vuelos.controller;



import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciu.db2.tp3.vuelos.dto.AeropuertoDto;
import com.ciu.db2.tp3.vuelos.model.Aeropuerto;
import com.ciu.db2.tp3.vuelos.service.AeropuertoService;



@RestController
@RequestMapping("/aeropuertos")
public class AeropuertoController {

    private final AeropuertoService service;


    public AeropuertoController(AeropuertoService aeropuertoService) {
        this.service = aeropuertoService;
    }
    
   /* 
    La consulta de Aeropuerto por PK es Cacheable por caché interna (Ehcache).
   */
    @GetMapping("/all")
    public List<AeropuertoDto> findAll(){
    	List<Aeropuerto> aeropuertos = this.service.findAll();
    	List<AeropuertoDto> aeropuertosDto = aeropuertos.stream()
    												.map(a->toDto(a))
    												.collect(Collectors.toList());
    	return aeropuertosDto;
    }
    @GetMapping("/{id}")
    public ResponseEntity<AeropuertoDto> findById(@PathVariable UUID id) {
        return ( this.service.findById(id)
                .map(this::toDto)
                .map(ResponseEntity::ok))
                .orElse(ResponseEntity.notFound().build());
    }
    
    /*
    El alta aeropouerto debe soportar concurrencia por manejada por base de datos (UPSERT).
    */
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Aeropuerto newAeropuerto) {
        try {
            Aeropuerto creado = this.service.agregarAeropuerto(newAeropuerto);
            return ResponseEntity.ok(this.toDto(creado));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error interno: " + e.getMessage());
        }
    }

    
   /*
    funciones auxiliares
   */
    public AeropuertoDto toDto(Aeropuerto aeropuerto) {
    	return new AeropuertoDto(
           aeropuerto.getId(),
           aeropuerto.getNombreAeropuerto(),
           aeropuerto.getCiudad(),
           aeropuerto.getPais()
       );
   }
   
   public Aeropuerto toEntity(AeropuertoDto dto) {
       Aeropuerto aeropuerto = new Aeropuerto();      
       aeropuerto.setNombreAeropuerto(dto.getNombreAeropuerto());
       aeropuerto.setCiudad(dto.getCiudad());
       aeropuerto.setPais(dto.getPais());
       return aeropuerto;
   }
}
