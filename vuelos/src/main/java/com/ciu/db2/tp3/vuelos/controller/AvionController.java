package com.ciu.db2.tp3.vuelos.controller;


import java.util.List;
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
    public ResponseEntity<List<AvionDto>> findAll() {
        List<AvionDto> avionesDto = avionService.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(avionesDto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AvionDto> findById(@PathVariable UUID id) {
        return avionService.findById(id)
                .map(avion -> ResponseEntity.ok(toDto(avion)))
                .orElse(ResponseEntity.notFound().build());
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


    private AvionDto toDto(Avion avion) {
        return new AvionDto(
                avion.getNumeroSerieAvion(),
                avion.getTipoDeAvion() != null ? avion.getTipoDeAvion().getNombreTipoDeAvion() : null,
                avion.getTotalDeAsientos()
        );
    }
}

