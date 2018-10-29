--Tabla concepto
create table concepto (
   id_concepto serial not null primary key,
   id_grupo_concepto integer not null,
   descripcion varchar(50),
   estado boolean,
   id_tipo_impuesto integer not null);

alter table concepto add constraint Fk_concepto_grupo_concepto foreign key (id_grupo_concepto) references grupo_concepto (id_grupo_concepto);   
alter table concepto add constraint Fk_concepto_tipo_impuesto foreign key (id_tipo_impuesto) references tipo_impuesto (id_tipo_impuesto);   

insert into concepto (id_grupo_concepto,descripcion,estado,id_tipo_impuesto) values (2, 'GIRO NACIONAL', true, 2);
