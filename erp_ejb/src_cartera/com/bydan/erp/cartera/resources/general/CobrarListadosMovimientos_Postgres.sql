select 
	c.codigo,
	c.nombre_completo,
	(select nombre from tesoreria.transaccion where id=d.id_transaccion) as nombre_transaccion,
	d.fecha_vence,
	d.fecha_emision,
	d.numero_comprobante,
	d.numero_factura,
	d.debito_mone_local,
	d.credito_mone_local,
	d.descripcion
from cartera.cliente c
inner join cartera.detalle_cliente d on d.id_cliente=c.id
--where