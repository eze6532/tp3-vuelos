package com.ciu.db2.tp3.vuelos.dto;


import java.util.UUID;

import com.ciu.db2.tp3.vuelos.model.Avion;
import com.ciu.db2.tp3.vuelos.model.TipoDeAvion;

public class AvionDto {

    private UUID numeroSerieAvion;
    private String nombreTipoDeAvion;
    private int totalDeAsientos;

    public AvionDto() {
    }

    public AvionDto(UUID numeroSerieAvion, String nombreTipoDeAvion, int totalDeAsientos) {
        this.numeroSerieAvion = numeroSerieAvion;
        this.nombreTipoDeAvion = nombreTipoDeAvion;
        this.totalDeAsientos = totalDeAsientos;
    }
    
    public UUID getNumeroSerieAvion() {
        return numeroSerieAvion;
    }

    public void setNumeroSerieAvion(UUID numeroSerieAvion) {
        this.numeroSerieAvion = numeroSerieAvion;
    }

    public String getNombreTipoDeAvion() {
        return nombreTipoDeAvion;
    }

    public void setNombreTipoDeAvion(String nombreTipoDeAvion) {
        this.nombreTipoDeAvion = nombreTipoDeAvion;
    }

    public int getTotalDeAsientos() {
        return totalDeAsientos;
    }

    public void setTotalDeAsientos(int totalDeAsientos) {
        this.totalDeAsientos = totalDeAsientos;
    }
}

