DROP TABLE reservas;
CREATE TABLE reservas(
id SERIAL,
clase TEXT,
profesor TEXT,
lugar TEXT,
plazas_disponibles INTEGER,
fecha_hora TEXT,
usuarios_inscritos TEXT,
PRIMARY KEY (id));

