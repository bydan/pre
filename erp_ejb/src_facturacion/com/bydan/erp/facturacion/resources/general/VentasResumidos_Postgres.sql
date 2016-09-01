select 
	c.nombre_completo,
	c.ruc,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	sum(d.cantidad) as cantidad,
	avg(d.precio) as precio,
	sum(d.monto) as monto,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto
from cartera.cliente c
inner join facturacion.factura f on f.id_cliente=c.id
inner join facturacion.detalle_factura d on d.id_factura=f.id
--where
group by c.nombre_completo,
		 c.ruc,
		 d.id_producto