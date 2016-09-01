select 
	b.codigo,
	(select nombre from inventario.unidad where id=bp.id_unidad) as nombre_unidad,
	(select nombre_completo from cartera.cliente where id=p.id_cliente) as nombre_completo_cliente,
	p.codigo as codigo_producto,
	p.nombre,
	(select nombre_completo from cartera.cliente where id=p.id_cliente_proveedor_defecto) as nombre_completo_cliente_proveedor_defecto
from inventario.bodega b
inner join inventario.bodega_producto bp on bp.id_bodega=b.id
inner join inventario.producto p on bp.id_producto=p.id
--where