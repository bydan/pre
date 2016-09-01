select 
	(select nombre from comisiones.vendedor where id=v.id_vendedor) as nombre_vendedor,
	v.codigo,
	v.nombre,
	v.ruc,
	v.direccion_domicilio,
	v.telefono
from comisiones.vendedor v
--where
