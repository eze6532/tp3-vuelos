-- Table 
CREATE TABLE TipoDeAvion (
    nombreTipoDeAvion VARCHAR(50) PRIMARY KEY,
    cantMaxDeAsientos INT,
    empresa VARCHAR(100)
);

CREATE TABLE Avion (
    numeroSerieAvion VARCHAR(50) PRIMARY KEY,
    nombreTipoDeAvion VARCHAR(50),
    totalDeAsiento INT,
    FOREIGN KEY (nombreTipoDeAvion) REFERENCES TipoDeAvion(nombreTipoDeAvion)
);


CREATE TABLE Aeropuerto (
    nombreAeropuerto VARCHAR(100) PRIMARY KEY,
    ciudad VARCHAR(50),
    pais VARCHAR(50)
);

CREATE TABLE PuedeAterrizar (
    nombreTipoDeAvion VARCHAR(50),
    nombreAeropuerto VARCHAR(100),
    FOREIGN KEY (nombreTipoDeAvion) REFERENCES TipoDeAvion(nombreTipoDeAvion),
    FOREIGN KEY (nombreAeropuerto) REFERENCES Aeropuerto(nombreAeropuerto)
);

CREATE TABLE Vuelo (
    numVuelo INT PRIMARY KEY,
    numeroSerieAvion VARCHAR(50),
    nombreAeropuertoSalida VARCHAR(100),
    nombreAeropuertoLlegada VARCHAR(100),
    horaSalida TIME,
    horaLlegada TIME,
    FOREIGN KEY (numeroSerieAvion) REFERENCES Avion(numeroSerieAvion),
    FOREIGN KEY (nombreAeropuertoSalida) REFERENCES Aeropuerto(nombreAeropuerto),
    FOREIGN KEY (nombreAeropuertoLlegada) REFERENCES Aeropuerto(nombreAeropuerto)  
);

CREATE TABLE Escala (
    numVuelo INT,
    numEscala INT,
    nombreAeropuerto VARCHAR(100),
    horaLlegada TIME,
    horaPartida TIME,
    PRIMARY KEY (numVuelo, numEscala),
    FOREIGN KEY (numVuelo) REFERENCES Vuelo(numVuelo),
    FOREIGN KEY (nombreAeropuerto) REFERENCES Aeropuerto(nombreAeropuerto)
);
--tablas
select*from Avion;
select*from TipoDeAvion;
select*from Aeropuerto;
select*from PuedeAterrizar;
select*from Escala;
select*from Vuelo;
-- 9. Ningún plan de las consultas debe realizar un Seq Scan.
-- Para evitar Seq Scan al buscar por ciudad
CREATE INDEX idx_aeropuerto_ciudad ON Aeropuerto(ciudad);

-- Para evitar Seq Scan al buscar por nombre (para los JOINs)
CREATE INDEX idx_aeropuerto_nombre ON Aeropuerto(nombreAeropuerto);

-- Para evitar Seq Scan en Vuelo (por claves foráneas y horaSalida)
CREATE INDEX idx_vuelo_salida ON Vuelo(nombreAeropuertoSalida);
CREATE INDEX idx_vuelo_llegada ON Vuelo(nombreAeropuertoLlegada);
CREATE INDEX idx_vuelo_horaSalida ON Vuelo(horaSalida);

-- Para evitar Seq Scan en Escala (cuando se agrupa por numVuelo)
CREATE INDEX idx_escala_vuelo ON Escala(numVuelo);

-- para consultar el seq scan
-- EXPLAIN ANALYZE

--Peticiones
 -- 1.
-- <numeroSerieAvion, nombreTipoAvion> de los aviones 
-- que no están programados para ningún vuelo.
SELECT  a.numeroSerieAvion,
        a.nombreTipoDeAvion
        FROM Avion a  LEFT JOIN Vuelo v 
            ON a.numeroSerieAvion = v.numeroSerieAvion
            WHERE v.numeroSerieAvion IS NULL;
 -- 2. 
-- Nombre de las ciudades que tienen mas salidas que 
-- llegadas de aviones , pero solo de los vuelos directos. 

-- tabas que usa: Aeropuerto, Vuelo
select a.ciudad
	from Aeropuerto a join Vuelo v
		on a.nombreaeropuerto = v.nombreaeropuertosalida 
		where v.nombreaeropuertosalida > v.nombreaeropuertollegada;
		
 -- 3.
-- 	<numVuelo, cantTramos> de los vuelos de no mas de dos escalas desde la ciudad de 
-- Buenos Aires hasta la ciudad de Caracas ordenados por hora de salida.	

-- tabas que usa: Escala es cantTramos, Vuelo y Aeropuerto
EXPLAIN ANALYZE
select  
	    v.numVuelo,
	    COUNT(e.numEscala) AS cantTramos
		from  Vuelo v JOIN Aeropuerto aSalida ON 
		v.nombreAeropuertoSalida = aSalida.nombreAeropuerto
	    JOIN Aeropuerto aLlegada ON v.nombreAeropuertoLlegada = aLlegada.nombreAeropuerto
	    LEFT JOIN Escala e ON v.numVuelo = e.numVuelo
			WHERE 
			    aSalida.ciudad = 'Buenos Aires'
			AND aLlegada.ciudad = 'Caracas'
			GROUP BY 
			    v.numVuelo, v.horaSalida
			HAVING 
			    COUNT(e.numEscala) <= 2
			ORDER BY 
			    v.horaSalida;

-- 4.
SELECT DISTINCT v.numVuelo
FROM Vuelo v
LEFT JOIN Escala e ON v.numVuelo = e.numVuelo
JOIN Aeropuerto sa ON v.nombreAeropuertoSalida = sa.nombreAeropuerto
WHERE sa.ciudad = 'Buenos Aires'
  AND (
    v.nombreAeropuertoLlegada = 'Mariscal Sucre Intl'
    OR EXISTS (
      SELECT 1 FROM Escala e2
      WHERE e2.numVuelo = v.numVuelo
        AND e2.nombreAeropuerto = 'Mariscal Sucre Intl'
    )
  )
ORDER BY v.numVuelo;

-- 5.
SELECT t.nombreTipoDeAvion, COUNT(a.numeroSerieAvion) AS cantidadDeAviones
FROM Avion a
JOIN TipoDeAvion t ON a.nombreTipoDeAvion = t.nombreTipoDeAvion
GROUP BY t.nombreTipoDeAvion
HAVING COUNT(a.numeroSerieAvion) > 40;

-- 6.
SELECT DISTINCT e.numVuelo
FROM Escala e
JOIN Vuelo v ON e.numVuelo = v.numVuelo
WHERE v.horaSalida < '14:40:00'
  AND v.horaLlegada > '14:40:00'
  AND EXISTS (
    SELECT 1 FROM Escala e2
    WHERE e2.numVuelo = e.numVuelo
    LIMIT 1
  );

-- 7.
SELECT v.numVuelo, v.numeroSerieAvion, a.totalDeAsiento, t.cantMaxDeAsientos
FROM Vuelo v
JOIN Avion a ON v.numeroSerieAvion = a.numeroSerieAvion
JOIN TipoDeAvion t ON a.nombreTipoDeAvion = t.nombreTipoDeAvion
WHERE a.totalDeAsiento > t.cantMaxDeAsientos;

-- 8.
SELECT a.numeroSerieAvion
FROM Avion a
JOIN PuedeAterrizar pa ON a.nombreTipoDeAvion = pa.nombreTipoDeAvion
JOIN Aeropuerto ap ON pa.nombreAeropuerto = ap.nombreAeropuerto
WHERE ap.ciudad = 'Buenos Aires';



 
--init
-- TipoDeAvion
INSERT INTO TipoDeAvion (nombreTipoDeAvion, cantMaxDeAsientos, empresa) VALUES
('Boeing 737', 180, 'Boeing'),
('Airbus A320', 170, 'Airbus'),
('Embraer E190', 100, 'Embraer'),
('Boeing 787', 240, 'Boeing'),
('Bombardier CRJ200', 50, 'Bombardier');


 -- Aviones
INSERT INTO Avion (numeroSerieAvion, nombreTipoDeAvion, totalDeAsiento) VALUES
('AV001', 'Boeing 737', 180), ('AV002', 'Airbus A320', 170),
('AV003', 'Embraer E190', 100), ('AV004', 'Boeing 787', 240),
('AV005', 'Bombardier CRJ200', 50), ('AV006', 'Boeing 737', 180),
('AV007', 'Airbus A320', 170), ('AV008', 'Embraer E190', 100),
('AV009', 'Boeing 787', 240), ('AV010', 'Bombardier CRJ200', 50),
('AV011', 'Boeing 737', 180), ('AV012', 'Airbus A320', 170),
('AV013', 'Embraer E190', 100), ('AV014', 'Boeing 787', 240),
('AV015', 'Bombardier CRJ200', 50), ('AV016', 'Boeing 737', 180),
('AV017', 'Airbus A320', 170), ('AV018', 'Embraer E190', 100),
('AV019', 'Boeing 787', 240), ('AV020', 'Bombardier CRJ200', 50),
('AV021', 'Boeing 737', 180), ('AV022', 'Airbus A320', 170),
('AV023', 'Embraer E190', 100), ('AV024', 'Boeing 787', 240),
('AV025', 'Bombardier CRJ200', 50), ('AV026', 'Boeing 737', 180),
('AV027', 'Airbus A320', 170), ('AV028', 'Embraer E190', 100),
('AV029', 'Boeing 787', 240), ('AV030', 'Bombardier CRJ200', 50),
('AV031', 'Boeing 737', 180), ('AV032', 'Airbus A320', 170),
('AV033', 'Embraer E190', 100), ('AV034', 'Boeing 787', 240),
('AV035', 'Bombardier CRJ200', 50), ('AV036', 'Boeing 737', 180),
('AV037', 'Airbus A320', 170), ('AV038', 'Embraer E190', 100),
('AV039', 'Boeing 787', 240), ('AV040', 'Bombardier CRJ200', 50),
('AV041', 'Boeing 737', 180), ('AV042', 'Airbus A320', 170),
('AV043', 'Embraer E190', 100), ('AV044', 'Boeing 787', 240),
('AV045', 'Bombardier CRJ200', 50), ('AV046', 'Boeing 737', 180),
('AV047', 'Airbus A320', 170), ('AV048', 'Embraer E190', 100),
('AV049', 'Boeing 787', 240), ('AV050', 'Bombardier CRJ200', 50),
('AV051', 'Boeing 737', 180),
('AV052', 'Airbus A320', 170),
('AV053', 'Embraer E190', 100),
('AV054', 'Boeing 787', 240),
('AV055', 'Bombardier CRJ200', 50),
('AV056', 'Boeing 737', 180),
('AV057', 'Airbus A320', 170),
('AV058', 'Embraer E190', 100),
('AV059', 'Boeing 787', 240),
('AV060', 'Bombardier CRJ200', 50);


--Aeropuerto
INSERT INTO Aeropuerto (nombreAeropuerto, ciudad, pais) VALUES
('Ezeiza', 'Buenos Aires', 'Argentina'),
('Aeroparque', 'Buenos Aires', 'Argentina'),
('El Plumerillo', 'Mendoza', 'Argentina'),
('Pajas Blancas', 'Córdoba', 'Argentina'),
('Bariloche Intl', 'Bariloche', 'Argentina'),
('Salta Intl', 'Salta', 'Argentina'),
('Ushuaia Intl', 'Ushuaia', 'Argentina'),
('Mar del Plata', 'Mar del Plata', 'Argentina'),
('Posadas Intl', 'Posadas', 'Argentina'),
('Iguazú Intl', 'Puerto Iguazú', 'Argentina')
('Mariscal Sucre Intl', 'Quito', 'Ecuador');

-- PuedeAterrizar
INSERT INTO PuedeAterrizar (nombreTipoDeAvion, nombreAeropuerto) VALUES
('Boeing 737', 'Ezeiza'), ('Boeing 737', 'Aeroparque'),
('Boeing 737', 'Pajas Blancas'), ('Boeing 737', 'Salta Intl'),
('Airbus A320', 'Ezeiza'), ('Airbus A320', 'Bariloche Intl'),
('Airbus A320', 'Ushuaia Intl'), ('Embraer E190', 'Pajas Blancas'),
('Embraer E190', 'Iguazú Intl'), ('Boeing 787', 'Ezeiza'),
('Boeing 787', 'El Plumerillo'), ('Bombardier CRJ200', 'Posadas Intl'),
('Bombardier CRJ200', 'Mar del Plata');

-- Vuelo
INSERT INTO Vuelo (numVuelo, numeroSerieAvion, nombreAeropuertoSalida, nombreAeropuertoLlegada, horaSalida, horaLlegada) VALUES
(1, 'AV001', 'Ezeiza', 'Bariloche Intl', '08:00:00', '10:00:00'),
(2, 'AV002', 'Aeroparque', 'Salta Intl', '09:00:00', '11:00:00'),
(3, 'AV003', 'Ezeiza', 'Pajas Blancas', '07:00:00', '08:30:00'),
(4, 'AV004', 'El Plumerillo', 'Ushuaia Intl', '06:00:00', '09:30:00'),
(5, 'AV005', 'Salta Intl', 'Ezeiza', '10:00:00', '12:00:00'),
(100, 'AV051', 'Ezeiza', 'Mariscal Sucre Intl', '05:00:00', '10:00:00'),
(101, 'AV052', 'Aeroparque', 'Mariscal Sucre Intl', '08:00:00', '12:00:00'),
(102, 'AV053', 'Ezeiza', 'Mariscal Sucre Intl', '14:00:00', '18:00:00'),
(103, 'AV054', 'Ezeiza', 'Mariscal Sucre Intl', '13:00:00', '17:00:00');

-- Escala
INSERT INTO Escala (numVuelo, numEscala, nombreAeropuerto, horaLlegada, horaPartida) VALUES
(1, 1, 'Pajas Blancas', '09:00:00', '09:30:00'),
(1, 2, 'El Plumerillo', '09:45:00', '10:15:00'),
(2, 1, 'Posadas Intl', '10:00:00', '10:30:00'),
(2, 2, 'Salta Intl', '11:00:00', '11:30:00'),
(3, 1, 'Iguazú Intl', '07:45:00', '08:15:00'),
(3, 2, 'Pajas Blancas', '08:30:00', '09:00:00'),
(101, 1, 'Bariloche Intl', '10:00:00', '10:30:00'),
(101, 2, 'Salta Intl', '11:30:00', '12:00:00'),
(102, 1, 'El Plumerillo', '15:30:00', '16:00:00'),
(102, 2, 'Pajas Blancas', '16:45:00', '17:15:00');
