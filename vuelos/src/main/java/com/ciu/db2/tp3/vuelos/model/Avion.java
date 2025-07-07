package com.ciu.db2.tp3.vuelos.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@NamedEntityGraph(
	    name = "Avion.tipoavion",
	    attributeNodes = @NamedAttributeNode("tipoavion")
	)
@Table(name = "avion")
public class Avion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    private UUID numeroSerieAvion;

    @ManyToOne
    @JoinColumn(name = "nombretipoavion")
    private TipoDeAvion tipoavion;  

    @Column(name = "totalasientos")
    private int totalDeAsientos;

 
	public UUID getNumeroSerieAvion() {
		return numeroSerieAvion;
	}

	public void setNumeroSerieAvion(UUID numeroSerieAvion) {
		this.numeroSerieAvion = numeroSerieAvion;
	}

	public TipoDeAvion getTipoDeAvion() {
		return tipoavion;
	}

	public void setTipoDeAvion(TipoDeAvion tipoDeAvion) {
		this.tipoavion = tipoDeAvion;
	}

	public int getTotalDeAsientos() {
		return totalDeAsientos;
	}

	public void setTotalDeAsientos(int totalDeAsientos) {
		this.totalDeAsientos = totalDeAsientos;
	}

    
}

