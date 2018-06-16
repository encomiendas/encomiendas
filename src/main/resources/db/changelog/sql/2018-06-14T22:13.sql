-- Tabla tipo_documento

CREATE TABLE tipo_documento
(
  id_tipo_documento serial not null primary key,
  descripcion character varying(30) not null,
  estado boolean
)

WITH (
  OIDS=FALSE
);
ALTER TABLE tipo_documento
  OWNER TO encomiendas;
