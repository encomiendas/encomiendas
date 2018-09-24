-- Tabla pagina
create table pagina (
	id_pagina serial not null primary key,
	descripcion varchar(100) not null,
	url varchar(250)
);

insert into pagina (descripcion, url) values ('Mant. Usuario', 'usuario-lista');
insert into pagina (descripcion, url) values ('Mant. Menu', 'menu-lista');
insert into pagina (descripcion, url) values ('Mant. Perfil', 'perfil-lista');
insert into pagina (descripcion, url) values ('Mant. Perfil Usuario', 'perfil-usuario-lista');
insert into pagina (descripcion, url) values ('Mant. Pagina', 'pagina-lista');