-- Tabla perfil
create table perfil (
	id_perfil serial not null primary key,
	descripcion varchar(100) not null
);

--Se inserta inicialmente el perfil de Administrador
insert into perfil (descripcion) values ('ADMINISTRADOR');