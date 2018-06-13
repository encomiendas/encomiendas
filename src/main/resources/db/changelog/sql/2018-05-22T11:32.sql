-- This script create the first schemas and tables for the project. --

-- Tabla usuario
CREATE TABLE public.usuario
(
  id serial not null primary key,
  login character varying(30) not null,
  password character varying(256) NOT NULL,
  correo character varying(256) NOT NULL,
  activo boolean
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.usuario
  OWNER TO encomiendas;

--Tabla roles
CREATE TABLE public.roles
(
  id serial not null primary key,
  role character varying(50)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.roles
  OWNER TO encomiendas;
  
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
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.usuarios_x_role
  OWNER TO encomiendas;

--Se inicializa datos de roles (verificar para su real implementacion en la logia de negocio)
insert into public.roles (role) values ('ROLE_USER');
insert into public.roles (role) values ('ROLE_ADMIN');

--Se inicializa el usuario admin por defecto para desarrollo (cambiar para produccion)
insert into public.usuario (login, password, correo, activo) 
values ('admin', '$2a$04$fkD5Q69wjlZC/iaOW5tovuJbeGniLrxDvSP9Aq3jxrX0NsJgTZSAi', 'domainsoft.py@gmail.com', true);

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
    