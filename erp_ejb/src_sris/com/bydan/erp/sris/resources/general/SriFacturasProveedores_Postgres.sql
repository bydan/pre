select 
	c.identificacion,
	c.nombre,
	c.ruc,
	(select nombre from seguridad.modulo where id=d.id_modulo) as nombre_modulo,
	(select nombre_completo from cartera.cliente where id=d.id_cliente) as nombre_completo_cliente,
	(select nombre from tesoreria.transaccion where id=d.id_transaccion) as nombre_transaccion,
	(select codigo from contabilidad.asiento_contable where id=d.id_asiento_contable) as codigo_asiento_contable,
	d.fecha_emision,
	d.numero_factura,
	d.credito_mone_local
from cartera.cliente c
inner join cartera.detalle_prove d on d.id_cliente=c.id
--where