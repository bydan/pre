select 
	(select nombre_completo from cartera.cliente where id=f.id_cliente) as nombre_completo_cliente,
	sum(f.total_iva) as total_iva,
	sum(f.total_sin_iva) as total_sin_iva,
	sum(f.total_descuento) as total_descuento,
	sum(f.total) as total,
	sum(f.iva) as iva,
	(select ruc from cartera.cliente where id=f.id_cliente) as ruc_cliente
from facturacion.factura f
--where
 group by 
		f.id_cliente