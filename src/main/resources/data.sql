-- ===========================
-- ESTADOS (tabla abstracta pero con registros base)
-- ===========================
INSERT INTO estado (id, nombre) VALUES 
(1, 'AutoDetectado'),
(2, 'BloqueadoEnRevision'),
(3, 'Confirmado'),
(4, 'Rechazado');

-- ===========================
-- ALCANCE SÍSMICO
-- ===========================
INSERT INTO alcance_sismico (id, nombre, descripcion) VALUES
(1, 'Local', 'Evento detectado en una zona reducida'),
(2, 'Regional', 'Evento que abarca una región amplia');

-- ===========================
-- CLASIFICACIÓN SÍSMICA
-- ===========================
INSERT INTO clasificacion_sismo (id, km_profundidad_desde, km_profundidad_hasta, nombre) VALUES
(1, 0, 70, 'Superficial'),
(2, 70, 300, 'Intermedio'),
(3, 300, 700, 'Profundo');

-- ===========================
-- ORIGEN DE GENERACIÓN
-- ===========================
INSERT INTO origen_generacion (id, nombre, descripcion) VALUES
(1, 'Sensor Automático', 'Detectado automáticamente por sensores'),
(2, 'Manual', 'Reportado manualmente por un analista');

-- ===========================
-- SISMÓGRAFOS
-- ===========================
INSERT INTO sismografo (id, identificador_sismografo, nombre, estacion_id) VALUES
(1, 'SISMO001', 'Sismógrafo Central', NULL),
(2, 'SISMO002', 'Sismógrafo Norte', NULL);

-- ===========================
-- SERIES TEMPORALES
-- ===========================
INSERT INTO serie_temporal (id, fecha_hora_registro, sismografo_id) VALUES
(1, '2025-11-11T08:00:00', 1),
(2, '2025-11-11T08:10:00', 2),
(3, '2025-11-11T08:20:00', 1),
(4, '2025-11-11T08:30:00', 2),
(5, '2025-11-11T08:40:00', 1);

-- ===========================
-- EVENTOS SÍSMICOS AUTODETECTADOS
-- ===========================
INSERT INTO evento_sismico (
    id,
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
(1, '2025-11-11T08:05:00', '2025-11-11T08:00:00', -31.42, -64.18, -31.45, -64.22, 3.8, 4, NULL, 1, 1, 1, 1, 1),
(2, '2025-11-11T08:15:00', '2025-11-11T08:10:00', -31.50, -64.25, -31.52, -64.27, 4.1, 4, NULL, 2, 1, 2, 1, 1),
(3, '2025-11-11T08:25:00', '2025-11-11T08:20:00', -31.40, -64.10, -31.42, -64.12, 5.0, 5, NULL, 3, 2, 1, 1, 1),
(4, '2025-11-11T08:35:00', '2025-11-11T08:30:00', -31.48, -64.21, -31.49, -64.23, 3.6, 3, NULL, 4, 1, 1, 1, 1),
(5, '2025-11-11T08:45:00', '2025-11-11T08:40:00', -31.46, -64.20, -31.47, -64.22, 4.3, 4, NULL, 5, 1, 2, 1, 1);
