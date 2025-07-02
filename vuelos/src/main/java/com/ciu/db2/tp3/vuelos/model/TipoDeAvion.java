package com.ciu.db2.tp3.vuelos.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "tipoavion")
public class TipoDeAvion {

    @Id
    @Column(name ="nombretipoavion")
    private String nombreTipoDeAvion;

    @Column(name ="cantmaxasientos")
    private int cantMaxDeAsientos;

    @Column(name ="fabricante")
    private String empresa;

    @OneToMany(mappedBy = "tipoavion", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Avion> aviones;


    public String getNombreTipoDeAvion() {
        return nombreTipoDeAvion;
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

	public void setNombreTipoDeAvion(String nombreTipoDeAvion) {
		this.nombreTipoDeAvion = nombreTipoDeAvion;
	}

    
}


