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


alter table equipo add constraint Fk_equipo_sucursal foreign key (id_sucursal) references sucursal (id_sucursal);
alter table equipo add constraint Fk_equipo_usuario foreign key (id_usuario) references usuario (id);




