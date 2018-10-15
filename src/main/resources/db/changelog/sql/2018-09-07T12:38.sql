-- Tabla unidad_negocio
create table unidad_negocio (
	id_unidad_negocio serial not null primary key,
	descripcion varchar(100) not null,
	estado boolean
);

insert into unidad_negocio (descripcion, estado) values ('ENCOMIENDA', true);
insert into unidad_negocio (descripcion, estado) values ('GIROS', true);
