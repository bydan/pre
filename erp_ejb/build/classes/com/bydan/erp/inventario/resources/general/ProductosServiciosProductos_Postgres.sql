select 
	(select nombre from seguridad.sucursal where id=p.id_sucursal) as nombre_sucursal,
	(select nombre from inventario.linea where id=p.id_linea) as nombre_linea,
	(select nombre from inventario.linea where id=p.id_linea_grupo) as nombre_linea_grupo,
	(select nombre from inventario.linea where id=p.id_linea_categoria) as nombre_linea_categoria,
	(select nombre from inventario.linea where id=p.id_linea_marca) as nombre_linea_marca,
	p.codigo,
	p.nombre,
	(select nombre from facturacion.tipo_producto_servicio where id=p.id_tipo_producto_servicio) as nombre_tipo_producto_servicio,
	(select nombre from inventario.bodega where id=bp.id_bodega) as nombre_bodega,
	(select nombre from inventario.unidad where id=bp.id_unidad) as nombre_unidad
from inventario.producto p
inner join inventario.bodega_producto bp on bp.id_producto=p.id
inner join inventario.bodega b on bp.id_bodega=b.id
--where