select  
	(select nombre_completo from cartera.cliente c where id=f.id_cliente)as nombre_cliente,
	f.fecha,
	f.secuencial,
	d.cantidad,
	d.precio,
	d.descuento,
	d.iva,
	d.ice,
	(select nombre from inventario.producto p where id=d.id_producto)as nombre_producto,
	f.id_cliente,
	d.id_producto

from puntoventa.factura_punto_venta f inner join puntoventa.detalle_factura_punto_venta d
		on f.id=d.id_factura_punto_venta
	
--where
	