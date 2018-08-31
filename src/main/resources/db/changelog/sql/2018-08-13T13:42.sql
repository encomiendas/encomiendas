-- Tabla persona y usuario
CREATE TABLE persona (
id_persona serial not null primary key,
nombres VARCHAR(150) not null,
apellidos VARCHAR(150) NULL,
id_tipo_persona int4 NOT NULL,
id_tipo_documento int4 NOT NULL,
documento VARCHAR(20) NULL,
id_tipo_documento2 int4 NULL,
documento2 VARCHAR(20) NULL,
fecha_nacimiento DATE NULL,
telefono VARCHAR(100) NULL,
direccion VARCHAR(150) NULL,
id_pais int4 NOT NULL,
id_pais_nacionalidad int4 NOT NULL,
genero VARCHAR(2) NULL,
id_estado_civil int4 NULL,
correo varchar(150) NULL,
estado boolean not null);

alter table persona add constraint Fk_persona_tipo_persona foreign key (id_tipo_persona) references tipo_persona (id_tipo_persona);
alter table persona add constraint Fk_persona_tipo_documento foreign key (id_tipo_documento) references tipo_documento (id_tipo_documento);
alter table persona add constraint Fk_persona_tipo_documento2 foreign key (id_tipo_documento2) references tipo_documento (id_tipo_documento);
alter table persona add constraint Fk_persona_pais foreign key (id_pais) references pais (id);
alter table persona add constraint Fk_persona_paisnacionalidad foreign key (id_pais_nacionalidad) references pais (id);
alter table persona add constraint fk_persona_estado_civil foreign key (id_estado_civil) references estado_civil (id_estado_civil);

insert into persona (
	nombres,
	id_tipo_persona,
	id_tipo_documento,
	documento,
	id_pais,
	id_pais_nacionalidad,
	estado)
	values ('ADMINISTRADOR',1,1,'44444401-7',1,1,true);


-- This script create the first schemas and tables for the project. --
-- Tabla usuario
CREATE TABLE public.usuario
(
  id serial not null primary key,
  login character varying(30) not null,
  password character varying(256) NOT NULL,  
  activo boolean,
  expira boolean,
  fecha_expiracion date,
  id_persona int4,
  id_sucursal int4,
  
  CONSTRAINT usuario_persona FOREIGN KEY (id_persona)
      REFERENCES persona (id_persona) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  
  CONSTRAINT usuario_sucursal FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

--Tabla roles
CREATE TABLE public.roles
(
  id serial not null primary key,
  role character varying(50)
);
  
--Table usaurios x roles
CREATE TABLE public.usuarios_x_role
(
  id_usuario_x_role serial not null primary key,
  id_usuario integer,
  id_role integer,
  
  CONSTRAINT usuario_x_role_roles FOREIGN KEY (id_role)
      REFERENCES public.roles (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT usuario_x_role_usuarios FOREIGN KEY (id_usuario)
      REFERENCES public.usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

--Se inicializa datos de roles (verificar para su real implementacion en la logia de negocio)
insert into public.roles (role) values ('ROLE_USER');
insert into public.roles (role) values ('ROLE_ADMIN');

--Se inicializa el usuario admin por defecto para desarrollo (cambiar para produccion)
insert into public.usuario (login, password, activo, expira, id_persona, id_sucursal) 
values ('admin', '$2a$04$fkD5Q69wjlZC/iaOW5tovuJbeGniLrxDvSP9Aq3jxrX0NsJgTZSAi', true, false,1,1);

--Se inserta el role USER para el ADMIN
INSERT INTO public.usuarios_x_role (id_usuario, id_role)
  VALUES (
    (SELECT id FROM public.usuario WHERE login = 'admin'),
    (SELECT id FROM public.roles WHERE role = 'ROLE_USER'));

    --Se inserta el role ADMIN para el ADMIN
INSERT INTO public.usuarios_x_role (id_usuario, id_role)
  VALUES (
    (SELECT id FROM public.usuario WHERE login = 'admin'),
    (SELECT id FROM public.roles WHERE role = 'ROLE_ADMIN'));
