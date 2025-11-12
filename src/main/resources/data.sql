-- ===========================
-- ESTADOS
-- ===========================
INSERT INTO estado (nombre, tipo_estado) VALUES 
('AutoDetectado', 'AutoDetectado');


-- ===========================
-- ALCANCE SÍSMICO
-- ===========================
INSERT INTO alcance_sismico (nombre, descripcion) VALUES
('Local', 'Evento detectado en una zona reducida'),
('Regional', 'Evento que abarca una región amplia');
('Global', 'Evento que abarca una rel mundo');

-- ===========================
-- CLASIFICACIÓN SÍSMICA
-- ===========================
INSERT INTO clasificacion_sismo (km_profundidad_desde, km_profundidad_hasta, nombre) VALUES
(0, 70, 'Superficial'),
(70, 300, 'Intermedio'),
(300, 700, 'Profundo');

-- ===========================
-- ORIGEN DE GENERACIÓN
-- ===========================
INSERT INTO origen_generacion (nombre, descripcion) VALUES
('Tectonico', 'Provocado por placas'),
('Volcanico', 'Provocado por volcan');
('Artifical', 'Provocado por ser humano');

-- ===========================
-- SISMÓGRAFOS
-- ===========================
INSERT INTO sismografo (identificador_sismografo, nombre, estacion_id) VALUES
('SISMO001', 'Sismógrafo Central', NULL),
('SISMO002', 'Sismógrafo Norte', NULL);

-- ===========================
-- SERIES TEMPORALES
-- ===========================
INSERT INTO serie_temporal (fecha_hora_registro, sismografo_id) VALUES
('2025-11-11T08:00:00', 1),
('2025-11-11T08:10:00', 2),
('2025-11-11T08:20:00', 1),
('2025-11-11T08:30:00', 2),
('2025-11-11T08:40:00', 1);

-- ===========================
-- EVENTOS SÍSMICOS AUTODETECTADOS
-- ===========================
INSERT INTO evento_sismico (
    fecha_hora_fin,
    fecha_hora_ocurrencia,
    latitud_epicentro,
    longitud_epicentro,
    latitud_hipocentro,
    longitud_hipocentro,
    valor_magnitud,
    magnitud,
    fecha_hora_revision,
    serie_temporal,
    clasificacion_sismo,
    alcance_sismico,
    origen_generacion,
    estado_actual
) VALUES
('2025-11-11T08:05:00', '2025-11-11T08:00:00', -31.42, -64.18, -31.45, -64.22, 3.8, 4, NULL, 1, 1, 1, 1, 1),
('2025-11-11T08:15:00', '2025-11-11T08:10:00', -31.50, -64.25, -31.52, -64.27, 4.1, 4, NULL, 2, 1, 2, 1, 1),
('2025-11-11T08:25:00', '2025-11-11T08:20:00', -31.40, -64.10, -31.42, -64.12, 5.0, 5, NULL, 3, 2, 1, 1, 1),
('2025-11-11T08:35:00', '2025-11-11T08:30:00', -31.48, -64.21, -31.49, -64.23, 3.6, 3, NULL, 4, 1, 1, 1, 1),
('2025-11-11T08:45:00', '2025-11-11T08:40:00', -31.46, -64.20, -31.47, -64.22, 4.3, 4, NULL, 5, 1, 2, 1, 1);

-- ===========================
-- CAMBIO DE ESTADO
-- ===========================
INSERT INTO cambio_estado (fecha_hora_inicio, fecha_hora_fin, estado, evento_sismico)
VALUES 
('2025-11-11T08:00:00', '2025-11-11T08:02:00', 1, 1),
('2025-11-11T08:02:00', '2025-11-11T08:04:00', 1, 1),
('2025-11-11T08:04:00', NULL, 1, 1);


-- Insertamos un Empleado
INSERT INTO empleado (apellido, nombre, mail, telefono) 
VALUES ('González', 'Juan', 'juan.gonzalez@mail.com', '123456789');


-- Insertamos un Usuario asociado al Empleado (empleado_id = 1)
INSERT INTO usuario (nombre_usuario, empleado_id) 
VALUES ('juangonz', 1);


-- Insertamos una Sesion con fechaHoraFin NULL (sesión activa)
INSERT INTO sesion (fecha_hora_inicio, fecha_hora_fin, usuario_id) 
VALUES ('2025-11-12 08:00:00', NULL, 1);
