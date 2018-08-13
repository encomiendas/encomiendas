-- Tabla tipo_persona

CREATE TABLE tipo_persona
(
  id_tipo_persona serial not null primary key,
  descripcion character varying(30) not null
)

WITH (
  OIDS=FALSE
);
ALTER TABLE tipo_persona
  OWNER TO encomiendas;

insert into tipo_persona (descripcion) values ('FISICA');
insert into tipo_persona (descripcion) values ('JURIDICA');