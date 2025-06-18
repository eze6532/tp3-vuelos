package com.ciu.db2.tp3.vuelos.model;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class PuedeAterrizarId implements Serializable {
    private String nombreTipoDeAvion;
    private String nombreAeropuerto;
	@Override
	public int hashCode() {
		return Objects.hash(nombreAeropuerto, nombreTipoDeAvion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PuedeAterrizarId other = (PuedeAterrizarId) obj;
		return Objects.equals(nombreAeropuerto, other.nombreAeropuerto)
				&& Objects.equals(nombreTipoDeAvion, other.nombreTipoDeAvion);
	}
    
}


