select 
	(select nombre from puntoventa.caja c where id=id_caja)as nombre_caja,
	f.fecha,
	f.total,
	f.id_caja
from puntoventa.factura_punto_venta f
--where