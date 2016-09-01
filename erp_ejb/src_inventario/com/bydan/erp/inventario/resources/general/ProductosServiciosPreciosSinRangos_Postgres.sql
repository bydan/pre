select 
	(select nombre from seguridad.sucursal where id=p.id_sucursal) as nombre_sucursal,
	p.codigo,
	p.nombre,
	(select nombre from inventario.bodega where id=bp.id_bodega) as nombre_bodega,
	(select nombre from inventario.unidad where id=bp.id_unidad) as nombre_unidad,
	(select codigo from inventario.tipo_precio where id=pr.id_tipo_precio) as codigo_tipo_precio,
	pr.precio
from inventario.producto p
inner join inventario.bodega_producto bp on bp.id_producto=p.id
inner join inventario.precio pr on pr.id_producto=bp.id_producto and pr.id_bodega=bp.id_bodega
--where