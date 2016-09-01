select 
	(select nombre_completo from cartera.cliente where id=f.id_cliente) as nombre_completo_cliente,
	(select nombre from contabilidad.tipo_factura where id=f.id_tipo_factura) as nombre_tipo_factura,
	f.fecha_emision,
	f.numero_documento,
	(f.total + f.total_flete + f.total_otro - f.total_descuento) as venta,
	(select sum(cantidad * costo_unitario) from inventario.detalle_movimiento_inventario d where d.id_movimiento_inventario=m.id) as costo,
	0.0 as utilidad,
	0.0 as porcentaje,
	'1' as tipo
from facturacion.factura f
inner join inventario.movimiento_inventario m on m.numero_comprobante=f.numero_pre_impreso
--where1

union 

select 
	(select nombre_completo from cartera.cliente where id=f.id_cliente) as nombre_completo_cliente,
	'nota credito' as nombre_tipo_factura,
	f.fecha_emision,
	f.numero_pre_impreso,
	(f.total + f.flete + f.otro - f.descuento_valor) as venta,
	(select sum(cantidad * costo_unitario) from inventario.detalle_movimiento_inventario d where d.id_movimiento_inventario=m.id) as costo,
	0.0 as utilidad,
	0.0 as porcentaje,
	'1' as tipo
from facturacion.nota_credito f
inner join inventario.movimiento_inventario m on m.numero_comprobante=f.numero_pre_impreso
--where2