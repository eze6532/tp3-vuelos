package com.ciu.db2.tp3.vuelos.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @Column(name = "numvuelo")
    private UUID numVuelo;

    @ManyToOne
    @JoinColumn(name = "numserieavion")
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "idaeropuertosalida")
    private Aeropuerto aeropuertoSalida;

    @ManyToOne
    @JoinColumn(name = "idaeropuertollegada")
    private Aeropuerto aeropuertoLlegada;

    @Column(name = "horasalida")
    private LocalTime horaSalida;

    @Column(name = "horallegada")
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

