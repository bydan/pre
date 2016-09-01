select  
	f.fecha,
	f.secuencial,
	d.cantidad,
	d.precio,
	d.descuento,
	d.iva,
	d.ice,
	(select nombre from inventario.producto p where id=d.id_producto)as nombre_producto,
	(select nombre from inventario.linea l where id=(select id_linea from inventario.producto p where id=d.id_producto))as nombre_linea,
	(select nombre from inventario.linea l where id=(select id_linea_grupo from inventario.producto p where id=d.id_producto))as nombre_grupo,
	(select nombre from inventario.linea l where id=(select id_linea_categoria from inventario.producto p where id=d.id_producto))as nombre_categoria,
	(select nombre from inventario.linea l where id=(select id_linea_marca from inventario.producto p where id=d.id_producto))as nombre_marca,
	d.id_producto,
	(select id_linea from inventario.producto p where id=d.id_producto)as id_linea,
	(select id_linea_grupo from inventario.producto p where id=d.id_producto)as id_linea_grupo,
	(select id_linea_categoria from inventario.producto p where id=d.id_producto)as id_linea_categoria,
	(select id_linea_marca from inventario.producto p where id=d.id_producto)as id_linea_marca

from puntoventa.factura_punto_venta f inner join puntoventa.detalle_factura_punto_venta d
		on f.id=d.id_factura_punto_venta

--where