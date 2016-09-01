select 
	(select nombre from seguridad.ciudad where id=c.id_ciudad) as nombre_ciudad,
	(select nombre from cartera.ruta where id=c.id_ruta) as nombre_ruta,
	(select nombre from comisiones.vendedor where id=c.id_vendedor) as nombre_vendedor,
	c.codigo,
	c.nombre_completo,
	c.nombre_comercial,
	c.fecha_nacimiento as fecha_nacimiento_dato,
	(select max(direccion) from cartera.direccion where id_cliente=c.id) as direccion_direccion,
	(select string_agg(telefono,',') from cartera.telefono where id_cliente=c.id) as telefono_telefono
from cartera.cliente c
--where