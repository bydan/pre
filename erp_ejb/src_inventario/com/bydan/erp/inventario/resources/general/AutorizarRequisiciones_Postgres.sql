select 
	(select codigo from inventario.tipo_requisicion where id=r.id_tipo_requisicion) as codigo_tipo_requisicion,
	r.codigo,
	r.fecha,
	(select nombre_completo from cartera.cliente where id=d.id_cliente) as nombre_completo_cliente,
	(select nombre from inventario.bodega where id=d.id_bodega) as nombre_bodega,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	d.cantidad,
	d.fecha_autoriza
from inventario.requisicion r
inner join inventario.detalle_requisicion d on d.id_requisicion=r.id
--where