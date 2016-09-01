select 
	(select nombre from inventario.unidad where id=d.id_unidad) as nombre_unidad,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	sum(d.cantidad) as cantidad,
	sum(d.monto) as monto,
	(select nombre from inventario.linea where id=p.id_linea) as nombre_linea,
	(select nombre from inventario.linea where id=p.id_linea_grupo) as nombre_linea_grupo,
	(select nombre from inventario.linea where id=p.id_linea_categoria) as nombre_linea_categoria,
	(select nombre from inventario.linea where id=p.id_linea_marca) as nombre_linea_marca,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto,
	'1' as tipo
from facturacion.factura f
inner join facturacion.detalle_factura d on d.id_factura=f.id
inner join inventario.producto p on p.id=d.id_producto
--where1
 group by 
		d.id_unidad,
		d.id_producto,
		p.id_linea,
		p.id_linea_grupo,
		p.id_linea_categoria,
		p.id_linea_marca
		
union

select 
	(select nombre from inventario.unidad where id=d.id_unidad) as nombre_unidad,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	sum(d.cantidad) as cantidad,
	sum(d.monto) as monto,
	(select nombre from inventario.linea where id=p.id_linea) as nombre_linea,
	(select nombre from inventario.linea where id=p.id_linea_grupo) as nombre_linea_grupo,
	(select nombre from inventario.linea where id=p.id_linea_categoria) as nombre_linea_categoria,
	(select nombre from inventario.linea where id=p.id_linea_marca) as nombre_linea_marca,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto,
	'0' as tipo
from facturacion.nota_credito f
inner join facturacion.deta_nota_credito d on d.id_nota_credito=f.id
inner join inventario.producto p on p.id=d.id_producto
--where2 
group by d.id_unidad,
		d.id_producto,
		p.id_linea,
		p.id_linea_grupo,
		p.id_linea_categoria,
		p.id_linea_marca