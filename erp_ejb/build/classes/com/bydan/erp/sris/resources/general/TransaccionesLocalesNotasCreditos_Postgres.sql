select 
	(select nombre_completo from cartera.cliente where id=n.id_cliente) as nombre_completo_cliente,
	sum(n.total_iva) as total_iva,
	sum(n.total_sin_iva) as total_sin_iva,
	sum(n.iva) as iva,
	sum(n.total) as total,
	(select ruc from cartera.cliente where id=n.id_cliente) as ruc_cliente
from facturacion.nota_credito n
--where
 group by 
		n.id_cliente