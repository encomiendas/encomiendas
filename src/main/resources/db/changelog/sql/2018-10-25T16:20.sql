-- Tabla envio.
create table envio (
	id_envio serial not null primary key,
	fecha_envio timestamp not null,
        id_sucursal integer not null,
	id_cliente_remitente integer not null,
	id_cliente_destinatario integer not null,
	estado varchar(1) not null check (estado in ('P','L','A')),
	id_unidad_negocio integer not null,
	entregado varchar(1) not null check (estado in ('S','N')),
	id_usuario integer not null,
	id_usuario_log integer,
	fecha_log timestamp,
	id_pais_destino integer,
	id_sucursal_destino integer
);


alter table envio add constraint Fk_envio_sucursal foreign key (id_sucursal) references sucursal (id_sucursal);
alter table envio add constraint Fk_envio_cliente_remi foreign key (id_cliente_remitente) references cliente (id_cliente);
alter table envio add constraint Fk_envio_cliente_dest foreign key (id_cliente_destinatario) references cliente (id_cliente);
alter table envio add constraint Fk_envio_unidad_negocio foreign key (id_unidad_negocio) references unidad_negocio (id_unidad_negocio);
alter table envio add constraint Fk_envio_usuario foreign key (id_usuario) references usuario (id);
alter table envio add constraint Fk_envio_usuario_log foreign key (id_usuario_log) references usuario (id);
alter table envio add constraint Fk_envio_pais_dest foreign key (id_pais_destino) references pais (id);
alter table envio add constraint Fk_envio_sucursal_dest foreign key (id_sucursal_destino) references sucursal (id_sucursal);

--envio_det
create table envio_det (
  id_envio_det serial not null primary key,
  id_envio integer not null,
  item integer not null,
  id_concepto integer not null,
  comentario varchar(100),
  cantidad numeric(21,6) DEFAULT 0 CHECK (cantidad >= 0),
  monto_tarifa numeric(21,6) DEFAULT 0 CHECK (monto_tarifa >= 0),
  monto_total numeric(21,6) DEFAULT 0 CHECK (monto_total >= 0),
  monto_envio numeric(21,6) DEFAULT 0 CHECK (monto_envio >= 0),
  id_moneda integer not null,
  id_moneda_entrega integer
);

alter table envio_det add constraint Fk_envio_det_envio foreign key (id_envio) references envio (id_envio);
alter table envio_det add constraint Fk_envio_det_concepto foreign key (id_concepto) references concepto (id_concepto);
alter table envio_det add constraint Fk_envio_det_moneda foreign key (id_moneda) references moneda (id_moneda);
alter table envio_det add constraint Fk_envio_det_moneda_entrega foreign key (id_moneda_entrega) references moneda (id_moneda);
