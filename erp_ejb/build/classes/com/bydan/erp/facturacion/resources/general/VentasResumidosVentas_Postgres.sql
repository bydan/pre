select 
	to_char(f.fecha_emision,'D') as dia,
	sum(f.total_iva) as total_iva,
	sum(f.total_sin_iva) as total_sin_iva,
	sum(f.total_flete) as total_flete,
	sum(f.iva) as iva,
	(select nombre from seguridad.anio where id=f.id_anio) as nombre_anio,
	(select nombre from seguridad.mes where id=f.id_mes) as nombre_mes
from facturacion.factura f
--where
 group by
	f.fecha_emision,
	f.id_anio,
	f.id_mes