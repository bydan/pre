select 
	(select nombre_completo from cartera.cliente where id=m.id_cliente) as nombre_completo_cliente,
	m.numero_comprobante,
	m.fecha_emision,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	d.costo_unitario,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto
from inventario.movimiento_inventario m
inner join inventario.detalle_movimiento_inventario d on d.id_movimiento_inventario=m.id
inner join inventario.producto p on d.id_producto=p.id
--where