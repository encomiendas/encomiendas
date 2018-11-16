ALTER TABLE envio DROP CONSTRAINT envio_estado_check1;

ALTER TABLE envio ADD CONSTRAINT envio_estado_check1 CHECK (entregado::text = ANY (ARRAY['S'::character varying, 'N'::character varying]::text[]))

