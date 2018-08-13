-- Tabla persona
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
id_estado_civil int4 NOT NULL,
estado boolean not null);

alter table persona add constraint Fk_persona_tipo_persona foreign key (id_tipo_persona) references tipo_persona (id_tipo_persona);
alter table persona add constraint Fk_persona_tipo_documento foreign key (id_tipo_documento) references tipo_documento (id_tipo_documento);
alter table persona add constraint Fk_persona_tipo_documento2 foreign key (id_tipo_documento2) references tipo_documento (id_tipo_documento);
alter table persona add constraint Fk_persona_pais foreign key (id_pais) references pais (id);
alter table persona add constraint Fk_persona_paisnacionalidad foreign key (id_pais_nacionalidad) references pais (id);
alter table persona add constraint fk_persona_estado_civil foreign key (id_estado_civil) references estado_civil (id_estado_civil);