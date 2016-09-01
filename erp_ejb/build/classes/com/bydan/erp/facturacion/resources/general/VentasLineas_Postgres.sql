select 
	(select nombre from inventario.linea where id=p.id_linea) as nombre_linea,
	(select nombre from inventario.linea where id=p.id_linea_grupo) as nombre_grupo,
	(select nombre from inventario.linea where id=p.id_linea_categoria) as nombre_categoria,
	(select nombre from inventario.linea where id=p.id_linea_marca) as nombre_marca,
	sum(d.monto) as monto,	
	0.0 as notas_credito,
	0.0 as venta_neta,
	0.0 as porcentaje,
	0.0 as acumulado,
	'0' as tipo
from cartera.cliente c inner join facturacion.factura f
	on f.id_cliente=c.id
inner join facturacion.detalle_factura d on d.id_factura=f.id
inner join inventario.producto p on p.id=d.id_producto
--where1
group by p.id_linea,
	 p.id_linea_grupo,
	 p.id_linea_categoria,	
	 p.id_linea_marca,
	 tipo

union

select 
	(select nombre from inventario.linea where id=p.id_linea) as nombre_linea,
	(select nombre from inventario.linea where id=p.id_linea_grupo) as nombre_grupo,
	(select nombre from inventario.linea where id=p.id_linea_categoria) as nombre_categoria,
	(select nombre from inventario.linea where id=p.id_linea_marca) as nombre_marca,
	0.0 as monto,
	sum(d.monto) as notas_credito,
	0.0 as venta_neta,
	0.0 as porcentaje,
	0.0 as acumulado,
	'1' as tipo
	
from cartera.cliente c inner join facturacion.nota_credito f
	on f.id_cliente=c.id
inner join facturacion.deta_nota_credito d on d.id_nota_credito=f.id
inner join inventario.producto p 
	on p.id=d.id_producto
--where2
group by p.id_linea,
	 p.id_linea_grupo,
	 p.id_linea_categoria,	
	 p.id_linea_marca,
	 tipo
	