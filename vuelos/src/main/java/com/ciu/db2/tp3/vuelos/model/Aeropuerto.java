package com.ciu.db2.tp3.vuelos.model;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {

    @Id
    private UUID id;

    @Column(name = "nombreaeropuerto")
    private String nombreAeropuerto;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "pais")
    private String pais;
    
	public String getNombreAeropuerto() {
		return nombreAeropuerto;
	}

	public void setNombreAeropuerto(String nombreAeropuerto) {
		this.nombreAeropuerto = nombreAeropuerto;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
    
}

