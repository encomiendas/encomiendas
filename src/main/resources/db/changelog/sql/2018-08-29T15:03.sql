-- Tabla perfil_usuario
create table perfil_usuario (
	id_perfil_usuario serial not null primary key,
	id_perfil int4,
	id_usuario int4,
	
	CONSTRAINT perfil_usuario_perfil FOREIGN KEY (id_perfil)
      REFERENCES perfil (id_perfil) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
      
    CONSTRAINT perfil_usuario_usuario FOREIGN KEY (id_usuario)
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

insert into perfil_usuario (id_perfil, id_usuario) values (1,1);