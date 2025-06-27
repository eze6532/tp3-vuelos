package com.ciu.db2.tp3.vuelos.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Avion {

    @Id
    private UUID numeroSerieAvion;

    @ManyToOne
    @JoinColumn(name = "nombreTipoDeAvion")
    private TipoDeAvion tipoDeAvion;

    private int totalDeAsientos;

	public UUID getNumeroSerieAvion() {
		return numeroSerieAvion;
	}

	public void setNumeroSerieAvion(UUID numeroSerieAvion) {
		this.numeroSerieAvion = numeroSerieAvion;
	}

	public TipoDeAvion getTipoDeAvion() {
		return tipoDeAvion;
	}

	public void setTipoDeAvion(TipoDeAvion tipoDeAvion) {
		this.tipoDeAvion = tipoDeAvion;
	}

	public int getTotalDeAsientos() {
		return totalDeAsientos;
	}

	public void setTotalDeAsientos(int totalDeAsientos) {
		this.totalDeAsientos = totalDeAsientos;
	}

    
}

