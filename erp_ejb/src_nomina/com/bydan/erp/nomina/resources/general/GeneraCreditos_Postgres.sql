select 
	c.codigo,
	c.nombre_completo,
	d.fecha_vence,
	d.fecha_emision,
	d.numero_factura,
	sum(d.debito_mone_local) as debito_mone_local,
	sum(d.credito_mone_local) as credito_mone_local,
	0.0 as saldo
from cartera.cliente c
inner join cartera.detalle_cliente d on d.id_cliente=c.id
--where
 group by 
		c.codigo,
		c.nombre_completo,
		d.fecha_vence,
		d.fecha_emision,
		d.numero_factura