-- Tabla menu
create table menu (
	id_menu serial not null primary key,
	tipo_menu varchar(1) not null,
	descripcion varchar(250),
	id_menu_anterior int4,
	posicion int4,
	id_perfil int4,
	id_pagina int4,
	estado boolean default true,
	CONSTRAINT menu_perfil FOREIGN KEY (id_perfil)
      REFERENCES perfil (id_perfil) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
      
    CONSTRAINT menu_pagina FOREIGN KEY (id_pagina)
      REFERENCES pagina (id_pagina) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
      
    CONSTRAINT Fk_menu_menuanterior FOREIGN KEY (id_menu_anterior) 
      REFERENCES menu (id_menu) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

INSERT INTO menu(tipo_menu, posicion, id_perfil, id_pagina, descripcion, id_menu_anterior)
    VALUES ('M', 1, 1, null, 'Procesos', null);
    
INSERT INTO menu(tipo_menu, posicion, id_perfil, id_pagina, descripcion, id_menu_anterior)
    VALUES ('S', 1, 1, 1, 'Usuarios', 1);
    
INSERT INTO menu(tipo_menu, posicion, id_perfil, id_pagina, descripcion, id_menu_anterior)
    VALUES ('S', 1, 1, 2, 'Menu', 1);
    
INSERT INTO menu(tipo_menu, posicion, id_perfil, id_pagina, descripcion, id_menu_anterior)
    VALUES ('S', 1, 1, 3, 'Perfiles', 1);
    
INSERT INTO menu(tipo_menu, posicion, id_perfil, id_pagina, descripcion, id_menu_anterior)
    VALUES ('S', 1, 1, 4, 'Perfiles Por Usuario', 1);

INSERT INTO menu(tipo_menu, posicion, id_perfil, id_pagina, descripcion, id_menu_anterior)
    VALUES ('S', 1, 1, 5, 'Paginas', 1);
    
INSERT INTO menu(tipo_menu, posicion, id_perfil, id_pagina, descripcion, id_menu_anterior)
    VALUES ('M', 1, 1, null, 'Informes', null);