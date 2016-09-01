select
	p.codigo,
	p.nombre,
	0.0 as precio,
	0.0 as numero,
	'1' as talla
from inventario.bodega b
inner join inventario.bodega_producto bp on bp.id_bodega=b.id
inner join inventario.producto p on bp.id_producto=p.id
--where