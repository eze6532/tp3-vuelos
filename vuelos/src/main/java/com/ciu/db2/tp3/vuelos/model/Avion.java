package com.ciu.db2.tp3.vuelos.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Avion {

    @Id
    private UUID numeroSerieAvion;

    @ManyToOne
    @JoinColumn(name = "nombreTipoDeAvion")
    private TipoDeAvion tipoDeAvion;

    private int totalDeAsientos;

    
}

