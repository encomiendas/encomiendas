--tabla cotizacion
create table cotizacion (
	id_cotizacion serial not null primary key,
	id_sucursal integer not null,
	id_moneda_de integer not null,
	id_moneda_a integer not null,
	cotiz_compra numeric(21,6) not null DEFAULT 0 CHECK (cotiz_compra >= 0),
	cotiz_venta  numeric(21,6) not null DEFAULT 0 CHECK (cotiz_venta >= 0),
	fecha_log timestamp,
	id_usuario_log integer
);

alter table cotizacion add constraint fk_cotizacion_moneda_de foreign key (id_moneda_de) references moneda (id_moneda);
alter table cotizacion add constraint fk_cotizacion_moneda_a foreign key (id_moneda_a) references moneda (id_moneda);
alter table cotizacion add constraint fk_cotizacion_sucursal foreign key (id_sucursal) references sucursal (id_sucursal);
alter table cotizacion add constraint fk_cotizacion_usuario foreign key (id_usuario_log) references usuario (id);


--tabla cotizacion_historico
create table cotizacion_historico (
	id_cotizacion_historico serial not null primary key,
	id_cotizacion integer not null,
	cotiz_venta numeric(21,6) not null DEFAULT 0 CHECK (cotiz_venta >= 0),
	cotiz_compra numeric(21,6) not null DEFAULT 0 CHECK (cotiz_compra >= 0),
	id_usuario integer,
	fecha timestamp,
	id_usuario_log integer,
	fecha_log timestamp
);

alter table cotizacion_historico add constraint fk_cotizacion_hist_cotizacion foreign key (id_cotizacion) references cotizacion (id_cotizacion);
alter table cotizacion_historico add constraint fk_cotizacion_hist_usuario foreign key (id_usuario) references usuario (id);
alter table cotizacion_historico add constraint fk_cotizacion_hist_usuario_log foreign key (id_usuario_log) references usuario (id);
