--tabla tipo comprobante
create table tipo_comprobante (
  id_tipo_comprobante serial not null primary key,
  descripcion varchar(50) not null,
  tipo varchar(2),
  estado boolean
);
