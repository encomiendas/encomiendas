-- Tabla cliente
create table cliente(
	id_cliente serial not null primary key,
	id_persona int4,
	estado boolean,
	
	CONSTRAINT cliente_persona FOREIGN KEY (id_persona)
      REFERENCES persona (id_persona) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


