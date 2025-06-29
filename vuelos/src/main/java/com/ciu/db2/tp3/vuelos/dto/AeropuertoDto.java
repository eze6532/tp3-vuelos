package com.ciu.db2.tp3.vuelos.dto;

import java.util.UUID;


public class AeropuertoDto {

    private UUID id;
    private String nombreAeropuerto;
    private String ciudad;
    private String pais;


    public AeropuertoDto() {
    }

    public AeropuertoDto(UUID id, String nombreAeropuerto, String ciudad, String pais) {
        this.id = id;
        this.nombreAeropuerto = nombreAeropuerto;
        this.ciudad = ciudad;
        this.pais = pais;
    }
   

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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
    
    
    
    
  
}
