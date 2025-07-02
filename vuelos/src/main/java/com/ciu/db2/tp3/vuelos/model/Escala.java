package com.ciu.db2.tp3.vuelos.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.UUID;
import com.ciu.db2.tp3.vuelos.model.Aeropuerto;

@Entity
@IdClass(EscalaId.class)
@Table(name = "escalas")
public class Escala {

    @Id
    @Column(name = "numvuelo")
    private UUID numVuelo;

    @Id
    @Column(name = "numescala")
    private int numEscala;

    @ManyToOne
    @JoinColumn(name = "idaeropuerto")
    private Aeropuerto aeropuerto;

    @Column(name = "horallegada")
    private LocalTime horaLlegada;

    @Column(name = "horasalida")
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
