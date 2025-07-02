package com.ciu.db2.tp3.vuelos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@IdClass(PuedeAterrizarId.class)
@Table(name = "avionpuedeaterrizar")
public class PuedeAterrizar {

    @Id
    @Column(name = "nombretipoavion")
    private String nombreTipoDeAvion;

    @Id
    @ManyToOne
    @JoinColumn(name = "idaeropuerto")
    private Aeropuerto aeropuerto;
    
	public String getNombreTipoDeAvion() {
		return nombreTipoDeAvion;
	}

	public void setNombreTipoDeAvion(String nombreTipoDeAvion) {
		this.nombreTipoDeAvion = nombreTipoDeAvion;
	}

	public Aeropuerto  getNombreAeropuerto() {
		return aeropuerto;
	}

	public void setNombreAeropuerto(Aeropuerto  aeropuerto) {
		this.aeropuerto = aeropuerto;
	}

    
}
