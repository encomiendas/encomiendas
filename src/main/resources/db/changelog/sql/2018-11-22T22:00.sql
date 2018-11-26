CREATE OR REPLACE FUNCTION func_tri_cotizacion_au()
  RETURNS trigger AS
$BODY$
declare 
BEGIN

  if ((new.cotiz_compra <> old.cotiz_compra) or (new.cotiz_venta <> old.cotiz_venta)) then

    insert into cotizacion_historico (
      id_cotizacion,
      cotiz_venta,
      cotiz_compra,
      id_usuario,
      fecha,
      id_usuario_log,
      fecha_log)
    values (old.id_cotizacion,
            old.cotiz_venta,
            old.cotiz_compra,
            old.id_usuario_log,
            old.fecha_log,
            new.id_usuario_log,
            new.fecha_log);
  end if;
  return null;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


CREATE TRIGGER tri_cotizacion_au
  AFTER UPDATE
  ON cotizacion
  FOR EACH ROW
  EXECUTE PROCEDURE func_tri_cotizacion_au();
