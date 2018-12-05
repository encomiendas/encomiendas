--tabla tipo equipo

create table equipo (
  id_equipo serial not null primary key,
  descripcion varchar(30) not null,
  id_sucursal integer not null,
  id_usuario integer not null,
  imprimir_factura boolean,
  fecha_log timestamp default now(),
  estado boolean
);
