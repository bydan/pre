select 
	(select nombre from tesoreria.transaccion where id=m.id_transaccion) as nombre_transaccion,
	(select nombre from inventario.bodega where id=d.id_bodega) as nombre_bodega,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	(select nombre from inventario.unidad where id=d.id_unidad) as nombre_unidad,
	d.cantidad,
	d.costo_unitario,
	d.costo_total,
	(select nombre from inventario.bodega where id=d.id_bodega_enviar) as nombre_bodega_enviar,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto,
	'INGRESOS' as tipo
from inventario.movimiento_inventario m
inner join inventario.detalle_movimiento_inventario d on d.id_movimiento_inventario=m.id
inner join inventario.producto p on d.id_producto=p.id
--where1

UNION

select 
	(select nombre from tesoreria.transaccion where id=m.id_transaccion) as nombre_transaccion,
	(select nombre from inventario.bodega where id=d.id_bodega) as nombre_bodega,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	(select nombre from inventario.unidad where id=d.id_unidad) as nombre_unidad,
	d.cantidad,
	d.costo_unitario,
	d.costo_total,
	(select nombre from inventario.bodega where id=d.id_bodega_enviar) as nombre_bodega_enviar,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto,
	'EGRESOS' as tipo
from inventario.movimiento_inventario m
inner join inventario.detalle_movimiento_inventario d on d.id_movimiento_inventario=m.id
inner join inventario.producto p on d.id_producto=p.id
--where2