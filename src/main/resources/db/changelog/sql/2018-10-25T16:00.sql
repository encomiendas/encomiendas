--Creacion tabla tipo_impuesto
create table tipo_impuesto (
   id_tipo_impuesto serial not null primary key,
   descripcion varchar(50) not null,
   porcentaje numeric(21,6) DEFAULT 0 CHECK (porcentaje >= 0),
   id_pais integer not null,
   estado boolean,
   porcentaje_gravado numeric(21,6) DEFAULT 0 CHECK (porcentaje >= 0)
  );

alter table tipo_impuesto add constraint Fk_tipo_impuesto_pais foreign key (id_pais) references pais (id);     

insert into tipo_impuesto (descripcion, porcentaje, id_pais, estado, porcentaje_gravado) values ('EXENTO',0,1,true,0);
insert into tipo_impuesto (descripcion, porcentaje, id_pais, estado, porcentaje_gravado) values ('GRAVADO 10',10,1,true,100);
insert into tipo_impuesto (descripcion, porcentaje, id_pais, estado, porcentaje_gravado) values ('GRAVADO 5',5,1,true,100);
