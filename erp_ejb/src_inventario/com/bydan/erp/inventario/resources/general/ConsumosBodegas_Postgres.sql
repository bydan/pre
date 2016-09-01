select 
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	(select nombre from inventario.unidad where id=d.id_unidad) as nombre_unidad,
	sum(d.cantidad) as cantidad,
	sum(d.costo_total) as costo_total,
	(select nombre from inventario.linea where id=p.id_linea) as nombre_linea,
	(select nombre from inventario.linea where id=p.id_linea_grupo) as nombre_linea_grupo,
	(select nombre from inventario.linea where id=p.id_linea_categoria) as nombre_linea_categoria,
	(select nombre from inventario.linea where id=p.id_linea_marca) as nombre_linea_marca,
	p.codigo
from inventario.movimiento_inventario m
inner join inventario.detalle_movimiento_inventario d on d.id_movimiento_inventario=m.id
inner join inventario.producto p on d.id_producto=p.id
--where
 group by 
		d.id_producto,
		d.id_unidad,
		p.id_linea,
		p.id_linea_grupo,
		p.id_linea_categoria,
		p.id_linea_marca,
		p.codigo