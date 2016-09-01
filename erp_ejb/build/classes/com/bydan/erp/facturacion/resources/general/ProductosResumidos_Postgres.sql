select 
	(select nombre from inventario.unidad where id=d.id_unidad) as nombre_unidad,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	sum(d.cantidad) as cantidad,
	sum(d.monto) as monto,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto,
	'1' as tipo
from facturacion.factura f
inner join facturacion.detalle_factura d on d.id_factura=f.id
--where1
group by d.id_unidad,
	 d.id_producto
	 
union

select 
	(select nombre from inventario.unidad where id=d.id_unidad) as nombre_unidad,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	sum(d.cantidad) as cantidad,
	sum(d.monto) as monto,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto,
	'0' as tipo
from facturacion.nota_credito f
inner join facturacion.deta_nota_credito d on d.id_nota_credito=f.id
--where2 
group by d.id_unidad,
	 d.id_producto