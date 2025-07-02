package com.ciu.db2.tp3.vuelos.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("serial")
public class PuedeAterrizarId implements Serializable {

    private String nombreTipoDeAvion;
    private UUID aeropuerto; 

    public PuedeAterrizarId() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreTipoDeAvion, aeropuerto);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        PuedeAterrizarId other = (PuedeAterrizarId) obj;
        return Objects.equals(nombreTipoDeAvion, other.nombreTipoDeAvion)
                && Objects.equals(aeropuerto, other.aeropuerto);
    }
}



