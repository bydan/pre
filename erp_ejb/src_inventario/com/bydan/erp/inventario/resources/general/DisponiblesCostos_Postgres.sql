select 
	(select nombre from seguridad.sucursal where id=p.id_sucursal) as nombre_sucursal,
	(select nombre from inventario.linea where id=p.id_linea) as nombre_linea,
	(select nombre from inventario.linea where id=p.id_linea_grupo) as nombre_linea_grupo,
	(select nombre from inventario.linea where id=p.id_linea_categoria) as nombre_linea_categoria,
	(select nombre from inventario.linea where id=p.id_linea_marca) as nombre_linea_marca,
	p.codigo,
	p.nombre,
	(select nombre from inventario.bodega where id=bp.id_bodega) as nombre_bodega,
	(select nombre from inventario.unidad where id=bp.id_unidad) as nombre_unidad,
	
	(select sum(d.cantidad) 
				from inventario.movimiento_inventario m 
				inner join inventario.detalle_movimiento_inventario d on d.id_movimiento_inventario=m.id 
				inner join inventario.definicion df on m.id_transaccion=df.id_transaccion
				where d.id_bodega=bp.id_bodega and d.id_producto=bp.id_producto and df.es_ingreso_bodega=true and
				m.fecha_emision<='FECHA_EMISION_HASTA') 
	as ingresos,
	
	(select sum(d.cantidad) 
				from inventario.movimiento_inventario m 
				inner join inventario.detalle_movimiento_inventario d on d.id_movimiento_inventario=m.id 
				inner join inventario.definicion df on m.id_transaccion=df.id_transaccion
				where d.id_bodega=bp.id_bodega and d.id_producto=bp.id_producto and df.es_egreso_bodega=true and
				m.fecha_emision<='FECHA_EMISION_HASTA')
	as egresos,
	
	0.0 as disponible_corte,
	(select valor_unitario from inventario.costo where 
				id in (select max(id) from inventario.costo where id_bodega=bp.id_bodega and id_producto=bp.id_producto and 
				fecha<='FECHA_EMISION_HASTA')) 
	as costo,
	0.0 as total
from inventario.producto p
inner join inventario.bodega_producto bp on bp.id_producto=p.id
inner join inventario.bodega b on bp.id_bodega=b.id
--where