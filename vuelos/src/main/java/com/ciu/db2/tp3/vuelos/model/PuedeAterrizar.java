package com.ciu.db2.tp3.vuelos.model;

import jakarta.persistence.*;

@Entity
@IdClass(PuedeAterrizarId.class)
public class PuedeAterrizar {

    @Id
    private String nombreTipoDeAvion;

    @Id
    private String nombreAeropuerto;

	public String getNombreTipoDeAvion() {
		return nombreTipoDeAvion;
	}

	public void setNombreTipoDeAvion(String nombreTipoDeAvion) {
		this.nombreTipoDeAvion = nombreTipoDeAvion;
	}

	public String getNombreAeropuerto() {
		return nombreAeropuerto;
	}

	public void setNombreAeropuerto(String nombreAeropuerto) {
		this.nombreAeropuerto = nombreAeropuerto;
	}

    
}
