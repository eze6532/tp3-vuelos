package com.ciu.db2.tp3.vuelos.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.UUID;

@Entity
public class Vuelo {

    @Id
    private UUID numVuelo;

    @ManyToOne
    @JoinColumn(name = "numeroSerieAvion")
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "nombreAeropuertoSalida")
    private Aeropuerto aeropuertoSalida;

    @ManyToOne
    @JoinColumn(name = "nombreAeropuertoLlegada")
    private Aeropuerto aeropuertoLlegada;

    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    
	public UUID getNumVuelo() {
		return numVuelo;
	}
	public void setNumVuelo(UUID numVuelo) {
		this.numVuelo = numVuelo;
	}
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	public Aeropuerto getAeropuertoSalida() {
		return aeropuertoSalida;
	}
	public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
		this.aeropuertoSalida = aeropuertoSalida;
	}
	public Aeropuerto getAeropuertoLlegada() {
		return aeropuertoLlegada;
	}
	public void setAeropuertoLlegada(Aeropuerto aeropuertoLlegada) {
		this.aeropuertoLlegada = aeropuertoLlegada;
	}
	public LocalTime getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}
	public LocalTime getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(LocalTime horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

    
}

