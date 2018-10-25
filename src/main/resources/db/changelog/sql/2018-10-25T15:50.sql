--Tabla moneda
CREATE TABLE moneda ( 
  id_moneda serial primary key not null,
  descripcion character varying(50) NOT NULL,
  abreviatura character varying(5),
  estado boolean);

insert into moneda (descripcion, abreviatura, estado) values ('GUARANIES', 'GS.', true);
insert into moneda (descripcion, abreviatura, estado) values ('PESO ARGENTINO', 'ARS.', true);

