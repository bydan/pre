select 
	p.secuencial,
	p.fecha_emision,
	p.fecha_entrega,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	(select nombre from inventario.unidad where id=d.id_unidad) as nombre_unidad,
	d.cantidad_pedido,
	d.cantidad_entregada,
	d.cantidad_pendiente,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto
from inventario.pedido_compra p
inner join inventario.detalle_pedido_compra d on d.id_pedido_compra=p.id
inner join inventario.producto pr on d.id_producto=pr.id
--where