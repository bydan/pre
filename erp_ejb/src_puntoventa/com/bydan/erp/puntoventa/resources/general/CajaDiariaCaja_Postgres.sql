select  f.fecha,
	f.iva,
	f.descuento,	
	(select nombre from puntoventa.caja c where id=f.id_caja)as nombre_caja,
	f.secuencial,
	nombre_cliente,
	codigo_cliente,
	f.subtotal,
	f.iva,
	f.descuento,
	f.financiamiento,
	f.flete,
	f.ice,
	f.total,
	f.id_cliente,
	f.id_caja

from puntoventa.factura_punto_venta f
--where