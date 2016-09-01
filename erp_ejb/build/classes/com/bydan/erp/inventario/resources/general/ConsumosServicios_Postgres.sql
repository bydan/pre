select 
	(select nombre from inventario.unidad where id=d.id_unidad) as nombre_unidad,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	sum(d.cantidad) as cantidad,
	(select nombre from inventario.linea where id=p.id_linea) as nombre_linea,
	(select nombre from inventario.linea where id=p.id_linea_grupo) as nombre_linea_grupo,
	(select nombre from inventario.linea where id=p.id_linea_categoria) as nombre_linea_categoria,
	(select nombre from inventario.linea where id=p.id_linea_marca) as nombre_linea_marca,
	p.codigo,
	0.0 as total
from inventario.movimiento_inventario m
inner join facturacion.detalle_factura d on d.id_factura=(select id from facturacion.factura where numero_pre_impreso=m.numero_factura)
inner join inventario.producto p on d.id_producto=p.id
--where
 group by 
		d.id_unidad,
		d.id_producto,
		p.id_linea,
		p.id_linea_grupo,
		p.id_linea_categoria,
		p.id_linea_marca,
		p.codigo