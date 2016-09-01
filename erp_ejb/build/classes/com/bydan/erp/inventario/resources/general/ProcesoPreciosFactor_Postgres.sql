select 
	b.codigo,
	b.nombre,
	p.codigo as codigo_producto,
	p.nombre as nombre_producto,
	0.0 as precio,
	0.0 as factor
from inventario.bodega b
inner join inventario.bodega_producto bp on bp.id_bodega=b.id
inner join inventario.producto p on bp.id_producto=p.id
--where