SET search_path TO public;
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- tipoAvion
INSERT INTO tipoAvion (nombreTipoAvion, cantMaxAsientos, fabricante) VALUES
('JetType1', 263, 'Hernandez and Sons'),
('JetType2', 128, 'Henderson, Brown and James'),
('JetType3', 106, 'Rice-Maddox'),
('JetType4', 289, 'Frazier Inc'),
('JetType5', 170, 'Dyer, Potter and Mack'),
('JetType6', 162, 'Rodriguez-Graham'),
('JetType7', 157, 'Smith-Bowen'),
('JetType8', 135, 'Baker, Mason and White'),
('JetType9', 288, 'Harrell LLC'),
('JetType10', 126, 'Romero, Gonzalez and Brooks'),
('JetType11', 273, 'Ryan PLC'),
('JetType12', 289, 'George Group'),
('JetType13', 328, 'Rodriguez LLC'),
('JetType14', 239, 'Allen-Allen'),
('JetType15', 122, 'Arroyo, Miller and Tucker'),
('JetType16', 251, 'Spence PLC'),
('JetType17', 208, 'Anderson Group'),
('JetType18', 108, 'Martin, Rose and Obrien'),
('JetType19', 107, 'Hickman Ltd'),
('JetType20', 123, 'Harris, Collins and Carney'),
('JetType21', 155, 'Brooks, Lam and Hayes'),
('JetType22', 159, 'Walker LLC'),
('JetType23', 229, 'Chapman and Sons'),
('JetType24', 254, 'Robinson, Jones and Welch'),
('JetType25', 106, 'Jones Inc'),
('JetType26', 243, 'Jones-Young'),
('JetType27', 150, 'Washington, Ryan and Cummings'),
('JetType28', 283, 'Johnston, Sanchez and Kennedy'),
('JetType29', 266, 'Lee-Davis'),
('JetType30', 279, 'Gomez-Jenkins');

-- aeropuerto
INSERT INTO aeropuerto (id, nombreAeropuerto, ciudad, pais) VALUES
(gen_random_uuid(), 'North Judithbury International', 'Lake Deniseville', 'Bahamas'),
(gen_random_uuid(), 'East Jill International', 'Chandlerville', 'Egypt'),
(gen_random_uuid(), 'New Roberttown International', 'East Amanda', 'Burundi'),
(gen_random_uuid(),'East Jessetown International', 'Whitemouth', 'Egypt'),
(gen_random_uuid(),'Lake Debra International', 'South Lindseyside', 'Bolivia'),
(gen_random_uuid(),'Robinsonshire International', 'Lake Yvettetown', 'Bermuda'),
(gen_random_uuid(),'Lisatown International', 'East Richard', 'Liberia'),
(gen_random_uuid(),'Lake Roberto International', 'Port Richard', 'Bahamas'),
(gen_random_uuid(),'Ericmouth International', 'South Aaron', 'Iceland'),
(gen_random_uuid(),'North Noahstad International', 'Saramouth', 'France'),
(gen_random_uuid(),'Cassandraton International', 'Hortonside', 'Panama'),
(gen_random_uuid(),'Herrerafurt International', 'Mooreport', 'Cuba'),
(gen_random_uuid(),'New Kellystad International', 'New Jillton', 'San Marino'),
(gen_random_uuid(),'Lake Chad International', 'Brianshire', 'Lesotho'),
(gen_random_uuid(),'Port Keith International', 'North Susan', 'Belgium'),
(gen_random_uuid(),'Port Jesseville International', 'North Brooke', 'Peru'),
(gen_random_uuid(),'Ramirezstad International', 'South David', 'Tuvalu'),
(gen_random_uuid(),'West Michael International', 'New Brooke', 'Nicaragua'),
(gen_random_uuid(),'Jacquelineland International', 'South Dianeshire', 'Maldives'),
(gen_random_uuid(),'New Jessica International', 'Sarahborough', 'Paraguay'),
(gen_random_uuid(),'South Noah International', 'Johnfurt', 'Bulgaria'),
(gen_random_uuid(),'Lake Mark International', 'Stephenland', 'Algeria'),
(gen_random_uuid(),'East Lydiamouth International', 'Howellshire', 'Bolivia'),
(gen_random_uuid(),'Adamsborough International', 'New Jasonview', 'Bulgaria'),
(gen_random_uuid(),'Jasonfort International', 'Nicolebury', 'Heard Island and McDonald Islands'),
(gen_random_uuid(),'Wilkersonmouth International', 'Ericside', 'Romania'),
(gen_random_uuid(),'West Donald International', 'Cherylhaven', 'Algeria'),
(gen_random_uuid(),'Juliechester International', 'Sarahville', 'Wallis and Futuna'),
(gen_random_uuid(),'Coxberg International', 'West Darrell', 'Botswana'),
(gen_random_uuid(),'Daviston International', 'West Juan', 'Cote dIvoire');

-- avion
INSERT INTO avion (id, nombreTipoAvion, totalAsientos) VALUES
('11111111-1111-1111-1111-111111111111', 'JetType18', 207),
('11111111-1111-1111-1111-111111111112', 'JetType8', 214),
('11111111-1111-1111-1111-111111111113', 'JetType19', 171),
('11111111-1111-1111-1111-111111111114', 'JetType26', 322),
('11111111-1111-1111-1111-111111111115', 'JetType1', 294),
('11111111-1111-1111-1111-111111111116', 'JetType26', 140),
('11111111-1111-1111-1111-111111111117', 'JetType23', 208),
('11111111-1111-1111-1111-111111111118', 'JetType11', 171),
('11111111-1111-1111-1111-111111111119', 'JetType5', 155),
('11111111-1111-1111-1111-111111111110', 'JetType25', 186),
('11111111-1111-1111-1111-111111111121', 'JetType4', 123),
('11111111-1111-1111-1111-111111111123', 'JetType13', 124),
('11111111-1111-1111-1111-111111111124', 'JetType12', 316),
('11111111-1111-1111-1111-111111111125', 'JetType12', 254),
('11111111-1111-1111-1111-111111111126', 'JetType9', 306),
('11111111-1111-1111-1111-111111111127', 'JetType2', 286),
('11111111-1111-1111-1111-111111111128', 'JetType15', 237),
('11111111-1111-1111-1111-111111111129', 'JetType4', 349),
('11111111-1111-1111-1111-111111111130', 'JetType30', 196),
('11111111-1111-1111-1111-111111111131', 'JetType3', 241),
('11111111-1111-1111-1111-111111111132', 'JetType10', 312),
('11111111-1111-1111-1111-111111111133', 'JetType21', 258),
('11111111-1111-1111-1111-111111111134', 'JetType29', 320),
('11111111-1111-1111-1111-111111111135', 'JetType12', 247),
('11111111-1111-1111-1111-111111111136', 'JetType7', 280),
('11111111-1111-1111-1111-111111111137', 'JetType3', 111),
('11111111-1111-1111-1111-111111111138', 'JetType22', 158),
('11111111-1111-1111-1111-111111111139', 'JetType25', 174),
('11111111-1111-1111-1111-111111111140', 'JetType3', 318),
('11111111-1111-1111-1111-111111111141', 'JetType8', 321);

WITH vuelos_temp AS (
  SELECT *
  FROM (VALUES
    (1000, '11111111-1111-1111-1111-111111111111'::uuid, 'New Kellystad International', '08:20:35', 'Ericmouth International', '08:03:33'),
    (1001, '11111111-1111-1111-1111-111111111112'::uuid, 'South Noah International', '10:31:33', 'West Donald International', '20:00:41'),
    (1002, '11111111-1111-1111-1111-111111111113'::uuid, 'Robinsonshire International', '01:40:36', 'Herrerafurt International', '08:31:47'),
    (1003, '11111111-1111-1111-1111-111111111114'::uuid, 'Lisatown International', '00:14:48', 'Lake Mark International', '12:36:00'),
    (1004, '11111111-1111-1111-1111-111111111115'::uuid, 'East Lydiamouth International', '15:39:36', 'Daviston International', '14:43:19'),
    (1005, '11111111-1111-1111-1111-111111111116'::uuid, 'South Noah International', '02:10:44', 'New Roberttown International', '05:24:33'),
    (1006, '11111111-1111-1111-1111-111111111117'::uuid, 'South Noah International', '00:47:21', 'Robinsonshire International', '22:11:05'),
    (1007, '11111111-1111-1111-1111-111111111118'::uuid, 'Adamsborough International', '18:46:46', 'Lake Roberto International', '03:05:11'),
    (1008, '11111111-1111-1111-1111-111111111119'::uuid, 'Port Keith International', '14:13:31', 'New Kellystad International', '06:32:06'),
    (1009, '11111111-1111-1111-1111-111111111110'::uuid, 'Daviston International', '12:57:52', 'South Noah International', '12:55:54'),
    (1010, '11111111-1111-1111-1111-111111111121'::uuid, 'West Michael International', '22:24:14', 'Lake Roberto International', '03:24:15'),
    (1011, '11111111-1111-1111-1111-111111111123'::uuid, 'Cassandraton International', '09:27:43', 'West Donald International', '21:08:52'),
    (1012, '11111111-1111-1111-1111-111111111124'::uuid, 'Jasonfort International', '02:11:24', 'East Jill International', '11:01:50'),
    (1013, '11111111-1111-1111-1111-111111111125'::uuid, 'West Donald International', '05:11:00', 'East Jill International', '09:58:48'),
    (1014, '11111111-1111-1111-1111-111111111126'::uuid, 'Cassandraton International', '08:12:03', 'New Kellystad International', '15:22:12'),
    (1015, '11111111-1111-1111-1111-111111111127'::uuid, 'New Roberttown International', '04:42:24', 'Lisatown International', '09:15:32'),
    (1016, '11111111-1111-1111-1111-111111111128'::uuid, 'Jacquelineland International', '18:20:45', 'Coxberg International', '17:17:17'),
    (1017, '11111111-1111-1111-1111-111111111129'::uuid, 'Cassandraton International', '11:37:19', 'Lisatown International', '21:54:52'),
    (1018, '11111111-1111-1111-1111-111111111130'::uuid, 'Port Jesseville International', '08:29:28', 'New Kellystad International', '02:03:29'),
    (1019, '11111111-1111-1111-1111-111111111131'::uuid, 'Daviston International', '21:23:07', 'South Noah International', '09:45:47'),
    (1020, '11111111-1111-1111-1111-111111111132'::uuid, 'Lake Debra International', '16:12:49', 'Ericmouth International', '15:53:19'),
    (1021, '11111111-1111-1111-1111-111111111133'::uuid, 'Lake Roberto International', '19:16:03', 'Adamsborough International', '11:05:57'),
    (1022, '11111111-1111-1111-1111-111111111134'::uuid, 'West Michael International', '17:27:11', 'Ericmouth International', '14:13:07'),
    (1023, '11111111-1111-1111-1111-111111111135'::uuid, 'Jacquelineland International', '09:31:15', 'Lake Chad International', '11:32:06'),
    (1024, '11111111-1111-1111-1111-111111111136'::uuid, 'Jacquelineland International', '20:37:47', 'New Kellystad International', '02:17:07'),
    (1025, '11111111-1111-1111-1111-111111111137'::uuid, 'Lake Roberto International', '17:16:45', 'Lake Debra International', '22:46:57'),
    (1026, '11111111-1111-1111-1111-111111111138'::uuid, 'Port Jesseville International', '17:31:17', 'New Roberttown International', '21:27:58'),
    (1027, '11111111-1111-1111-1111-111111111139'::uuid, 'East Jill International', '23:31:39', 'Juliechester International', '13:33:19'),
    (1028, '11111111-1111-1111-1111-111111111140'::uuid, 'Lake Debra International', '15:00:37', 'South Noah International', '08:48:44'),
    (1029, '11111111-1111-1111-1111-111111111141'::uuid, 'Wilkersonmouth International', '10:39:26', 'Lake Mark International', '03:19:02')
  ) AS v(numVuelo, idAvion, nombreAeropuertoSalida, horaSalida, nombreAeropuertoLlegada, horaLlegada)
)
INSERT INTO vuelos (numVuelo, idAvion, idAeropuertoSalida, horaSalida, idAeropuertoLlegada, horaLlegada)
SELECT
  v.numVuelo,
  v.idAvion,
  aSalida.id,
  v.horaSalida::time,
  aLlegada.id,
  v.horaLlegada::time
FROM vuelos_temp v
JOIN aeropuerto aSalida ON aSalida.nombreAeropuerto = v.nombreAeropuertoSalida
JOIN aeropuerto aLlegada ON aLlegada.nombreAeropuerto = v.nombreAeropuertoLlegada;


-- escalas
WITH escalas_temp AS (
  SELECT DISTINCT ON (numVuelo, numEscala) *
  FROM (VALUES
    (1013, 1, 'New Jessica International', '00:04:42', '07:11:48'),
    (1002, 2, 'New Kellystad International', '20:10:21', '15:51:04'),
    (1012, 3, 'New Jessica International', '15:11:51', '01:38:37'),
    (1014, 1, 'Ramirezstad International', '00:48:09', '09:49:08'),
    (1008, 2, 'West Michael International', '12:20:51', '07:43:16'),
    (1027, 3, 'North Judithbury International', '04:28:05', '15:53:53'),
    (1021, 1, 'Adamsborough International', '15:10:05', '22:53:58'),
    (1003, 2, 'Lake Mark International', '06:48:21', '05:31:29'),
    (1028, 3, 'West Michael International', '11:48:21', '21:12:40'),
    (1024, 1, 'Ericmouth International', '07:11:27', '08:44:02'),
    (1024, 2, 'South Noah International', '17:33:07', '03:01:33'),
    (1010, 3, 'East Jessetown International', '12:07:33', '01:32:02'),
    (1009, 1, 'Lake Chad International', '14:52:48', '09:49:44'),
    (1005, 2, 'Port Keith International', '21:34:34', '19:22:25'),
    (1000, 3, 'Adamsborough International', '13:26:37', '10:04:03'),
    (1028, 1, 'Adamsborough International', '21:59:57', '19:04:43'),
    (1008, 2, 'Ramirezstad International', '04:23:09', '05:07:57'),
    (1024, 3, 'Robinsonshire International', '06:24:27', '22:12:56'),
    (1016, 1, 'Daviston International', '23:52:54', '17:11:49'),
    (1003, 2, 'Juliechester International', '11:05:28', '03:18:35'),
    (1020, 3, 'North Noahstad International', '16:32:44', '18:49:28'),
    (1026, 1, 'South Noah International', '02:45:46', '08:19:17'),
    (1016, 2, 'New Jessica International', '01:26:39', '12:20:38'),
    (1006, 3, 'Lake Debra International', '17:08:35', '18:35:24'),
    (1011, 1, 'Jasonfort International', '00:21:44', '20:01:55'),
    (1005, 2, 'West Michael International', '12:56:06', '07:51:09'),
    (1024, 3, 'Daviston International', '15:15:58', '04:51:14'),
    (1000, 2, 'New Jessica International', '20:36:54', '03:22:46'),
    (1010, 3, 'Port Jesseville International', '02:23:30', '02:03:24')
  ) AS e(numVuelo, numEscala, nombreAeropuerto, horaLlegada, horaSalida)
  ORDER BY numVuelo, numEscala
)
INSERT INTO escalas (numVuelo, numEscala, idAeropuerto, horaLlegada, horaSalida)
SELECT
  e.numVuelo,
  e.numEscala,
  a.id,
  e.horaLlegada::time,
  e.horaSalida::time
FROM escalas_temp e
JOIN aeropuerto a ON a.nombreAeropuerto = e.nombreAeropuerto;

-- avionPuedeAterrizar
WITH avionAterrizajes_temp AS (
  SELECT *
  FROM (VALUES
    ('JetType1', 'East Jessetown International'),
    ('JetType30', 'Herrerafurt International'),
    ('JetType29', 'West Donald International'),
    ('JetType26', 'North Noahstad International'),
    ('JetType8', 'East Jill International'),
    ('JetType8', 'Coxberg International'),
    ('JetType19', 'New Roberttown International'),
    ('JetType3', 'Adamsborough International'),
    ('JetType16', 'West Donald International'),
    ('JetType3', 'Jasonfort International'),
    ('JetType18', 'Jasonfort International'),
    ('JetType5', 'Lake Debra International'),
    ('JetType22', 'Port Jesseville International'),
    ('JetType18', 'Robinsonshire International'),
    ('JetType9', 'Ramirezstad International'),
    ('JetType28', 'New Jessica International'),
    ('JetType14', 'Lisatown International'),
    ('JetType30', 'West Michael International'),
    ('JetType25', 'Adamsborough International'),
    ('JetType23', 'Lisatown International'),
    ('JetType23', 'North Noahstad International'),
    ('JetType13', 'Lake Mark International'),
    ('JetType21', 'Herrerafurt International'),
    ('JetType15', 'Coxberg International'),
    ('JetType17', 'Port Keith International'),
    ('JetType4', 'Lake Roberto International'),
    ('JetType8', 'New Roberttown International'),
    ('JetType11', 'North Judithbury International'),
    ('JetType19', 'West Michael International'),
    ('JetType8', 'Jacquelineland International')
  ) AS v(nombreTipoAvion, nombreAeropuerto)
)
INSERT INTO avionPuedeAterrizar (nombreTipoAvion, idAeropuerto)
SELECT
  v.nombreTipoAvion,
  a.id
FROM avionAterrizajes_temp v
JOIN aeropuerto a ON a.nombreAeropuerto = v.nombreAeropuerto;
