
--actividad economica
insert into actividad_economica (descripcion, estado) values ('EMPLEADO SECTOR PUBLICO', true);
insert into actividad_economica (descripcion, estado) values ('EMPLEADO SECTOR PRIVADO', true);
insert into actividad_economica (descripcion, estado) values ('INDEPENDIENTE', true);

--Division Economica
insert into division_politica (descripcion, estado, id_pais) values ('CENTRAL', true,1);
insert into division_politica (descripcion, estado, id_pais) values ('ALTO PARANA', true,1);

--Ciudad
insert into ciudad (descripcion, estado, id_division_politica) values ('ASUNCION', true,1);
insert into ciudad (descripcion, estado, id_division_politica) values ('FERNANDO DE LA MORA', true,1);
insert into ciudad (descripcion, estado, id_division_politica) values ('SAN LORENZO', true,1);
insert into ciudad (descripcion, estado, id_division_politica) values ('CIUDAD DEL ESTE', true,2);
