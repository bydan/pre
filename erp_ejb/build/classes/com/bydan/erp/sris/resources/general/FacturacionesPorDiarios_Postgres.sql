select 
	a.fecha_emision,
	(select nombre from seguridad.sucursal where id=d.id_sucursal) as nombre_sucursal,
	(select nombre_completo from cartera.cliente where id=d.id_cliente) as nombre_completo_cliente,
	(select id from contabilidad.tipo_transaccion_modulo where id=d.id_tipo_transaccion_modulo) as id_tipo_transaccion_modulo,
	(select codigo from contabilidad.asiento_contable where id=d.id_asiento_contable) as codigo_asiento_contable,
	d.fecha_vence,
	d.fecha_emision as fecha_emision_detalle_cliente,
	d.monto_mone_local,
	d.numero_factura,
	(select ruc from cartera.cliente where id=d.id_cliente) as ruc_cliente
from contabilidad.asiento_contable a
inner join cartera.detalle_cliente d on d.id_asiento_contable=a.id
--where