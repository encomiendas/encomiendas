-- Tabla menu
create table menu (
	id_menu serial not null primary key,
	tipo_menu varchar(1) not null,
	posicion int4,
	id_perfil int4,
	id_pagina int4,
	
	CONSTRAINT menu_perfil FOREIGN KEY (id_perfil)
      REFERENCES perfil (id_perfil) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
      
    CONSTRAINT menu_pagina FOREIGN KEY (id_pagina)
      REFERENCES pagina (id_pagina) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)