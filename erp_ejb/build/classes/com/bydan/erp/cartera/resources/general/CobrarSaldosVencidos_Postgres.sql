select 
	(select nombre from cartera.grupo_cliente where id=c.id_grupo_cliente) as nombre_grupo_cliente,
	c.codigo,
	c.nombre,
	d.numero_factura,
	(select string_agg(telefono,',') from cartera.telefono where id_cliente=c.id) as telefono_telefono,
	(select max(fecha) from facturacion.factura where id=d.id_factura)as fecha,
	(select max(descripcion) from facturacion.factura where id=d.id_factura)as fecha,
	min(d.fecha_emision) as fecha_emision,
	max(d.fecha_vence) as fecha_vence,
	sum(d.debito_mone_local - d.credito_mone_local)as saldo
	
from cartera.cliente c inner join cartera.detalle_cliente d 
	on d.id_cliente=c.id
--where
group by c.id_grupo_cliente,
	 c.codigo,
	 c.nombre,
	 d.numero_factura,
	 c.id,
	 d.id_factura