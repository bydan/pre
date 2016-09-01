select 
	(select nombre from seguridad.empresa where id=p.id_empresa) as nombre_empresa,
	(select ruc from seguridad.empresa where id=p.id_empresa) as ruc_empresa,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	max((select nombre from inventario.unidad where id=d.id_unidad)) as nombre_unidad,
	sum(d.cantidad) as cantidad,
	avg(d.precio) as precio,
	sum(d.cantidad * d.precio) as total,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto
from facturacion.pedido p
inner join inventario.detalle_pedido d on d.id_pedido=p.id
inner join inventario.producto pr on d.id_producto=pr.id
--where
 group by 
		p.id_empresa,
		d.id_producto