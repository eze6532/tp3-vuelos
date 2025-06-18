package com.ciu.db2.tp3.vuelos.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class TipoDeAvion {

    @Id
    private String nombreTipoDeAvion;

    private int cantMaxDeAsientos;

    private String empresa;

    @OneToMany(mappedBy = "tipoDeAvion")
    private List<Avion> aviones;

	public String getNombreTipoDeAvion() {
		return nombreTipoDeAvion;
	}

	public void setNombreTipoDeAvion(String nombreTipoDeAvion) {
		this.nombreTipoDeAvion = nombreTipoDeAvion;
	}

	public int getCantMaxDeAsientos() {
		return cantMaxDeAsientos;
	}

	public void setCantMaxDeAsientos(int cantMaxDeAsientos) {
		this.cantMaxDeAsientos = cantMaxDeAsientos;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public List<Avion> getAviones() {
		return aviones;
	}

	public void setAviones(List<Avion> aviones) {
		this.aviones = aviones;
	}
    
    
}

