package com.ciu.db2.tp3.vuelos.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@IdClass(EscalaId.class)
public class Escala {

    @Id
    private UUID numVuelo;

    @Id
    private int numEscala;

    @ManyToOne
    @JoinColumn(name = "nombreAeropuerto")
    private Aeropuerto aeropuerto;

    private LocalTime horaLlegada;
    private LocalTime horaPartida;
    
	public UUID getNumVuelo() {
		return numVuelo;
	}
	public void setNumVuelo(UUID numVuelo) {
		this.numVuelo = numVuelo;
	}
	public int getNumEscala() {
		return numEscala;
	}
	public void setNumEscala(int numEscala) {
		this.numEscala = numEscala;
	}
	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}
	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}
	public LocalTime getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(LocalTime horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	public LocalTime getHoraPartida() {
		return horaPartida;
	}
	public void setHoraPartida(LocalTime horaPartida) {
		this.horaPartida = horaPartida;
	}

    
}
