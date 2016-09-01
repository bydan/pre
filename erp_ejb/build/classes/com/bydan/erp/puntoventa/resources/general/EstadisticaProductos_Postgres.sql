select 
	(select codigo from inventario.producto p where id=d.id_producto)as codigo_producto,
	(select nombre from inventario.producto p where id=d.id_producto)as nombre_producto,
	d.cantidad * d.precio as cantidad_precio,
	d.cantidad,
	d.id_producto

from puntoventa.factura_punto_venta f inner join puntoventa.detalle_factura_punto_venta d
		on f.id=d.id_factura_punto_venta
--where