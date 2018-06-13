-- This script create the Pais table --
CREATE TABLE public.pais
(
  id serial not null primary key,
  descripcion character varying(100) NOT NULL,
  gentilicio character varying(100) NOT NULL,
  cod_pais_num integer,
  cod_pais_alfa character varying(10)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.pais
  OWNER TO encomiendas;