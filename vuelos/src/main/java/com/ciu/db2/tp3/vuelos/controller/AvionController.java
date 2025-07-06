package com.ciu.db2.tp3.vuelos.controller;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciu.db2.tp3.vuelos.dto.AvionDto;
import com.ciu.db2.tp3.vuelos.model.Avion;
import com.ciu.db2.tp3.vuelos.model.TipoDeAvion;
import com.ciu.db2.tp3.vuelos.service.AvionService;
import com.ciu.db2.tp3.vuelos.service.TipoDeAvionService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/avion")
public class AvionController {

    private final AvionService avionService;
    private final TipoDeAvionService tipoDeAvionService;

    public AvionController(AvionService avionService, TipoDeAvionService tipoDeAvionService) {
        this.avionService = avionService;
        this.tipoDeAvionService = tipoDeAvionService;
    }


    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody AvionDto avionDto) {
        try {
            Avion avion = toEntity(avionDto);
            if (avion.getNumeroSerieAvion() == null) {
                avion.setNumeroSerieAvion(UUID.randomUUID());
            }
            avionService.add(avion);
            return ResponseEntity.status(HttpStatus.CREATED).body("Avión creado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        try {
            List<AvionDto> avionesDto = avionService.findAll().stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(avionesDto);
        } catch (Exception e) {
            
            e.printStackTrace();
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener la lista de aviones: " + e.getMessage());
        }
    }


   /*
    La consulta de Avión por PK es Cacheable por caché externa (Redis).
    */
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        try {
            Optional<Avion> avionOpt = avionService.findById(id);
            if (avionOpt.isPresent()) {
                AvionDto dto = this.toDto(avionOpt.get());
                return ResponseEntity.ok(dto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Avion con ID " + id + " no encontrado");
            }
        } catch (Exception e) {
            System.err.println("Error al buscar avión con ID " + id + ": " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al buscar avión: " + e.getMessage());
        }
    }

    private AvionDto toDto(Avion avion) {
        return new AvionDto(
                avion.getNumeroSerieAvion(),
                avion.getTipoDeAvion() != null ? avion.getTipoDeAvion().getNombreTipoDeAvion() : null,
                avion.getTotalDeAsientos()
        );
    }
    
    private Avion toEntity(AvionDto dto) {
        Avion avion = new Avion();
        avion.setNumeroSerieAvion(dto.getNumeroSerieAvion());

        TipoDeAvion tipo = tipoDeAvionService.findById(dto.getNombreTipoDeAvion())
                .orElseThrow(() -> new RuntimeException("TipoDeAvion no encontrado: " + dto.getNombreTipoDeAvion()));
        avion.setTipoDeAvion(tipo);

        avion.setTotalDeAsientos(dto.getTotalDeAsientos());
        return avion;
    }

}

