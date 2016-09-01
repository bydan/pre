select 
	(select nombre from seguridad.ciudad where id=c.id_ciudad) as nombre_ciudad,
	(select nombre from seguridad.zona where id=c.id_zona) as nombre_zona,
	(select nombre from comisiones.vendedor where id=c.id_vendedor) as nombre_vendedor,
	c.codigo,
	c.nombre_completo,
	c.limite_credito,
	c.representante,
	c.dia_pago,
	d.numero_comprobante,
	d.numero_factura,
	(select max(direccion) from cartera.direccion where id_cliente=c.id) as direccion_direccion,
	(select string_agg(telefono,',') from cartera.telefono where id_cliente=c.id) as telefono_telefono,
	(select min(d.fecha_emision) from cartera.detalle_cliente where id_cliente = c.id and id_factura=d.id_factura) as fecha_emision,
	(select min(d.fecha_vence) from cartera.detalle_cliente where id_cliente = c.id and id_factura=d.id_factura and debito_mone_local>0) as fecha_vence,
	0 as dias,
	(select min(limite_credito) from cartera.cliente where id=c.id)as limite_credito,
	sum(d.debito_mone_local - d.credito_mone_local)as saldo,
	sum(d.debito_mone_local) as debito_mone_local,
	sum(d.credito_mone_local)as credito_mone_local,
	max(c.dia_pago) as dia_pago,
	max(c.hora_pago) as hora_pago
	
from cartera.cliente c
inner join cartera.detalle_cliente d on d.id_cliente=c.id

--where

group by c.id_ciudad,
	c.id_zona,
	c.id_vendedor,
	c.codigo,
	c.nombre_completo,
	c.limite_credito,
	c.representante,
	c.dia_pago,
	d.numero_comprobante,
	d.numero_factura,
	c.id,
	d.id_factura

having sum(d.debito_mone_local - d.credito_mone_local) !=0