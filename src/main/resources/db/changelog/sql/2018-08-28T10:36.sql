-- Tabla empresa
create table empresa (
	id_empresa serial not null primary key,
	descripcion varchar(100) not null,
	nro_documento varchar(50),
	direccion varchar(100),
	telefono varchar(100),
	estado boolean 
)