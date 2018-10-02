-- Tabla grupo_concepto
create table grupo_concepto (
	id_grupo_concepto serial not null primary key,
	descripcion varchar(100) not null,
	estado boolean
);

insert into grupo_concepto (descripcion, estado) values ('ENCOMIENDA', true);
insert into grupo_concepto (descripcion, estado) values ('GIROS', true);
