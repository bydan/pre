select  f.fecha,
	f.iva,
	f.descuento,
	f.id_cliente,
	f.id_caja,
	f.id_usuario,
	(select nombre from puntoventa.caja c where id=f.id_caja)as nombre_caja,
	(select nombre from seguridad.usuario where id=f.id_usuario)as nombre_usuario,
	f.secuencial,
	nombre_cliente,
	codigo_cliente,
	f.subtotal,
	f.iva,
	f.descuento,
	f.financiamiento,
	f.flete,
	f.ice,
	f.total

from puntoventa.factura_punto_venta f
--where