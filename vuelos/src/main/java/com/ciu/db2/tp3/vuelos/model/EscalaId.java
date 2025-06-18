package com.ciu.db2.tp3.vuelos.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("serial")
public class EscalaId implements Serializable {
    private UUID numVuelo;
    private int numEscala;
    
	@Override
	public int hashCode() {
		return Objects.hash(numEscala, numVuelo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EscalaId other = (EscalaId) obj;
		return numEscala == other.numEscala && Objects.equals(numVuelo, other.numVuelo);
	}

   
}
