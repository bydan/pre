select 
	f.fecha,
	f.secuencial,
	(select nombre_completo from cartera.cliente c where id=f.id_cliente)as nombre_cliente,
	f.descuento,
	f.subtotal,
	f.total,
	d.cantidad, 
	d.precio, 
	d.descuento as descuento_producto, 
	d.iva,
	d.serie,
	d.descripcion,
	(select nombre from inventario.producto p where id=d.id_producto)as nombre_producto,
	(select nombre from inventario.bodega b where id=d.id_bodega)as nombre_bodega,
	f.id_cliente,
	d.id_bodega,
	d.id_producto

from puntoventa.factura_punto_venta f inner join puntoventa.detalle_factura_punto_venta d
	on f.id=d.id_factura_punto_venta
--where