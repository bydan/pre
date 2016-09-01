select 
	p.codigo,
	p.nombre,
	0.0 as precio1,
	0.0 as precio2,
	0.0 as precio3,
	0.0 as precio4,
	0.0 as precio5
from inventario.bodega b
inner join inventario.bodega_producto bp on bp.id_bodega=b.id
inner join inventario.producto p on bp.id_producto=p.id
--where