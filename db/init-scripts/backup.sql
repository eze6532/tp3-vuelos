--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;
SET search_path TO public;
--
-- PostgreSQL database dump complete
--
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tipoAvion (
  nombreTipoAvion VARCHAR(50) PRIMARY KEY,
  cantMaxAsientos INT,
  fabricante VARCHAR(50)
);

CREATE TABLE aeropuerto (
  id UUID primary key, 
  nombreAeropuerto VARCHAR(100),
  ciudad VARCHAR(100),
  pais VARCHAR(100)
);

CREATE TABLE avion (
  id UUID PRIMARY KEY,
  nombreTipoAvion VARCHAR(50),
  totalAsientos INT,
  FOREIGN KEY (nombreTipoAvion) REFERENCES tipoAvion(nombreTipoAvion)
);

CREATE TABLE vuelos (
  numVuelo INT PRIMARY KEY,
  idAvion UUID,
  idAeropuertoSalida UUID,
  horaSalida TIME,
  idAeropuertoLlegada UUID,
  horaLlegada TIME,
  FOREIGN KEY (idAvion) REFERENCES avion(id),
  FOREIGN KEY (idAeropuertoSalida) REFERENCES aeropuerto(id),
  FOREIGN KEY (idAeropuertoLlegada) REFERENCES aeropuerto(id)
);

CREATE TABLE escalas (
  numVuelo INT,
  numEscala INT,
  idAeropuerto UUID,
  horaLlegada TIME,
  horaSalida TIME,
  PRIMARY KEY (numVuelo, numEscala),
  FOREIGN KEY (numVuelo) REFERENCES vuelos(numVuelo),
  FOREIGN KEY (idAeropuerto) REFERENCES aeropuerto(id)
);


CREATE TABLE avionPuedeAterrizar (
  nombreTipoAvion VARCHAR(50),
  idAeropuerto UUID,
  PRIMARY KEY (nombreTipoAvion, idAeropuerto),
  FOREIGN KEY (nombreTipoAvion) REFERENCES tipoAvion(nombreTipoAvion),
  FOREIGN KEY (idAeropuerto) REFERENCES aeropuerto(id)
);



CREATE OR REPLACE FUNCTION upsert_aeropuerto(
  p_id UUID,
  p_nombreAeropuerto VARCHAR,
  p_ciudad VARCHAR,
  p_pais VARCHAR
) RETURNS VOID AS $$
BEGIN
  INSERT INTO aeropuerto (id, nombreAeropuerto, ciudad, pais)
  VALUES (p_id, p_nombreAeropuerto, p_ciudad, p_pais)
  ON CONFLICT (id) DO UPDATE
  SET nombreAeropuerto = EXCLUDED.nombreAeropuerto,
      ciudad = EXCLUDED.ciudad,
      pais = EXCLUDED.pais;
END;
$$ LANGUAGE plpgsql;

SELECT upsert_aeropuerto(
  '123e4567-e89b-12d3-a456-426614174000',
  'Aeropuerto Ezeiza',
  'Buenos Aires',
  'Argentina'
);


-- Índices para vuelos
CREATE INDEX idx_vuelos_avion ON vuelos(idAvion);
CREATE INDEX idx_vuelos_salida ON vuelos(idAeropuertoSalida);
CREATE INDEX idx_vuelos_llegada ON vuelos(idAeropuertoLlegada);
CREATE INDEX idx_vuelos_hora ON vuelos(horaSalida);

-- Índices para aeropuerto
CREATE INDEX idx_aeropuerto_ciudad ON aeropuerto(ciudad);

-- Índices para escalas
CREATE INDEX idx_escalas_vuelo ON escalas(numVuelo);
CREATE INDEX idx_escalas_aeropuerto ON escalas(idAeropuerto);
CREATE INDEX idx_escalas_horas ON escalas(horaLlegada, horaSalida);

-- Índices para avión
CREATE INDEX idx_avion_tipo ON avion(nombreTipoAvion);

-- Índices para relación avión ↔ aeropuerto
CREATE INDEX idx_puede_aterrizar ON avionPuedeAterrizar(idAeropuerto);
-- Opcional si buscás por tipo de avión:
CREATE INDEX idx_puede_aterrizar_tipo ON avionPuedeAterrizar(nombreTipoAvion);

