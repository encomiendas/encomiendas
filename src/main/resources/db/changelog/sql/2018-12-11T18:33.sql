--tabla tipo existencia comprobante

create table existencia_comprobante (	
  id_existencia_comprob serial not null primary key,
  id_equipo integer not null,
  id_tipo_comprobante integer not null,
  nro_desde bigint not null,
  nro_hasta bigint not null,
  nro_timbrado varchar(30),
  fecha_inicio_timb date,
  fecha_fin_timb date,
  imprime boolean,
  id_usuario_log integer,
  fecha_log timestamp not null default now()
);






