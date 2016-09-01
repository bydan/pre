select 
	b.codigo,
	(select nombre from inventario.unidad where id=bp.id_unidad) as nombre_unidad,
	bp.cantidad_disponible,
	bp.cantidad_fisica,
	p.codigo as codigo_producto,
	p.nombre,
	0.0 as ingresos,
	0.0 as egresos,
	0.0 as disponible_corte,
	0.0 as diferencia,
	0.0 as costo,
	0.0 as total
from inventario.bodega b
inner join inventario.bodega_producto bp on bp.id_bodega=b.id
inner join inventario.producto p on bp.id_producto=p.id
--where
