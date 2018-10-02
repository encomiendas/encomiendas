
alter table tipo_documento add column abreviatura character varying(5);

update tipo_documento set abreviatura = 'CI' where id_tipo_documento = 1;
update tipo_documento set abreviatura = 'PAS' where id_tipo_documento = 2;

