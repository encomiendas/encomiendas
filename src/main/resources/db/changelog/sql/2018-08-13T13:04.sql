-- Tabla estado_civil

CREATE TABLE estado_civil
(
  id_estado_civil serial not null primary key,
  descripcion character varying(30) not null,
  estado boolean not null 
)

WITH (
  OIDS=FALSE
);
ALTER TABLE estado_civil
  OWNER TO encomiendas;

insert into estado_civil (descripcion, estado) values ('SOLTERO', true);
insert into estado_civil (descripcion, estado) values ('CASADO', true);
insert into estado_civil (descripcion, estado) values ('VIUDO', true);
insert into estado_civil (descripcion, estado) values ('DIVORCIADO', true);
insert into estado_civil (descripcion, estado) values ('SEPARADO', true);
insert into estado_civil (descripcion, estado) values ('COCUBINADO', true);
