select 
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	sum(d.monto) as monto,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto,
	0.0 as notas_credito,
	0.0 as venta_neta,
	0.0 as porcentaje,
	0.0 as acumulado,
	'0' as tipo
from facturacion.factura f
inner join facturacion.detalle_factura d on d.id_factura=f.id
--where1
group by d.id_producto,
	 	 tipo

union

select 
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	0.0 as monto,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto,
	sum(d.monto) as notas_credito,
	0.0 as venta_neta,
	0.0 as porcentaje,
	0.0 as acumulado,
	'1' as tipo
from facturacion.nota_credito f
inner join facturacion.deta_nota_credito d on d.id_nota_credito=f.id
--where2
group by d.id_producto,
	 	 tipo