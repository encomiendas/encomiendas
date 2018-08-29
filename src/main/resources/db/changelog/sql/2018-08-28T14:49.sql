-- Tabla sucursal
create table sucursal (
	id_sucursal serial not null primary key,
	descripcion varchar(100) not null,
	id_empresa int4,
	estado boolean,
	CONSTRAINT sucursal_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

insert into sucursal (descripcion, id_empresa, estado) values ('ADMINISTRADOR', 1, true);