
-- Tabla actividad economica
create table actividad_economica(
	id_actividad_economica serial not null primary key,
	descripcion varchar(100),
	estado boolean
);
-- Tabla division politica
create table division_politica(
	id_division_politica serial not null primary key,
	descripcion varchar(45),
	estado boolean,
	id_pais int4 NOT NULL
);
alter table division_politica add constraint Fk_division_politica_pais foreign key (id_pais) references pais (id);

-- Tabla ciudad
create table ciudad(
	id_ciudad serial not null primary key,
	descripcion varchar(45),
	estado boolean, 
	id_division_politica int4 NOT NULL
);
alter table ciudad add constraint Fk_ciudad_division_politica foreign key (id_division_politica) references division_politica (id_division_politica);


-- sse agrega nuevas columnas a la tabla personas
alter table persona rename id_pais to id_pais_residencia;
ALTER TABLE persona ADD COLUMN id_actividad_economica int4;
ALTER TABLE persona ADD COLUMN id_ciudad_residencia int4;
alter table persona add constraint Fk_persona_actividad_economica foreign key (id_actividad_economica ) references actividad_economica (id_actividad_economica);
alter table persona add constraint Fk_persona_ciudad foreign key (id_ciudad_residencia) references ciudad (id_ciudad);
