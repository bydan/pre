select 
	(select nombre from seguridad.sucursal where id=m.id_sucursal) as nombre_sucursal,
	(select id from contabilidad.tipo_transaccion_modulo where id=m.id_tipo_transaccion_modulo) as id_tipo_transaccion_modulo,
	m.numero_comprobante,
	m.fecha,
	(select nombre from inventario.bodega where id=d.id_bodega) as nombre_bodega,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	d.cantidad,
	d.costo_unitario,
	d.costo_total,
	(select nombre from inventario.bodega where id=d.id_bodega_enviar) as nombre_bodega_enviar,
	0.0 as total
from inventario.movimiento_inventario m
inner join inventario.detalle_movimiento_inventario d on d.id_movimiento_inventario=m.id
--where