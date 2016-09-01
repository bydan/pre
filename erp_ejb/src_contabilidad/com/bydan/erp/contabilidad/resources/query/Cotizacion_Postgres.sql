select valor_venta 
from contabilidad.tipo_cambio 
where id_moneda=ID_MONEDA 
	   and fecha = (select max(fecha) from contabilidad.tipo_cambio
								where id_moneda=ID_MONEDA and fecha<='FECHA')