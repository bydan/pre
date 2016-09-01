select 
	(select nombre from seguridad.sucursal where id=m.id_sucursal) as nombre_sucursal,
	(select nombre_completo from cartera.cliente where id=m.id_cliente) as nombre_completo_cliente,
	(select nombre from tesoreria.transaccion where id=m.id_transaccion) as nombre_transaccion,
	m.numero_comprobante,
	m.numero_factura,
	m.numero_secuencial,
	m.fecha_emision,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	(select nombre from inventario.unidad where id=d.id_unidad) as nombre_unidad,
	d.cantidad,
	d.iva,
	d.costo_unitario,
	d.costo_total,
	d.ice,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto
from inventario.movimiento_inventario m
inner join inventario.detalle_movimiento_inventario d on d.id_movimiento_inventario=m.id
inner join inventario.producto p on d.id_producto=p.id
--where