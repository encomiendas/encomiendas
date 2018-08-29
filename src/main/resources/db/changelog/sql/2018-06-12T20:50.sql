-- This script create the Pais table --
CREATE TABLE pais
(
  id serial not null primary key,
  descripcion character varying(100) NOT NULL,
  gentilicio character varying(100) NOT NULL,
  cod_pais_num integer,
  cod_pais_alfa2 character varying(10),
  cod_pais_alfa3 character varying(10)
);

insert into pais (descripcion, gentilicio, cod_pais_num, cod_pais_alfa2, cod_pais_alfa3)
values ('PARAGUAY','PARAGUAYA',600,'PY','PRY');

insert into pais (descripcion, gentilicio, cod_pais_num, cod_pais_alfa2, cod_pais_alfa3)
values ('ARGENTINA','ARGENTINA',032,'AR','ARG');