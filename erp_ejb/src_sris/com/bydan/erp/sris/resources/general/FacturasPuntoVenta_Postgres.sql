select 
	(select nombre_completo from cartera.cliente where id=f.id_cliente) as nombre_completo_cliente,
	sum(f.total_iva) as total_iva,
	sum(f.total_sin_iva) as total_sin_iva,
	sum(f.iva) as iva,
	sum(f.descuento) as descuento,
	sum(f.total) as total,
	(select ruc from cartera.cliente where id=f.id_cliente) as ruc_cliente
from puntoventa.factura_punto_venta f
--where
 group by 
		f.id_cliente